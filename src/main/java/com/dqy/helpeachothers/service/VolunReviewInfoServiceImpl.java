package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.VolunReviewInfo;
import com.dqy.helpeachothers.mapper.VolunReviewInfoMapper;
import com.dqy.helpeachothers.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunReviewInfoServiceImpl implements VolunReviewInfoService{
    @Autowired
    TimeUtil timeUtil;
    @Autowired
    VolunReviewInfoMapper volunReviewInfoMapper;
    @Override
    public Integer insert(VolunReviewInfo volunReviewInfo) {
        volunReviewInfo.setCreatetime(timeUtil.getCurrentTime());
        return volunReviewInfoMapper.insert(volunReviewInfo);
    }

    @Override
    public VolunReviewInfo getByUserIdNew(Integer userid) {
        List<VolunReviewInfo> volunReviewInfos =volunReviewInfoMapper.selectByUserIdOrderByUpdateTime(userid);
        if (volunReviewInfos==null||volunReviewInfos.size()==0){
            return null;
        }else{
            return  volunReviewInfos.get(0);
        }

    }
}
