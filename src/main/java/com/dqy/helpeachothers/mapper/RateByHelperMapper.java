package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.RateByHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RateByHelperMapper {
    List<RateByHelper> select();

    RateByHelper selectById(@Param("id") Integer id);

    RateByHelper selectByUserId(@Param("userid") Integer userid);

    Integer insert(@Param("rateByHelper") RateByHelper rateByHelper);

    Integer update(@Param("rateByHelper") RateByHelper rateByHelper1);
}
