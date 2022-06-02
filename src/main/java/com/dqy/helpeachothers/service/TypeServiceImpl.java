package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.Type;
import com.dqy.helpeachothers.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    TypeMapper typeMapper;


    @Override
    public List<Type> getType() {
        return typeMapper.select();
    }

    @Override
    public Type selectById(Integer id) {
        return typeMapper.selectById(id);
    }
}
