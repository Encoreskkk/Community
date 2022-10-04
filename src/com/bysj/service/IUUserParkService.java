package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserParkDTO;
import com.bysj.model.UUserPark;

public interface IUUserParkService {
    boolean save(UUserPark uUserPark);

    boolean update(UUserPark uUserPark);

    boolean delete(Integer id);

    UUserPark findModel(Integer id);

    List<UUserParkDTO> loadModels(Integer start, Integer limit,Integer uId,String name);
    int getTotal(Integer uId,String name);
    UUserPark selectByRat(Integer uId, Integer parkId);
}
