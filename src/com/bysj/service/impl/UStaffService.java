package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.dao.UStaffMapper;
import com.bysj.service.IUStaffService;
import com.bysj.model.UStaff;
import com.bysj.util.SqlUtil;

@Service
public class UStaffService implements IUStaffService {
    @Resource(name="UStaffMapper")
    private UStaffMapper uStaffMapper;

    @Override
    public boolean save(UStaff uStaff) {
        return uStaffMapper.insert(uStaff) > 0;
    }

    @Override
    public boolean update(UStaff uStaff) {
        return uStaffMapper.updateByPrimaryKey(uStaff) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return uStaffMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UStaff findModel(Integer id) {
        return uStaffMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UStaff> loadModels(Integer start,Integer limit,String name) {
        return uStaffMapper.loadModels(start,limit,name);
    }
    @Override
    public int getTotal(String name){
        return uStaffMapper.getTotal(name);
    }
}
