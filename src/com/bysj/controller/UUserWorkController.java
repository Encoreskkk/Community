package com.bysj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.bysj.dto.*;
import com.bysj.model.SysVar;
import com.bysj.model.UUser;
import com.bysj.service.ISysVarService;
import com.bysj.service.IUUserService;
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
import com.bysj.service.IUUserWorkService;
import com.bysj.model.UUserWork;

@Api(tags = "业主事项申请及其审批")
@RestController
@RequestMapping("/uUserWork")
public class UUserWorkController {
    @Resource(name="sysVarService")
    private ISysVarService sysVarService;
    @Resource(name="UUserService")
    private IUUserService uUserService;
    @Resource(name="UUserWorkService")
    private IUUserWorkService uUserWorkService;

    @ApiOperation(value="获取事项列表")
    @RequestMapping(value = "/listWork", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI listWork() {
        long count = 0 ;
        DatagridForLayUI grid = new DatagridForLayUI();
        SysVar sysVar = sysVarService.selectByName("work");
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

    @ApiOperation(value="获取列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute ReqUserDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        List<UUserWorkDTO> uUserWorkList = uUserWorkService.loadModels(param.calculateStart(),param.calculateEnd(),param.getuId(),param.getName());
        long count = uUserWorkService.getTotal(param.getuId(),param.getName());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(uUserWorkList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody UUserWorkDTO uUserWorkDTO) {
        if(!StringUtil.isNullOrEmpty(uUserWorkDTO.getContent())) {
            SysVar sysVar = sysVarService.selectByName("work");
            List<JobDTO> jobDTOList = new ArrayList<>();
            if (sysVar != null) {
                jobDTOList = JSON.parseArray(sysVar.getVarVal(), JobDTO.class);
                JobDTO jobDTO = new JobDTO();
                jobDTO.setName(uUserWorkDTO.getContent());
                if (!jobDTOList.contains(jobDTO)) {
                    ResDTO.ErrMsg("申请事项信息有误");
                }
            }
        }
        UUser uUser = uUserService.findModel(uUserWorkDTO.getUId());
        if(uUser==null){
            return ResDTO.ErrMsg("业主信息不存在");
        }
        UUserWork uUserWork = uUserWorkDTO.toModel();
        uUserWork.setIfAduit(0);
        boolean succ = uUserWorkService.save(uUserWork);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody UUserWorkDTO uUserWorkDTO) {
        if(!StringUtil.isNullOrEmpty(uUserWorkDTO.getContent())) {
            SysVar sysVar = sysVarService.selectByName("work");
            List<JobDTO> jobDTOList = new ArrayList<>();
            if (sysVar != null) {
                jobDTOList = JSON.parseArray(sysVar.getVarVal(), JobDTO.class);
                JobDTO jobDTO = new JobDTO();
                jobDTO.setName(uUserWorkDTO.getContent());
                if (!jobDTOList.contains(jobDTO)) {
                    ResDTO.ErrMsg("申请事项信息有误");
                }
            }
        }
        UUser uUser = uUserService.findModel(uUserWorkDTO.getUId());
        if(uUser==null){
            return ResDTO.ErrMsg("业主信息不存在");
        }
        UUserWork uUserWork=  uUserWorkService.findModel(uUserWorkDTO.getId() );
        if(uUserWork==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else if(uUserWork.getIfAduit()==1){
            return ResDTO.ErrMsg("已经审核!");
        }
        else{
            uUserWorkDTO.setIfAduit(0);
            uUserWork = uUserWorkDTO.toModel();
            boolean succ = uUserWorkService.update(uUserWork);
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
        UUserWork model=  uUserWorkService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = uUserWorkService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="审核")
    @RequestMapping(value = "aduit", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO aduit(@RequestBody UUserWorkDTO uUserWorkDTO) {
        if(uUserWorkDTO.getIfAduit()==0){
            return ResDTO.ErrMsg("参数有误!");
        }
        UUserWork model=  uUserWorkService.findModel(uUserWorkDTO.getId());
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            model.setIfAduit(uUserWorkDTO.getIfAduit());
            boolean succ = uUserWorkService.update(model);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }
}
