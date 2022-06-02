package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {
    String tableName="type";
    @Select("select * from "+tableName)
    List<Type> select();

    Type selectById(Integer id);
}
