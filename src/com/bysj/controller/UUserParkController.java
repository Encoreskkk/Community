package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.*;
import com.bysj.model.*;
import com.bysj.service.IBParkService;
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
import com.bysj.service.IUUserParkService;

@Api(tags = "业主车位管理")
@RestController
@RequestMapping("/uUserPark")
public class UUserParkController {
    @Resource(name="UUserService")
    private IUUserService uUserService;
    @Resource(name="BParkService")
    private IBParkService bParkService;
    @Resource(name="UUserParkService")
    private IUUserParkService uUserParkService;
    @ApiOperation(value="获取列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute ReqUserDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        List<UUserParkDTO> uUserParkList = uUserParkService.loadModels(param.calculateStart(),param.calculateEnd(),param.getuId(),param.getName());
        long count = uUserParkService.getTotal(param.getuId(),param.getName());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(uUserParkList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增业主车位关系")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody UUserParkDTO uUserParkDTO) {
        UUser uUser = uUserService.findModel(uUserParkDTO.getUId());
        if(uUser==null){
            return ResDTO.ErrMsg("业主信息不存在");
        }
        BPark bPark = bParkService.findModel(uUserParkDTO.getParkId());
        if(bPark==null){
            return ResDTO.ErrMsg("车位信息不存在");
        }
        UUserPark userPark = uUserParkService.selectByRat(uUserParkDTO.getUId(),uUserParkDTO.getParkId());
        if(userPark!=null){
            return ResDTO.ErrMsg("关系已存在");
        }
        UUserPark uUserPark = uUserParkDTO.toModel();

        boolean succ = uUserParkService.save(uUserPark);
        if(succ){
            //更新车位为已售
            bPark.setState(1);
            bParkService.update(bPark);
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改业主车位关系")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody UUserParkDTO uUserParkDTO) {
        UUserPark uUserPark=  uUserParkService.findModel(uUserParkDTO.getId() );
        if(uUserPark==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            UUser uUser = uUserService.findModel(uUserParkDTO.getUId());
            if(uUser==null){
                return ResDTO.ErrMsg("业主信息不存在");
            }
            BPark bPark = bParkService.findModel(uUserParkDTO.getParkId());
            if(bPark==null){
                return ResDTO.ErrMsg("车位信息不存在");
            }
            UUserPark userPark = uUserParkService.selectByRat(uUserParkDTO.getUId(),uUserParkDTO.getParkId());
            if(userPark!=null){
                return ResDTO.ErrMsg("关系已存在");
            }
            ////
            if(uUserParkDTO.getParkId()!=uUserPark.getParkId()){
                //更新车位为已售
                bPark.setState(1);
                bParkService.update(bPark);
                BPark bParkOld = bParkService.findModel(uUserPark.getParkId());
                if(bParkOld!=null){
                    bParkOld.setState(0);
                    bParkService.update(bParkOld);
                }
            }
            uUserPark = uUserParkDTO.toModel();
            boolean succ = uUserParkService.update(uUserPark);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="删除业主车位关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer", paramType = "Query"),
    })
    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO del(Integer id) {
        UUserPark model=  uUserParkService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            BPark bPark = bParkService.findModel(model.getParkId());
            //
            if(bPark!=null){
                bPark.setState(0);
                bParkService.update(bPark);
            }
            boolean succ = uUserParkService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
