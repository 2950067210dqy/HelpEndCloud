package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.HelpInfoTableNames;

import java.util.List;

public interface HelpInfoTableNamesService {

    List<HelpInfoTableNames> select();
    List<HelpInfoTableNames> selectByName(String tableName);
    Integer insert(String tableName);
}
