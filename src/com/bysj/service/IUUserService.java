package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.model.UUser;
import org.apache.ibatis.annotations.Param;

public interface IUUserService {
    boolean save(UUser uUser);

    boolean update(UUser uUser);

    boolean delete(Integer id);

    UUser findModel(Integer id);

    List<UUser> loadModels(Integer start, Integer limit,Integer role,String name,String phone,String idCard);

    int getTotal(Integer role,String name,String phone,String idCard);

    UUser selectByLogin( String name);
}
