package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.Emergency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmergencyService {

    List<Emergency> getEmergency();

    Emergency selectById(Integer id);
}
