package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.dao.SysVarMapper;
import com.bysj.service.ISysVarService;
import com.bysj.model.SysVar;
import com.bysj.util.SqlUtil;

@Service
public class SysVarService implements ISysVarService {
    @Resource(name="sysVarMapper")
    private SysVarMapper sysVarMapper;

    @Override
    public boolean save(SysVar sysVar) {
        return sysVarMapper.insert(sysVar) > 0;
    }

    @Override
    public boolean update(SysVar sysVar) {
        return sysVarMapper.updateByPrimaryKey(sysVar) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return sysVarMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public SysVar findModel(Integer id) {
        return sysVarMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysVar> loadModels() {
        return sysVarMapper.loadModels();
    }


    @Override
    public SysVar selectByName(String name){
        return sysVarMapper.selectByName(name);
    }
}
