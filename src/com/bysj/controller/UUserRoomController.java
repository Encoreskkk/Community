package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.*;
import com.bysj.model.BBuild;
import com.bysj.model.BRoom;
import com.bysj.model.UUser;
import com.bysj.service.IBRoomService;
import com.bysj.service.IUUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.model.UUserRoom;
import com.bysj.util.ResponseUtil;
import com.bysj.service.IUUserRoomService;

@Api(tags = "业主房间关系变动")
@RestController
@RequestMapping("/uUserRoom")
public class UUserRoomController {
    @Resource(name="UUserService")
    private IUUserService uUserService;
    @Resource(name="BRoomService")
    private IBRoomService bRoomService;
    @Resource(name="UUserRoomService")
    private IUUserRoomService uUserRoomService;
    @ApiOperation(value="获取列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute ReqUserDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();

        List<UUserRoomDTO> uUserRoomList = uUserRoomService.loadModels(param.calculateStart(),param.calculateEnd(),param.getuId(),param.getName());
        long count = uUserRoomService.getTotal(param.getuId(),param.getName());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(uUserRoomList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增关系")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody UUserRoomDTO uUserRoomDTO) {
        UUser uUser = uUserService.findModel(uUserRoomDTO.getUId());
        if(uUser==null){
            return ResDTO.ErrMsg("业主信息不存在");
        }
        BRoom bRoom = bRoomService.findModel(uUserRoomDTO.getRoomId());
        if(bRoom==null){
            return ResDTO.ErrMsg("房间信息不存在");
        }
        UUserRoom userRoom = uUserRoomService.selectByRat(uUserRoomDTO.getUId(),uUserRoomDTO.getRoomId());
        if(userRoom!=null){
            return ResDTO.ErrMsg("关系已存在");
        }
        UUserRoom uUserRoom = uUserRoomDTO.toModel();
        boolean succ = uUserRoomService.save(uUserRoom);
        if(succ){
            //房间变成已入住
            bRoom.setState(1);
            bRoomService.update(bRoom);
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改关系")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody UUserRoomDTO uUserRoomDTO) {
        UUserRoom uUserRoom=  uUserRoomService.findModel(uUserRoomDTO.getId() );
        if(uUserRoom==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            UUser uUser = uUserService.findModel(uUserRoomDTO.getUId());
            if(uUser==null){
                return ResDTO.ErrMsg("业主信息不存在");
            }
            BRoom bRoom = bRoomService.findModel(uUserRoomDTO.getRoomId());
            if(bRoom==null){
                return ResDTO.ErrMsg("房间信息不存在");
            }
            UUserRoom userRoom = uUserRoomService.selectByRat(uUserRoomDTO.getUId(),uUserRoomDTO.getRoomId());
            if(userRoom!=null){
                //return ResDTO.ErrMsg("关系已存在");
            }else {
                ////新房间变成已入住，老房间变成未入住
                if (uUserRoom.getRoomId() != uUserRoomDTO.getRoomId()) {
                    bRoom.setState(1);
                    bRoomService.update(bRoom);
                    BRoom bRoomOld = bRoomService.findModel(uUserRoom.getRoomId());
                    if (bRoomOld != null) {
                        bRoomOld.setState(0);
                        bRoomService.update(bRoomOld);
                    }
                }
            }
            uUserRoom = uUserRoomDTO.toModel();
            boolean succ = uUserRoomService.update(uUserRoom);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="删除关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer", paramType = "Query"),
    })
    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO del(Integer id) {
        UUserRoom model=  uUserRoomService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            BRoom bRoom = bRoomService.findModel(model.getRoomId());
            //房间变成未入住
            if(bRoom!=null){
                bRoom.setState(0);
                bRoomService.update(bRoom);
            }
            boolean succ = uUserRoomService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
