package com.bysj.service;

import java.util.List;
import java.util.Map;

import com.bysj.dto.BRoomDTO;
import com.bysj.model.BRoom;

public interface IBRoomService {
    boolean save(BRoom bRoom);

    boolean update(BRoom bRoom);

    boolean delete(Integer id);

    BRoom findModel(Integer id);

    List<BRoomDTO> loadModels(Integer start, Integer limit,String floorBm);

    int getTotal(String floorBm);
}
