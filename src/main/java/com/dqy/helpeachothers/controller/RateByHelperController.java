package com.dqy.helpeachothers.controller;


import com.dqy.helpeachothers.entity.GetRateByHelper;
import com.dqy.helpeachothers.entity.RateByHelper;
import com.dqy.helpeachothers.service.RateByHelperService;
import com.dqy.helpeachothers.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rateByHelper")
public class RateByHelperController {
    @Autowired
    RateByHelperService rateByHelperService;
    ReturnVO returnVO;
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ReturnVO select(){
        returnVO = new ReturnVO();
        List<GetRateByHelper> rateByHelpers = rateByHelperService.select();
        if (rateByHelpers!=null&&rateByHelpers.size()!=0){
            returnVO.setCode(200);
            returnVO.setMessage("查找成功");
            returnVO.setDatas(Collections.singletonList(rateByHelpers));
        }else{
            if (rateByHelpers==null){
                returnVO.setCode(500);
                returnVO.setMessage("查找失败");
            }else {
                returnVO.setCode(500);
                returnVO.setMessage("查找数据为空");
            }
        }
        return  returnVO;
    }
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public ReturnVO selectById(Integer id){
        returnVO = new ReturnVO();
       GetRateByHelper rateByHelper = rateByHelperService.selectById(id);
        if (rateByHelper!=null){
            returnVO.setCode(200);
            returnVO.setMessage("查找成功");
            returnVO.setData(rateByHelper);
        }else{
                returnVO.setCode(500);
                returnVO.setMessage("查找数据失败");
        }
        return  returnVO;
    }
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.POST)
    public ReturnVO selectByUserId(Integer userid){
        returnVO = new ReturnVO();
        GetRateByHelper rateByHelper = rateByHelperService.selectByUserId(userid);
        if (rateByHelper!=null){
            returnVO.setCode(200);
            returnVO.setMessage("查找成功");
            returnVO.setData(rateByHelper);
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("查找数据失败");
        }
        return  returnVO;
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ReturnVO insert(@RequestBody RateByHelper rateByHelper){
        returnVO = new ReturnVO();
        Integer result = rateByHelperService.insert(rateByHelper);
        if (result>0){
            returnVO.setCode(200);
            returnVO.setMessage("添加成功");
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("添加数据失败");
        }
        return  returnVO;
    }

}
