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
import com.bysj.service.IBBuildService;
import com.bysj.model.BBuild;

@Api(tags = "大厦管理")
@RestController
@RequestMapping("/bBuild")
public class BBuildController {
    @Resource(name="BBuildService")
    private IBBuildService bBuildService;

    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageBuildDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        long count = bBuildService.getTotal(param.getBuildName());

        List<BBuild> bBuildList = bBuildService.loadModels(param.calculateStart(),param.calculateEnd(),param.getBuildName());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(bBuildList);
        grid.setCount( count);
        return grid;
    }

    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody BBuildDTO bBuildDTO) {

        BBuild bBuild = bBuildDTO.toModel();

        boolean succ = bBuildService.save(bBuild);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }

    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody BBuildDTO bBuildDTO) {
        BBuild bBuild=  bBuildService.findModel(bBuildDTO.getId() );
        if(bBuild==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            bBuild = bBuildDTO.toModel();
            boolean succ = bBuildService.update(bBuild);
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
        BBuild model=  bBuildService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = bBuildService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
