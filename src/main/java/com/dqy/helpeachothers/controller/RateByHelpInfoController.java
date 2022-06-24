package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.entity.GetRateByHelpInfo;
import com.dqy.helpeachothers.entity.GetRateByHelper;
import com.dqy.helpeachothers.entity.RateByHelpInfo;
import com.dqy.helpeachothers.entity.RateByHelper;
import com.dqy.helpeachothers.service.RateByHelpInfoService;
import com.dqy.helpeachothers.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rateByHelpInfo")
public class RateByHelpInfoController {
    @Autowired
    RateByHelpInfoService rateByHelpInfoService;
    ReturnVO returnVO;
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ReturnVO select(){
        returnVO = new ReturnVO();
        List<GetRateByHelpInfo> rateByHelpers =rateByHelpInfoService.select();
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
        GetRateByHelpInfo rateByHelpInfo = rateByHelpInfoService.selectById(id);
        if (rateByHelpInfo!=null){
            returnVO.setCode(200);
            returnVO.setMessage("查找成功");
            returnVO.setData(rateByHelpInfo);
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("查找数据失败");
        }
        return  returnVO;
    }
    @RequestMapping(value = "/selectByHelperId",method = RequestMethod.POST)
    public ReturnVO selectByHelperId(Integer helperid){
        returnVO = new ReturnVO();
        List<GetRateByHelpInfo> rateByHelpers =rateByHelpInfoService.selectByHelperId(helperid);
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
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.POST)
    public ReturnVO selectByUserId(Integer userid){
        returnVO = new ReturnVO();
        List<GetRateByHelpInfo> rateByHelpers =rateByHelpInfoService.selectByUserId(userid);
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
    @RequestMapping(value = "/selectByHelpInfoId",method = RequestMethod.POST)
    public ReturnVO selectByHelpInfoId(Integer helpinfoid,String adcode){
        returnVO = new ReturnVO();
        List<GetRateByHelpInfo> rateByHelpers =rateByHelpInfoService.selectByHelpInfoId(helpinfoid,adcode);
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
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ReturnVO insert(@RequestBody RateByHelpInfo rateByHelpInfo){
        returnVO = new ReturnVO();
        Integer result = rateByHelpInfoService.insert(rateByHelpInfo);
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
