package com.bysj.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.BActivity;

public interface BActivityMapper {

    BActivity selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(BActivity record);

    int updateByPrimaryKey(BActivity record);

    List<BActivity> loadModels(@Param("start") Integer start, @Param("limit") Integer limit, @Param("activityName") String activityName, @Param("activityBeginTime")String activityBeginTime, @Param("activityEndTime")String activityEndTime);

    int getTotal(@Param("activityName") String activityName, @Param("activityBeginTime")String activityBeginTime, @Param("activityEndTime")String activityEndTime);
}
