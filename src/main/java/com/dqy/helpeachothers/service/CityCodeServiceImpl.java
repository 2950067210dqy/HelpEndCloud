package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.CityCode;
import com.dqy.helpeachothers.mapper.CityCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityCodeServiceImpl implements CityCodeService{

    @Autowired
    CityCodeMapper cityCodeMapper;

    @Override
    public List<CityCode> findAll() {
        return cityCodeMapper.findAll();
    }

    @Override
    public CityCode getByAdcode(Integer adcode) {
        return cityCodeMapper.getByAdcode(adcode);
    }
}
