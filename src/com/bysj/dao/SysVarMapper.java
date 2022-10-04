package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.SysVar;

public interface SysVarMapper {

    SysVar selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(SysVar record);

    int updateByPrimaryKey(SysVar record);

    List<SysVar> loadModels();

    SysVar selectByName(@Param("name") String name);
}
