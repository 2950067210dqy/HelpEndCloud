package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.entity.Type;
import com.dqy.helpeachothers.entity.User;
import com.dqy.helpeachothers.service.TypeService;
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
@RequestMapping(value = "/type")
public class TypeController {

    @Autowired
    TypeService typeService;
    @Autowired
    UserService userService;
    ReturnVO returnVO;

    @RequestMapping(value = "/getType",method = RequestMethod.POST)
    public ReturnVO getType(){
        returnVO =new ReturnVO();

        List<Type> typeList = typeService.getType();
        if (typeList.size()==0){
            returnVO.setCode(500);
            returnVO.setMessage("获取类型空或失败！");
        }else{
            returnVO.setCode(200);
            returnVO.setMessage("获取类型成功！");
            returnVO.setDatas(Collections.singletonList(typeList));
        }


        return returnVO;
    }
}
