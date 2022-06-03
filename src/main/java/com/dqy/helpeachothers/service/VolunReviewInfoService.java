package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.VolunReviewInfo;

public interface VolunReviewInfoService {
    Integer insert(VolunReviewInfo volunReviewInfo);

    VolunReviewInfo getByUserIdNew(Integer userid);
}
