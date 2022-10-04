package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.BRoomDTO;
import org.springframework.stereotype.Service;

import com.bysj.model.BRoom;
import com.bysj.dao.BRoomMapper;
import com.bysj.service.IBRoomService;
import com.bysj.util.SqlUtil;

@Service
public class BRoomService implements IBRoomService {
    @Resource(name="BRoomMapper")
    private BRoomMapper bRoomMapper;

    @Override
    public boolean save(BRoom bRoom) {
        return bRoomMapper.insert(bRoom) > 0;
    }

    @Override
    public boolean update(BRoom bRoom) {
        return bRoomMapper.updateByPrimaryKey(bRoom) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bRoomMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public BRoom findModel(Integer id) {
        return bRoomMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BRoomDTO> loadModels(Integer start, Integer limit,String floorBm) {
        return bRoomMapper.loadModels(start,limit,floorBm);
    }
    @Override
    public int getTotal(String floorBm){
        return bRoomMapper.getTotal(floorBm);
    }
}
