package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.model.BPark;
import com.bysj.dao.BParkMapper;
import com.bysj.service.IBParkService;
import com.bysj.util.SqlUtil;

@Service
public class BParkService implements IBParkService {
    @Resource(name="BParkMapper")
    private BParkMapper bParkMapper;

    @Override
    public boolean save(BPark bPark) {
        return bParkMapper.insert(bPark) > 0;
    }

    @Override
    public boolean update(BPark bPark) {
        return bParkMapper.updateByPrimaryKey(bPark) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bParkMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public BPark findModel(Integer id) {
        return bParkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BPark> loadModels(Integer start,Integer limit,String parkBm) {
        return bParkMapper.loadModels(start,limit,parkBm);
    }
    @Override
    public int getTotal(String parkBm){
        return bParkMapper.getTotal(parkBm);
    }
}
