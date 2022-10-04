package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bysj.dto.UStaffWorkDTO;
import org.springframework.stereotype.Service;

import com.bysj.dao.UStaffWorkMapper;
import com.bysj.model.UStaffWork;
import com.bysj.service.IUStaffWorkService;
import com.bysj.util.SqlUtil;

@Service
public class UStaffWorkService implements IUStaffWorkService {
    @Resource(name="UStaffWorkMapper")
    private UStaffWorkMapper uStaffWorkMapper;

    @Override
    public boolean save(UStaffWork uStaffWork) {
        return uStaffWorkMapper.insert(uStaffWork) > 0;
    }

    @Override
    public boolean update(UStaffWork uStaffWork) {
        return uStaffWorkMapper.updateByPrimaryKey(uStaffWork) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return uStaffWorkMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public UStaffWork findModel(Integer id) {
        return uStaffWorkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UStaffWorkDTO> loadModels(Integer start,Integer limit,String workContent,String staffName,String beginTime,String endTime) {
        return uStaffWorkMapper.loadModels(start,limit,workContent,staffName,beginTime,endTime);
    }
    @Override
    public int getTotal(String workContent,String staffName,String beginTime,String endTime){
        return uStaffWorkMapper.getTotal(workContent,staffName,beginTime,endTime);
    }
}
