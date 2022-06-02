package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.State;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StateMapper {
    String tableName="state";
    @Select("select * from "+tableName)
    List<State> select();

    State selectById(@Param("id") Integer id);
}
