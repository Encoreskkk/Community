package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.UStaff;

public interface IUStaffService {
    boolean save(UStaff uStaff);

    boolean update(UStaff uStaff);

    boolean delete(Integer id);

    UStaff findModel(Integer id);

    List<UStaff> loadModels(Integer start,Integer limit,String name);
    int getTotal(String name);
}
