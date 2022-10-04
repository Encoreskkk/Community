package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.*;
import com.bysj.model.BRoom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.util.ResponseUtil;
import com.bysj.model.BService;
import com.bysj.service.IBServiceService;

@Api(tags = "服务项目管理")
@RestController
@RequestMapping("/bService")
public class BServiceController {
    @Resource(name="BServiceService")
    private IBServiceService bServiceService;
    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageServiceDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();
        long count = bServiceService.getTotal(param.getServiceName());
        List<BService> bServiceList = bServiceService.loadModels(param.calculateStart(),param.calculateEnd(),param.getServiceName());
        grid.setCode(200);
        grid.setMsg("");
        grid.setData(bServiceList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody BServiceDTO bServiceDTO) {

        BService bService = bServiceDTO.toModel();

        boolean succ = bServiceService.save(bService);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody BServiceDTO bServiceDTO) {
        BService bService=  bServiceService.findModel(bServiceDTO.getId() );
        if(bService==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            bService = bServiceDTO.toModel();
            boolean succ = bServiceService.update(bService);
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
        BService model=  bServiceService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = bServiceService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
