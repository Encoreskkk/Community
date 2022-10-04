package com.bysj.dao;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserRoomDTO;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.UUserRoom;

public interface UUserRoomMapper {

    UUserRoom selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(UUserRoom record);

    int updateByPrimaryKey(UUserRoom record);

    List<UUserRoomDTO> loadModels(@Param("start") Integer start, @Param("limit") Integer limit,@Param("uId") Integer uId,@Param("name") String name );
    int getTotal(@Param("uId") Integer uId,@Param("name") String name );
    UUserRoom selectByRat(@Param("uId") Integer uId,@Param("roomId") Integer roomId);
}
