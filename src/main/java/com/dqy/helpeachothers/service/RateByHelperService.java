package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.GetRateByHelper;
import com.dqy.helpeachothers.entity.RateByHelper;

import java.util.List;

public interface RateByHelperService {
    List<GetRateByHelper> select();



    GetRateByHelper selectById(Integer id);

    GetRateByHelper selectByUserId(Integer userid);

    Integer insert(RateByHelper rateByHelper);
}
