package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.controller.HelpInfoController;
import com.dqy.helpeachothers.entity.VolunReviewInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VolunReviewInfoMapper {
    Integer insert(@Param("volunReviewInfo") VolunReviewInfo volunReviewInfo);

    List<VolunReviewInfo> selectByUserIdOrderByUpdateTime(@Param("userid") Integer userid);
}
