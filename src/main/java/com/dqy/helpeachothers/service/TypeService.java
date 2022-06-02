package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.Type;

import java.util.List;

public interface TypeService {

   List<Type> getType();

    Type selectById(Integer id);
}
