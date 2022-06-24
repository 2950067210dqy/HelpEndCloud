package com.dqy.helpeachothers.mapper;


import com.dqy.helpeachothers.entity.RateByHelpInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RateByHelpInfoMapper {
    List<RateByHelpInfo> select();

    RateByHelpInfo selectById(@Param("id") Integer id);

    List<RateByHelpInfo> selectByUserId(@Param("userid") Integer userid);

    RateByHelpInfo selectByHelpInfoId(@Param("helpinfoid") Integer helpinfoid, @Param("adcode") String adcode);

    List<RateByHelpInfo> selectByHelperId(@Param("helperid") Integer helperid);

    Integer insert(@Param("rateByHelpInfo") RateByHelpInfo rateByHelpInfo);

}
