package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.bysj.dto.*;
import com.bysj.model.UUser;
import com.bysj.service.IUUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.util.ResponseUtil;
import com.bysj.model.UUserPay;
import com.bysj.service.IUUserPayService;

@Api(tags = "业主缴费")
@RestController
@RequestMapping("/uUserPay")
public class UUserPayController {
    @Resource(name="UUserService")
    private IUUserService uUserService;
    @Resource(name="UUserPayService")
    private IUUserPayService uUserPayService;
    @ApiOperation(value="获取缴费列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute ReqUserDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        List<UUserPayDTO> uUserPayList = uUserPayService.loadModels(param.calculateStart(),param.calculateEnd(),param.getuId(),param.getName());
        long count = uUserPayService.getTotal(param.getuId(),param.getName());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(uUserPayList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="缴费")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody UUserPayDTO uUserPayDTO) {
        UUser uUser = uUserService.findModel(uUserPayDTO.getUId());
        if(uUser==null){
            return ResDTO.ErrMsg("业主信息不存在");
        }
        List<BServiceDTO> bServiceDTOS = JSON.parseArray(uUserPayDTO.getPayItem(), BServiceDTO.class);
        if(bServiceDTOS.isEmpty()){
            return ResDTO.ErrMsg("缴费项目不能为空");
        }
        UUserPay uUserPay = uUserPayDTO.toModel();

        boolean succ = uUserPayService.save(uUserPay);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }

//    @RequestMapping(value = "/mod", method = RequestMethod.POST)
//    @ResponseBody
//    public ResDTO update(@RequestBody UUserPayDTO uUserPayDTO) {
//        UUserPay uUserPay=  uUserPayService.findModel(uUserPayDTO.getId() );
//        if(uUserPay==null){
//            return ResDTO.ErrMsg("记录不存在!");
//        }else{
//            uUserPay = uUserPayDTO.toModel();
//            boolean succ = uUserPayService.update(uUserPay);
//            if(succ){
//                return ResDTO.Succ();
//            }
//        }
//        return ResDTO.Err();
//    }
    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer", paramType = "Query"),
    })
    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO del(Integer id) {
        UUserPay model=  uUserPayService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = uUserPayService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
