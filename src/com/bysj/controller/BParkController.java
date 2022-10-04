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

import com.bysj.model.BPark;
import com.bysj.util.ResponseUtil;
import com.bysj.service.IBParkService;

@Api(tags = "车位管理")
@RestController
@RequestMapping("/bPark")
public class BParkController {
    @Resource(name="BParkService")
    private IBParkService bParkService;
    @ApiOperation(value="获取信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DatagridForLayUI list(@ModelAttribute PageParkDTO param) {

        DatagridForLayUI grid = new DatagridForLayUI();
        long count = bParkService.getTotal(param.getParkBm());
        List<BPark> bParkList = bParkService.loadModels(param.calculateStart(),param.calculateEnd(),param.getParkBm());

        grid.setCode(200);
        grid.setMsg("");
        grid.setData(bParkList);
        grid.setCount( count);
        return grid;
    }
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO add(@RequestBody BParkDTO bParkDTO) {

        BPark bPark = bParkDTO.toModel();
        bPark.setState(0);
        boolean succ = bParkService.save(bPark);
        if(succ){
            return ResDTO.Succ();
        }
        return ResDTO.Err();
    }
    @ApiOperation(value="修改")
    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO update(@RequestBody BParkDTO bParkDTO) {
        BPark bPark=  bParkService.findModel(bParkDTO.getId() );
        if(bPark==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            bParkDTO.setState(bPark.getState());
            bPark = bParkDTO.toModel();
            boolean succ = bParkService.update(bPark);
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
        BPark model=  bParkService.findModel(id);
        if(model==null){
            return ResDTO.ErrMsg("记录不存在!");
        }else{
            boolean succ = bParkService.delete(id);
            if(succ){
                return ResDTO.Succ();
            }
        }
        return ResDTO.Err();
    }

}
