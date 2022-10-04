package com.bysj.dao;

import java.util.List;
import java.util.Map;

import com.bysj.dto.BRoomDTO;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.BRoom;

public interface BRoomMapper {

    BRoom selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(BRoom record);

    int updateByPrimaryKey(BRoom record);

    List<BRoomDTO> loadModels(@Param("start") Integer start, @Param("limit") Integer limit,@Param("floorBm") String floorBm);

    int getTotal(@Param("floorBm") String floorBm);
}
