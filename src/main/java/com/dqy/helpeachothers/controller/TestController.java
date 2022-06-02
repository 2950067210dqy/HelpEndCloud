package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.entity.CityCode;
import com.dqy.helpeachothers.service.CityCodeService;
import com.dqy.helpeachothers.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    CityCodeService cityCodeService;

    ReturnVO returnVO;
    @RequestMapping("/hello")
    public ReturnVO hello(){
        returnVO = new ReturnVO();
        List<CityCode> result=cityCodeService.findAll();
        returnVO.setCode(200);
        returnVO.setMessage("飒飒大苏打");
        returnVO.setDatas(Collections.singletonList(result));
        return returnVO;
    }
}
