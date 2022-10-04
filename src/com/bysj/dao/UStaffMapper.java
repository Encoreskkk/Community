package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.UStaff;

public interface UStaffMapper {

    UStaff selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(UStaff record);

    int updateByPrimaryKey(UStaff record);

    List<UStaff> loadModels(@Param("start") Integer start,@Param("limit") Integer limit,@Param("name") String name);
    int getTotal(@Param("name") String name);
}
