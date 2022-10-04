package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.model.BService;
import com.bysj.service.IBServiceService;
import com.bysj.dao.BServiceMapper;
import com.bysj.util.SqlUtil;

@Service
public class BServiceService implements IBServiceService {
    @Resource(name="BServiceMapper")
    private BServiceMapper bServiceMapper;

    @Override
    public boolean save(BService bService) {
        return bServiceMapper.insert(bService) > 0;
    }

    @Override
    public boolean update(BService bService) {
        return bServiceMapper.updateByPrimaryKey(bService) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bServiceMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public BService findModel(Integer id) {
        return bServiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BService> loadModels(Integer start,Integer limit,String serviceName) {
        return bServiceMapper.loadModels(start,limit,serviceName);
    }
    @Override
    public int getTotal(String serviceName){
        return bServiceMapper.getTotal(serviceName);
    }
}
