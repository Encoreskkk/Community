package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserPayDTO;
import com.bysj.model.UUserPay;

public interface IUUserPayService {
    boolean save(UUserPay uUserPay);

    boolean update(UUserPay uUserPay);

    boolean delete(Integer id);

    UUserPay findModel(Integer id);

    List<UUserPayDTO> loadModels(Integer start, Integer limit,Integer uId,String name);
    int getTotal(Integer uId,String name);
}
