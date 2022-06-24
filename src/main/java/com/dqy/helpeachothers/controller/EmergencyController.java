package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.entity.Emergency;
import com.dqy.helpeachothers.entity.User;
import com.dqy.helpeachothers.service.EmergencyService;
import com.dqy.helpeachothers.service.UserService;
import com.dqy.helpeachothers.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/emergency")
public class EmergencyController {
    @Autowired
    EmergencyService emergencyService;
    @Autowired
    UserService userService;
    ReturnVO returnVO;

    @RequestMapping(value = "/getEmergency",method = RequestMethod.POST)
    public ReturnVO getType(){
        returnVO =new ReturnVO();

        List<Emergency> emergencyList = emergencyService.getEmergency();
        if (emergencyList .size()==0){
            returnVO.setCode(500);
            returnVO.setMessage("获取紧急程度类型空或失败！");
        }else{
            returnVO.setCode(200);
            returnVO.setMessage("获取紧急程度类型成功！");
            returnVO.setDatas(Collections.singletonList(emergencyList ));
        }


        return returnVO;
    }
}
