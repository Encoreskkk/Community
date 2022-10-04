package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.UUserRoomDTO;
import org.springframework.stereotype.Service;

import com.bysj.model.UUserRoom;
import com.bysj.dao.UUserRoomMapper;
import com.bysj.service.IUUserRoomService;
import com.bysj.util.SqlUtil;

@Service
public class UUserRoomService implements IUUserRoomService {
    @Resource(name="UUserRoomMapper")
    private UUserRoomMapper uUserRoomMapper;

    @Override
    public boolean save(UUserRoom uUserRoom) {
        return uUserRoomMapper.insert(uUserRoom) > 0;
    }

    @Override
    public boolean update(UUserRoom uUserRoom) {
        return uUserRoomMapper.updateByPrimaryKey(uUserRoom) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return uUserRoomMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UUserRoom findModel(Integer id) {
        return uUserRoomMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UUserRoomDTO> loadModels(Integer start, Integer limit,Integer uId,String name) {
        return uUserRoomMapper.loadModels(start,limit,uId,name);
    }
    @Override
    public int getTotal(Integer uId,String name){
        return uUserRoomMapper.getTotal(uId,name);
    }
    @Override
    public UUserRoom selectByRat(Integer uId, Integer roomId){
        return uUserRoomMapper.selectByRat(uId,roomId);
    }
}
