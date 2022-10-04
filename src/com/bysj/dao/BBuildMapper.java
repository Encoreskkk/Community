package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.BBuild;

public interface BBuildMapper {

    BBuild selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(BBuild record);

    int updateByPrimaryKey(BBuild record);

    List<BBuild> loadModels(@Param("start") Integer start,@Param("limit") Integer limit,@Param("buildName") String buildName);
    int getTotal(@Param("buildName") String buildName);
}
