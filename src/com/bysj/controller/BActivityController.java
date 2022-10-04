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
import com.bysj.model.BActivity;
import com.bysj.service.IBActivityService;


@RestController
@RequestMapping("/bActivity")
@Api(tags = "社区活动")
public class BActivityController {
    @Resource(name="BActivityService")
    private IBActivityService bActivityService;

    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageActivityDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        long count = bActivityService.getTotal(param.getActivityName(),param.getBeginTime(),param.getEndTime());

        List<BActivity> bActivityList = bActivityService.loadModels(param.calculateStart(),param.calculateEnd(),param.getActivityName(),param.getBeginTime(),param.getEndTime());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(bActivityList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody BActivityDTO bActivityDTO) {

        BActivity bActivity = bActivityDTO.toModel();

        boolean succ = bActivityService.save(bActivity);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody BActivityDTO bActivityDTO) {
        BActivity model=  bActivityService.findModel(bActivityDTO.getId() );
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            model = bActivityDTO.toModel();
            boolean succ = bActivityService.update(model);
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
        BActivity model=  bActivityService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = bActivityService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
