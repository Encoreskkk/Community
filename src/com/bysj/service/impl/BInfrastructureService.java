package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.model.BInfrastructure;
import com.bysj.service.IBInfrastructureService;
import com.bysj.dao.BInfrastructureMapper;
import com.bysj.util.SqlUtil;

@Service
public class BInfrastructureService implements IBInfrastructureService {
    @Resource(name="BInfrastructureMapper")
    private BInfrastructureMapper bInfrastructureMapper;

    @Override
    public boolean save(BInfrastructure bInfrastructure) {
        return bInfrastructureMapper.insert(bInfrastructure) > 0;
    }

    @Override
    public boolean update(BInfrastructure bInfrastructure) {
        return bInfrastructureMapper.updateByPrimaryKey(bInfrastructure) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bInfrastructureMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public BInfrastructure findModel(Integer id) {
        return bInfrastructureMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BInfrastructure> loadModels(Integer start,Integer limit,String infrastructureName) {
        return bInfrastructureMapper.loadModels(start,limit,infrastructureName);
    }
    @Override
    public int getTotal(String infrastructureName){
        return bInfrastructureMapper.getTotal(infrastructureName);
    }
}
