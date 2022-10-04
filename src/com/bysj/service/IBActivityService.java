package com.bysj.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bysj.model.BActivity;

public interface IBActivityService {
    boolean save(BActivity bActivity);

    boolean update(BActivity bActivity);

    boolean delete(Integer id);

    BActivity findModel(Integer id);

    List<BActivity> loadModels(Integer start, Integer limit, String activityName, String activityBeginTime, String activityEndTime);
    int getTotal(String activityName, String activityBeginTime, String activityEndTime);
}
