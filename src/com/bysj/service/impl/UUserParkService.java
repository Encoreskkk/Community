package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.UUserParkDTO;
import org.springframework.stereotype.Service;

import com.bysj.model.UUserPark;
import com.bysj.dao.UUserParkMapper;
import com.bysj.service.IUUserParkService;
import com.bysj.util.SqlUtil;

@Service
public class UUserParkService implements IUUserParkService {
    @Resource(name="UUserParkMapper")
    private UUserParkMapper uUserParkMapper;

    @Override
    public boolean save(UUserPark uUserPark) {
        return uUserParkMapper.insert(uUserPark) > 0;
    }

    @Override
    public boolean update(UUserPark uUserPark) {
        return uUserParkMapper.updateByPrimaryKey(uUserPark) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return uUserParkMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UUserPark findModel(Integer id) {
        return uUserParkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UUserParkDTO> loadModels(Integer start, Integer limit,Integer uId, String name) {
        return uUserParkMapper.loadModels(start,limit,uId,name);
    }
    @Override
    public int getTotal(Integer uId,String name){
        return uUserParkMapper.getTotal(uId,name);
    }
    @Override
    public UUserPark selectByRat(Integer uId, Integer parkId){
        return uUserParkMapper.selectByRat(uId,parkId);
    }
}
