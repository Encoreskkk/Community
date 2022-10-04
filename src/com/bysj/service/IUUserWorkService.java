package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserWorkDTO;
import com.bysj.model.UUserWork;

public interface IUUserWorkService {
    boolean save(UUserWork uUserWork);

    boolean update(UUserWork uUserWork);

    boolean delete(Integer id);

    UUserWork findModel(Integer id);

    List<UUserWorkDTO> loadModels(Integer start, Integer limit,Integer uId, String name);
    int getTotal(Integer uId,String name);
}
