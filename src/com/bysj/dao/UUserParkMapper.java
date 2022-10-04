package com.bysj.dao;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserParkDTO;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.UUserPark;

public interface UUserParkMapper {

    UUserPark selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(UUserPark record);

    int updateByPrimaryKey(UUserPark record);

    List<UUserParkDTO> loadModels(@Param("start") Integer start, @Param("limit") Integer limit,@Param("uId") Integer uId,@Param("name") String name  );
    int getTotal(@Param("uId") Integer uId,@Param("name") String name );
    UUserPark selectByRat(@Param("uId") Integer uId,@Param("parkId") Integer parkId);
}
