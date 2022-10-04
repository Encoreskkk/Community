package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.BPark;

public interface IBParkService {
    boolean save(BPark bPark);

    boolean update(BPark bPark);

    boolean delete(Integer id);

    BPark findModel(Integer id);

    List<BPark> loadModels(Integer start,Integer limit,String parkBm);
    int getTotal(String parkBm);
}
