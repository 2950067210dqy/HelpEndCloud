package com.dqy.helpeachothers.service;


import com.dqy.helpeachothers.entity.State;

import java.util.List;

public interface StateService {

    List<State> getState();

    State selectById(Integer id);
}
