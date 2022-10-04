package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.dto.UUserRoomDTO;
import com.bysj.model.UUserRoom;
import org.apache.ibatis.annotations.Param;

public interface IUUserRoomService {
    boolean save(UUserRoom uUserRoom);

    boolean update(UUserRoom uUserRoom);

    boolean delete(Integer id);

    UUserRoom findModel(Integer id);

    List<UUserRoomDTO> loadModels(Integer start, Integer limit,Integer uId,String name);
    int getTotal(Integer uId,String name);
    UUserRoom selectByRat(Integer uId, Integer roomId);
}
