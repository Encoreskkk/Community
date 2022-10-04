package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.BInfrastructure;

public interface IBInfrastructureService {
    boolean save(BInfrastructure bInfrastructure);

    boolean update(BInfrastructure bInfrastructure);

    boolean delete(Integer id);

    BInfrastructure findModel(Integer id);

    List<BInfrastructure> loadModels(Integer start,Integer limit,String infrastructureName);
    int getTotal(String infrastructureName);
}
