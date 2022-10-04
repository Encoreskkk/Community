package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.service.IBBuildService;
import com.bysj.model.BBuild;
import com.bysj.dao.BBuildMapper;
import com.bysj.util.SqlUtil;

@Service
public class BBuildService implements IBBuildService {
    @Resource(name="BBuildMapper")
    private BBuildMapper bBuildMapper;

    @Override
    public boolean save(BBuild bBuild) {
        return bBuildMapper.insert(bBuild) > 0;
    }

    @Override
    public boolean update(BBuild bBuild) {
        return bBuildMapper.updateByPrimaryKey(bBuild) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bBuildMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public BBuild findModel(Integer id) {
        return bBuildMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BBuild> loadModels(Integer start,Integer limit,String buildName) {
        return bBuildMapper.loadModels(start,limit,buildName);
    }
    @Override
    public int getTotal(String buildName){
        return bBuildMapper.getTotal(buildName);
    }
}
