package com.bysj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.*;
import com.bysj.model.BBuild;
import com.bysj.service.IBBuildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bysj.util.ResponseUtil;
import com.bysj.model.BRoom;
import com.bysj.service.IBRoomService;

@Api(tags = "物业房间管理")
@RestController
@RequestMapping("/bRoom")
public class BRoomController {
    @Resource(name="BBuildService")
    private IBBuildService bBuildService;
    @Resource(name="BRoomService")
    private IBRoomService bRoomService;
    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageRoomDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();
        long count = bRoomService.getTotal(param.getFloorBm());
        List<BRoomDTO> bRoomList = bRoomService.loadModels(param.calculateStart(),param.calculateEnd(),param.getFloorBm());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(bRoomList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody BRoomDTO bRoomDTO) {
        BBuild bBuild = bBuildService.findModel(bRoomDTO.getBuildId());
        if(bBuild==null){
            return ResDTO.ErrMsg("大厦信息不存在");
        }
        BRoom bRoom = bRoomDTO.toModel();
        bRoom.setState(0);
        boolean succ = bRoomService.save(bRoom);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody BRoomDTO bRoomDTO) {
        BRoom bRoom=  bRoomService.findModel(bRoomDTO.getId() );
        if(bRoom==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            BBuild bBuild = bBuildService.findModel(bRoomDTO.getBuildId());
            if(bBuild==null){
                return ResDTO.ErrMsg("大厦信息不存在");
            }
            bRoomDTO.setState(bRoom.getState());
            bRoom = bRoomDTO.toModel();
            boolean succ = bRoomService.update(bRoom);
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
        BRoom model=  bRoomService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = bRoomService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
