package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UStaffWorkDTO;
import com.bysj.model.UStaffWork;

public interface IUStaffWorkService {
    boolean save(UStaffWork uStaffWork);

    boolean update(UStaffWork uStaffWork);

    boolean delete(Integer id);

    UStaffWork findModel(Integer id);

    List<UStaffWorkDTO> loadModels(Integer start, Integer limit, String workContent,String staffName,String beginTime,String endTime);
    int getTotal(String workContent,String staffName,String beginTime,String endTime);
}
