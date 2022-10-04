package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.BGood;

public interface BGoodMapper {

    BGood selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(BGood record);

    int updateByPrimaryKey(BGood record);

    List<BGood> loadModels(@Param("start") Integer start,@Param("limit") Integer limit,@Param("good") String good);
    int getTotal(@Param("good") String good);
}
