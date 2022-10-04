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
import com.bysj.service.IUUserService;
import com.bysj.model.UUser;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/uUser")
public class UUserController {
    @Resource(name="UUserService")
    private IUUserService uUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute ReqRoleDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        List<UUser> uUserList = uUserService.loadModels(param.calculateStart(),param.calculateEnd(),param.getRole(),param.getName(),param.getPhone(),param.getIdCard());
        long count = uUserService.getTotal(param.getRole(),param.getName(),param.getPhone(),param.getIdCard());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(uUserList);
        grid.setCount( count);
        return grid;
    }

    @ApiOperation(value="注册")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody UUserDTO uUserDTO) {
        UUser user=  uUserService.selectByLogin(uUserDTO.getName());
        if(user!=null){
            return ResDTO.ErrMsg("用户名已存在!");
        }
        UUser uUser = uUserDTO.toModel();

        boolean succ = uUserService.save(uUser);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }

    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody UUserDTO uUserDTO) {
        UUser uUser=  uUserService.findModel(uUserDTO.getId() );
        if(uUser==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            uUserDTO.setPwd(uUser.getPwd());
            uUserDTO.setRole(uUser.getRole());
            uUser = uUserDTO.toModel();
            boolean succ = uUserService.update(uUser);
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
        UUser model=  uUserService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = uUserService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

    @ApiOperation(value="登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO login(@RequestBody LoginDTO loginDTO) {
        UUser uUser=  uUserService.selectByLogin(loginDTO.getName());
        if(uUser==null){
            return ResDTO.ErrMsg("账号密码有误!");
        }else if(!uUser.getPwd().equals(loginDTO.getPwd())){
            return ResDTO.ErrMsg("账号密码有误!");
        }else{
            return ResDTO.Data(uUser);
        }
    }

    @ApiOperation(value="退出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO logout(@RequestBody LoginDTO loginDTO) {
        return ResDTO.Succ();
    }

}
