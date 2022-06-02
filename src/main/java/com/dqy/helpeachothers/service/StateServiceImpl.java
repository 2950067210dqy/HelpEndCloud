package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.State;
import com.dqy.helpeachothers.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService{

    @Autowired
    StateMapper stateMapper;
    @Override
    public List<State> getState() {
        return stateMapper.select();
    }

    @Override
    public State selectById(Integer id) {
        return stateMapper.selectById(id);
    }
}
