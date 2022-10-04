package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.BService;

public interface IBServiceService {
    boolean save(BService bService);

    boolean update(BService bService);

    boolean delete(Integer id);

    BService findModel(Integer id);

    List<BService> loadModels(Integer start,Integer limit,String serviceName);
    int getTotal(String serviceName);
}
