package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.BInfrastructure;

public interface BInfrastructureMapper {

    BInfrastructure selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(BInfrastructure record);

    int updateByPrimaryKey(BInfrastructure record);

    List<BInfrastructure> loadModels(@Param("start") Integer start,@Param("limit") Integer limit,@Param("infrastructureName") String infrastructureName);
    int getTotal(@Param("infrastructureName") String infrastructureName);
}
