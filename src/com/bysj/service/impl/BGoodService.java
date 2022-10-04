package com.bysj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bysj.service.IBGoodService;
import com.bysj.model.BGood;
import com.bysj.dao.BGoodMapper;
import com.bysj.util.SqlUtil;

@Service
public class BGoodService implements IBGoodService {
    @Resource(name="BGoodMapper")
    private BGoodMapper bGoodMapper;

    @Override
    public boolean save(BGood bGood) {
        return bGoodMapper.insert(bGood) > 0;
    }

    @Override
    public boolean update(BGood bGood) {
        return bGoodMapper.updateByPrimaryKey(bGood) >= 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bGoodMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public BGood findModel(Integer id) {
        return bGoodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BGood> loadModels(Integer start,Integer limit,String good) {
        return bGoodMapper.loadModels(start,limit,good);
    }
    @Override
    public int getTotal(String good){
        return bGoodMapper.getTotal(good);
    }
}
