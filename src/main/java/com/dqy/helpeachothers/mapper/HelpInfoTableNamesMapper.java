package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.HelpInfoTableNames;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HelpInfoTableNamesMapper {
    @Select("select * from helpinfotablenames")
    List<HelpInfoTableNames> select();

    List<HelpInfoTableNames> selectByName(@Param("name") String tableName);

    Integer insert(@Param("name") String tableName);
}
