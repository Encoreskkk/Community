package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.*;
import com.bysj.model.BBuild;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.util.ResponseUtil;
import com.bysj.service.IBGoodService;
import com.bysj.model.BGood;

@Api(tags = "物资采购管理")
@RestController
@RequestMapping("/bGood")
public class BGoodController {
    @Resource(name="BGoodService")
    private IBGoodService bGoodService;
    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageGoodDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        long count = bGoodService.getTotal(param.getGood());

        List<BGood> bGoodList = bGoodService.loadModels(param.calculateStart(),param.calculateEnd(),param.getGood());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(bGoodList);
        grid.setCount( count);
        return grid;

    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody BGoodDTO bGoodDTO) {

        BGood bGood = bGoodDTO.toModel();

        boolean succ = bGoodService.save(bGood);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody BGoodDTO bGoodDTO) {
        BGood bGood=  bGoodService.findModel(bGoodDTO.getId() );
        if(bGood==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            bGood = bGoodDTO.toModel();
            boolean succ = bGoodService.update(bGood);
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
        BGood model=  bGoodService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = bGoodService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
