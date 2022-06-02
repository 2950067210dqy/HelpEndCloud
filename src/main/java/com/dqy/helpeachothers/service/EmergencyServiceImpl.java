package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.Emergency;
import com.dqy.helpeachothers.mapper.EmergencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyServiceImpl implements EmergencyService{
    @Autowired
    EmergencyMapper emergencyMapper;
    @Override
    public List<Emergency> getEmergency() {
        return emergencyMapper.select();
    }

    @Override
    public Emergency selectById(Integer id) {

        return emergencyMapper.selectById(id);
    }
}
