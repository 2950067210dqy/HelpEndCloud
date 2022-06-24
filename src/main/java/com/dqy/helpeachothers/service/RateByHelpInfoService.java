package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.GetRateByHelpInfo;
import com.dqy.helpeachothers.entity.RateByHelpInfo;

import java.util.List;

public interface RateByHelpInfoService {
    List<GetRateByHelpInfo> select();

    GetRateByHelpInfo selectById(Integer id);

    List<GetRateByHelpInfo> selectByUserId(Integer userid);

    List<GetRateByHelpInfo> selectByHelperId(Integer helperid);

    GetRateByHelpInfo selectByHelpInfoId(Integer helpinfoid, String adcode);

    Integer insert(RateByHelpInfo rateByHelpInfo);
}
