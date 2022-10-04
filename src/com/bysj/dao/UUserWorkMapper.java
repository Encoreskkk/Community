package com.bysj.dao;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserWorkDTO;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.UUserWork;

public interface UUserWorkMapper {

    UUserWork selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(UUserWork record);

    int updateByPrimaryKey(UUserWork record);

    List<UUserWorkDTO> loadModels(@Param("start") Integer start, @Param("limit") Integer limit,@Param("uId") Integer uId,@Param("name") String name );
    int getTotal(@Param("uId") Integer uId,@Param("name") String name );
}
