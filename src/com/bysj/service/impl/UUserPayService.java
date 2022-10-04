package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.UUserPayDTO;
import org.springframework.stereotype.Service;

import com.bysj.model.UUserPay;
import com.bysj.dao.UUserPayMapper;
import com.bysj.service.IUUserPayService;
import com.bysj.util.SqlUtil;

@Service
public class UUserPayService implements IUUserPayService {
    @Resource(name="UUserPayMapper")
    private UUserPayMapper uUserPayMapper;

    @Override
    public boolean save(UUserPay uUserPay) {
        return uUserPayMapper.insert(uUserPay) > 0;
    }

    @Override
    public boolean update(UUserPay uUserPay) {
        return uUserPayMapper.updateByPrimaryKey(uUserPay) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return uUserPayMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UUserPay findModel(Integer id) {
        return uUserPayMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UUserPayDTO> loadModels(Integer start, Integer limit,Integer uId,String name) {
        return uUserPayMapper.loadModels(start,limit,uId,name);
    }
    @Override
    public int getTotal(Integer uId,String name){
        return uUserPayMapper.getTotal(uId,name);
    }
}
