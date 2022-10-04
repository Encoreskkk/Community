package com.bysj.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.model.BActivity;
import com.bysj.dao.BActivityMapper;
import com.bysj.service.IBActivityService;
import com.bysj.util.SqlUtil;

@Service
public class BActivityService implements IBActivityService {
    @Resource(name="BActivityMapper")
    private BActivityMapper bActivityMapper;

    @Override
    public boolean save(BActivity bActivity) {
        return bActivityMapper.insert(bActivity) > 0;
    }

    @Override
    public boolean update(BActivity bActivity) {
        return bActivityMapper.updateByPrimaryKey(bActivity) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bActivityMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public BActivity findModel(Integer id) {
        return bActivityMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BActivity> loadModels(Integer start, Integer limit, String activityName, String activityBeginTime, String activityEndTime) {
        return bActivityMapper.loadModels(start,limit,activityName,activityBeginTime,activityEndTime);
    }

    @Override
    public int getTotal(String activityName, String activityBeginTime, String activityEndTime){
        return bActivityMapper.getTotal(activityName,activityBeginTime,activityEndTime);
    }
}
