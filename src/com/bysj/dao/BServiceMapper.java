package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.BService;

public interface BServiceMapper {

    BService selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(BService record);

    int updateByPrimaryKey(BService record);

    List<BService> loadModels(@Param("start") Integer start,@Param("limit") Integer limit,@Param("serviceName") String serviceName);
    int getTotal(@Param("serviceName") String serviceName);
}
