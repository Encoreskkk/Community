package com.bysj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.bysj.dto.*;
import com.bysj.model.SysVar;
import com.bysj.service.ISysVarService;
import com.bysj.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.util.ResponseUtil;
import com.bysj.service.IUStaffService;
import com.bysj.model.UStaff;

@Api(tags = "员工管理")
@RestController
@RequestMapping("/uStaff")
public class UStaffController {

    @Resource(name="UStaffService")
    private IUStaffService uStaffService;

    @Resource(name="sysVarService")
    private ISysVarService sysVarService;

    @ApiOperation(value="获取职位列表")
    @RequestMapping(value = "/postList", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI postList() {
        long count = 0 ;
        DatagridForLayUI grid = new DatagridForLayUI();
        SysVar sysVar = sysVarService.selectByName("job");
        List<JobDTO> jobDTOList = new ArrayList<>();
        if(sysVar!=null){
            jobDTOList = JSON.parseArray(sysVar.getVarVal(),JobDTO.class);
        }
        grid.setCode(200);
        grid.setMsg("");
        grid.setData(jobDTOList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageStaffDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        List<UStaff> uStaffList = uStaffService.loadModels(param.calculateStart(),param.calculateEnd(),param.getName());
        long count = uStaffService.getTotal(param.getName());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(uStaffList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody UStaffDTO uStaffDTO) {
        if(!StringUtil.isNullOrEmpty(uStaffDTO.getPost())) {
            SysVar sysVar = sysVarService.selectByName("job");
            List<JobDTO> jobDTOList = new ArrayList<>();
            if (sysVar != null) {
                jobDTOList = JSON.parseArray(sysVar.getVarVal(), JobDTO.class);
                JobDTO jobDTO = new JobDTO();
                jobDTO.setName(uStaffDTO.getPost());
                if (!jobDTOList.contains(jobDTO)) {
                    ResDTO.ErrMsg("职位信息有误");
                }
            }
        }
        UStaff uStaff = uStaffDTO.toModel();

        boolean succ = uStaffService.save(uStaff);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody UStaffDTO uStaffDTO) {
        UStaff uStaff=  uStaffService.findModel(uStaffDTO.getId() );
        if(uStaff==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            if(!StringUtil.isNullOrEmpty(uStaffDTO.getPost())) {
                SysVar sysVar = sysVarService.selectByName("job");
                List<JobDTO> jobDTOList = new ArrayList<>();
                if (sysVar != null) {
                    jobDTOList = JSON.parseArray(sysVar.getVarVal(), JobDTO.class);
                    JobDTO jobDTO = new JobDTO();
                    jobDTO.setName(uStaffDTO.getPost());
                    if (!jobDTOList.contains(jobDTO)) {
                        ResDTO.ErrMsg("职位信息有误");
                    }
                }
            }
            uStaff = uStaffDTO.toModel();
            boolean succ = uStaffService.update(uStaff);
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
        UStaff model=  uStaffService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = uStaffService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
