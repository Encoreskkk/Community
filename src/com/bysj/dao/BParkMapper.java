package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.BPark;

public interface BParkMapper {

    BPark selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(BPark record);

    int updateByPrimaryKey(BPark record);

    List<BPark> loadModels(@Param("start") Integer start,@Param("limit") Integer limit,@Param("parkBm") String parkBm);
    int getTotal(@Param("parkBm") String parkBm);
}
