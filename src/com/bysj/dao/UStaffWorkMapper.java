package com.bysj.dao;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UStaffWorkDTO;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.UStaffWork;

public interface UStaffWorkMapper {

    UStaffWork selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(UStaffWork record);

    int updateByPrimaryKey(UStaffWork record);

    List<UStaffWorkDTO> loadModels(@Param("start") Integer start, @Param("limit") Integer limit, @Param("workContent") String workContent,@Param("staffName") String staffName, @Param("beginTime")String beginTime, @Param("endTime")String endTime);
    int getTotal(@Param("workContent") String workContent,@Param("staffName") String staffName, @Param("beginTime")String beginTime, @Param("endTime")String endTime);
}
