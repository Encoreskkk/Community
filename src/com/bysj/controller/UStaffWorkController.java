package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.*;
import com.bysj.model.BBuild;
import com.bysj.model.UStaff;
import com.bysj.service.IUStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.util.ResponseUtil;
import com.bysj.model.UStaffWork;
import com.bysj.service.IUStaffWorkService;

@Api(tags = "员工事务安排管理")
@RestController
@RequestMapping("/uStaffWork")
public class UStaffWorkController {
    @Resource(name="UStaffService")
    private IUStaffService uStaffService;
    @Resource(name="UStaffWorkService")
    private IUStaffWorkService uStaffWorkService;
    @ApiOperation(value="获取列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageWorkDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();
        long count = uStaffWorkService.getTotal(param.getWorkContent(),param.getStaffName(),param.getBeginTime(),param.getEndTime());
        List<UStaffWorkDTO> uStaffWorkList = uStaffWorkService.loadModels(param.calculateStart(),param.calculateEnd(),param.getWorkContent(),param.getStaffName(),param.getBeginTime(),param.getEndTime());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(uStaffWorkList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody UStaffWorkDTO uStaffWorkDTO) {
        UStaff uStaff = uStaffService.findModel(uStaffWorkDTO.getStaffId());
        if(uStaff==null){
            return ResDTO.ErrMsg("员工信息不存在");
        }
        UStaffWork uStaffWork = uStaffWorkDTO.toModel();

        boolean succ = uStaffWorkService.save(uStaffWork);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody UStaffWorkDTO uStaffWorkDTO) {
        UStaffWork uStaffWork=  uStaffWorkService.findModel(uStaffWorkDTO.getId() );
        if(uStaffWork==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            UStaff uStaff = uStaffService.findModel(uStaffWorkDTO.getStaffId());
            if(uStaff==null){
                return ResDTO.ErrMsg("员工信息不存在");
            }
            uStaffWork = uStaffWorkDTO.toModel();
            boolean succ = uStaffWorkService.update(uStaffWork);
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
        UStaffWork model=  uStaffWorkService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = uStaffWorkService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
