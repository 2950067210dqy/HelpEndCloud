package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.entity.VolunReviewInfo;
import com.dqy.helpeachothers.service.UserService;
import com.dqy.helpeachothers.service.VolunReviewInfoService;
import com.dqy.helpeachothers.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/volunReviewInfo")
@RestController
public class VolunReviewInfoController  {

    @Autowired
    VolunReviewInfoService volunReviewInfoService;

    ReturnVO returnVO;

    @RequestMapping(value = "/set",method = RequestMethod.POST)
    public ReturnVO set(@RequestBody VolunReviewInfo volunReviewInfo){
        returnVO =new ReturnVO();
        Integer result = volunReviewInfoService.insert(volunReviewInfo);
        if (result>0){
            returnVO.setCode(200);
            returnVO.setMessage("存储志愿者信息成功");
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("存储志愿者信息失败");
        }
        return returnVO;
    }

    @RequestMapping(value = "/selectByUserId",method = RequestMethod.POST)
    public ReturnVO selectByUserId( Integer userid){
        returnVO =new ReturnVO();
        VolunReviewInfo volunReviewInfo = volunReviewInfoService.getByUserIdNew(userid);
        if (volunReviewInfo!=null){
            returnVO.setCode(200);
            returnVO.setMessage("获得志愿者信息成功");
            returnVO.setData(volunReviewInfo);
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("获得志愿者信息失败");
        }
        return returnVO;
    }

}
