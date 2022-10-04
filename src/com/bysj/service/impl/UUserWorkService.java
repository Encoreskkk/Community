package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.UUserWorkDTO;
import org.springframework.stereotype.Service;

import com.bysj.dao.UUserWorkMapper;
import com.bysj.service.IUUserWorkService;
import com.bysj.model.UUserWork;
import com.bysj.util.SqlUtil;

@Service
public class UUserWorkService implements IUUserWorkService {
    @Resource(name="UUserWorkMapper")
    private UUserWorkMapper uUserWorkMapper;

    @Override
    public boolean save(UUserWork uUserWork) {
        return uUserWorkMapper.insert(uUserWork) > 0;
    }

    @Override
    public boolean update(UUserWork uUserWork) {
        return uUserWorkMapper.updateByPrimaryKey(uUserWork) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return uUserWorkMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UUserWork findModel(Integer id) {
        return uUserWorkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UUserWorkDTO> loadModels(Integer start, Integer limit,Integer uId,String name) {
        return uUserWorkMapper.loadModels(start,limit,uId,name);
    }
    @Override
    public int getTotal(Integer uId,String name){
        return uUserWorkMapper.getTotal(uId,name);
    }
}
