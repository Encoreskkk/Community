package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.dao.UUserMapper;
import com.bysj.service.IUUserService;
import com.bysj.model.UUser;
import com.bysj.util.SqlUtil;

@Service
public class UUserService implements IUUserService {
    @Resource(name="UUserMapper")
    private UUserMapper uUserMapper;

    @Override
    public boolean save(UUser uUser) {
        return uUserMapper.insert(uUser) > 0;
    }

    @Override
    public boolean update(UUser uUser) {
        return uUserMapper.updateByPrimaryKey(uUser) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return uUserMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UUser findModel(Integer id) {
        return uUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UUser> loadModels(Integer start, Integer limit,Integer role,String name,String phone,String idCard) {
        return uUserMapper.loadModels(start,limit,role,name,phone,idCard);
    }

    @Override
    public int getTotal(Integer role,String name,String phone,String idCard){
        return uUserMapper.getTotal(role,name,phone,idCard);
    }

    @Override
    public UUser selectByLogin( String name){
        return uUserMapper.selectByLogin(name);
    }
}
