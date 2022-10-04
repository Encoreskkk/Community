package com.bysj.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.bysj.model.UUser;

public interface UUserMapper {

    UUser selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(UUser record);

    int updateByPrimaryKey(UUser record);

    List<UUser> loadModels(@Param("start") Integer start, @Param("limit") Integer limit,@Param("role") Integer role,@Param("name") String name,@Param("phone") String phone,@Param("idCard") String idCard);

    int getTotal(@Param("role") Integer role,@Param("name") String name,@Param("phone") String phone,@Param("idCard") String idCard);

    UUser selectByLogin(@Param("name") String name);
}
