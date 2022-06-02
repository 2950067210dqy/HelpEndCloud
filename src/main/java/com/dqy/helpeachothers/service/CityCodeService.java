package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.CityCode;

import java.util.List;


public interface CityCodeService {

    //
    public List<CityCode> findAll();

    CityCode getByAdcode(Integer adcode);
}
