package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.BGood;

public interface IBGoodService {
    boolean save(BGood bGood);

    boolean update(BGood bGood);

    boolean delete(Integer id);

    BGood findModel(Integer id);

    List<BGood> loadModels(Integer start,Integer limit,String good);
    int getTotal(String good);
}
