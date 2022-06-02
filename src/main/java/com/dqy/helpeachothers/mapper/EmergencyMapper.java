package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.Emergency;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmergencyMapper {
    String tableName="emergency";
    @Select("select * from "+tableName)
    List<Emergency> select();

    Emergency selectById(@Param("id") Integer id);
}
