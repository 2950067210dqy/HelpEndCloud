package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.HelpInfoTableNames;
import com.dqy.helpeachothers.mapper.HelpInfoTableNamesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpInfoTableNamesServiceImpl implements HelpInfoTableNamesService{
    @Autowired
    HelpInfoTableNamesMapper helpInfoTableNamesMapper;
    @Override
    public List<HelpInfoTableNames> select() {
        return helpInfoTableNamesMapper.select();
    }

    @Override
    public List<HelpInfoTableNames> selectByName(String tableName) {
        return helpInfoTableNamesMapper.selectByName(tableName);
    }

    @Override
    public Integer insert(String tableName) {
        return helpInfoTableNamesMapper.insert(tableName);
    }
}
