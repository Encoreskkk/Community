package com.bysj.dao;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserPayDTO;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.UUserPay;

public interface UUserPayMapper {

    UUserPay selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(UUserPay record);

    int updateByPrimaryKey(UUserPay record);


    List<UUserPayDTO> loadModels(@Param("start") Integer start, @Param("limit") Integer limit,@Param("uId") Integer uId,@Param("name") String name );
    int getTotal(@Param("uId") Integer uId,@Param("name") String name );
}
