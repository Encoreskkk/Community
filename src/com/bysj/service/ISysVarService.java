package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.SysVar;
import org.apache.ibatis.annotations.Param;

public interface ISysVarService {
    boolean save(SysVar sysVar);

    boolean update(SysVar sysVar);

    boolean delete(Integer id);

    SysVar findModel(Integer id);

    List<SysVar> loadModels();


    SysVar selectByName(String name);
}
