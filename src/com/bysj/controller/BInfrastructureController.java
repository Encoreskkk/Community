package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.util.ResponseUtil;
import com.bysj.model.BInfrastructure;
import com.bysj.service.IBInfrastructureService;

@Api(tags = "基础设施管理")
@RestController
@RequestMapping("/bInfrastructure")
public class BInfrastructureController {
    @Resource(name="BInfrastructureService")
    private IBInfrastructureService bInfrastructureService;
    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageInfrastructureDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        long count = bInfrastructureService.getTotal(param.getInfrastructureName());
        List<BInfrastructure> bInfrastructureList = bInfrastructureService.loadModels(param.calculateStart(),param.calculateEnd(),param.getInfrastructureName());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(bInfrastructureList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody BInfrastructureDTO bInfrastructureDTO) {

        BInfrastructure bInfrastructure = bInfrastructureDTO.toModel();

        boolean succ = bInfrastructureService.save(bInfrastructure);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody BInfrastructureDTO bInfrastructureDTO) {
        BInfrastructure bInfrastructure=  bInfrastructureService.findModel(bInfrastructureDTO.getId() );
        if(bInfrastructure==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            bInfrastructure = bInfrastructureDTO.toModel();
            boolean succ = bInfrastructureService.update(bInfrastructure);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer", paramType = "Query"),
    })
    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO del(Integer id) {
        BInfrastructure model=  bInfrastructureService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = bInfrastructureService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
