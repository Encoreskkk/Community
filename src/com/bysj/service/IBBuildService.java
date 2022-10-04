package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.BBuild;

public interface IBBuildService {
    boolean save(BBuild bBuild);

    boolean update(BBuild bBuild);

    boolean delete(Integer id);

    BBuild findModel(Integer id);

    List<BBuild> loadModels(Integer start,Integer limit,String buildName);
    int getTotal(String buildName);
}
