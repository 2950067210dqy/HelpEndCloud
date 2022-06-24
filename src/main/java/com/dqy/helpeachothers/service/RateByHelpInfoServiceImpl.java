package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.GetRateByHelpInfo;
import com.dqy.helpeachothers.entity.HelpInfo;
import com.dqy.helpeachothers.entity.RateByHelpInfo;
import com.dqy.helpeachothers.entity.User;
import com.dqy.helpeachothers.mapper.RateByHelpInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RateByHelpInfoServiceImpl implements RateByHelpInfoService{
    @Autowired
    RateByHelpInfoMapper rateByHelpInfoMapper;
    @Autowired
    UserService userService;
    @Autowired
    HelpInfoService helpInfoService;
    @Override
    public List<GetRateByHelpInfo> select() {
        List<GetRateByHelpInfo> getRateByHelpInfos = new ArrayList<>();
        List<RateByHelpInfo> rateByHelpInfos =  rateByHelpInfoMapper.select();
        for (RateByHelpInfo rateByHelpInfo:rateByHelpInfos
             ) {
            HelpInfo helpInfo= helpInfoService.getByAdcodeAndIdPure(rateByHelpInfo.getAdcode(),rateByHelpInfo.getHelpinfoid());
            User user = userService.selectById(rateByHelpInfo.getUserid());
            User helper = userService.selectById(rateByHelpInfo.getHelperid());
            GetRateByHelpInfo getRateByHelpInfo = new GetRateByHelpInfo();
            getRateByHelpInfo.setHelpInfo(helpInfo);
            getRateByHelpInfo.setRateByHelpInfo(rateByHelpInfo);
            getRateByHelpInfo.setUser(user);
            getRateByHelpInfo.setHelper(helper);
            getRateByHelpInfos.add(getRateByHelpInfo);
        }
        return  getRateByHelpInfos;
    }

    @Override
    public GetRateByHelpInfo selectById(Integer id) {
        GetRateByHelpInfo getRateByHelpInfo = null;
        RateByHelpInfo rateByHelpInfo =  rateByHelpInfoMapper.selectById(id);
        if (rateByHelpInfo!=null){
            HelpInfo helpInfo= helpInfoService.getByAdcodeAndIdPure(rateByHelpInfo.getAdcode(),rateByHelpInfo.getHelpinfoid());
            User user = userService.selectById(rateByHelpInfo.getUserid());
            User helper = userService.selectById(rateByHelpInfo.getHelperid());
            getRateByHelpInfo = new GetRateByHelpInfo();
            getRateByHelpInfo.setHelpInfo(helpInfo);
            getRateByHelpInfo.setRateByHelpInfo(rateByHelpInfo);
            getRateByHelpInfo.setUser(user);
            getRateByHelpInfo.setHelper(helper);
        }
        return  getRateByHelpInfo;
    }

    @Override
    public List<GetRateByHelpInfo> selectByUserId(Integer userid) {
        List<GetRateByHelpInfo> getRateByHelpInfos = new ArrayList<>();
        List<RateByHelpInfo> rateByHelpInfos =  rateByHelpInfoMapper.selectByUserId(userid);
        for (RateByHelpInfo rateByHelpInfo:rateByHelpInfos
        ) {
            HelpInfo helpInfo= helpInfoService.getByAdcodeAndIdPure(rateByHelpInfo.getAdcode(),rateByHelpInfo.getHelpinfoid());
            User user = userService.selectById(rateByHelpInfo.getUserid());
            User helper = userService.selectById(rateByHelpInfo.getHelperid());
            GetRateByHelpInfo getRateByHelpInfo = new GetRateByHelpInfo();
            getRateByHelpInfo.setHelpInfo(helpInfo);
            getRateByHelpInfo.setRateByHelpInfo(rateByHelpInfo);
            getRateByHelpInfo.setUser(user);
            getRateByHelpInfo.setHelper(helper);
            getRateByHelpInfos.add(getRateByHelpInfo);
        }
        return  getRateByHelpInfos;
    }

    @Override
    public List<GetRateByHelpInfo> selectByHelperId(Integer helperid) {
        List<GetRateByHelpInfo> getRateByHelpInfos = new ArrayList<>();
        List<RateByHelpInfo> rateByHelpInfos =  rateByHelpInfoMapper.selectByHelperId(helperid);
        for (RateByHelpInfo rateByHelpInfo:rateByHelpInfos
        ) {
            HelpInfo helpInfo= helpInfoService.getByAdcodeAndIdPure(rateByHelpInfo.getAdcode(),rateByHelpInfo.getHelpinfoid());
            User user = userService.selectById(rateByHelpInfo.getUserid());
            User helper = userService.selectById(rateByHelpInfo.getHelperid());
            GetRateByHelpInfo getRateByHelpInfo = new GetRateByHelpInfo();
            getRateByHelpInfo.setHelpInfo(helpInfo);
            getRateByHelpInfo.setRateByHelpInfo(rateByHelpInfo);
            getRateByHelpInfo.setUser(user);
            getRateByHelpInfo.setHelper(helper);
            getRateByHelpInfos.add(getRateByHelpInfo);
        }
        return  getRateByHelpInfos;
    }

    @Override
    public GetRateByHelpInfo selectByHelpInfoId(Integer helpinfoid, String adcode) {
        GetRateByHelpInfo getRateByHelpInfo = null;
        RateByHelpInfo rateByHelpInfo =  rateByHelpInfoMapper.selectByHelpInfoId( helpinfoid,adcode);
        if (rateByHelpInfo!=null){
            HelpInfo helpInfo= helpInfoService.getByAdcodeAndIdPure(rateByHelpInfo.getAdcode(),rateByHelpInfo.getHelpinfoid());
            User user = userService.selectById(rateByHelpInfo.getUserid());
            User helper = userService.selectById(rateByHelpInfo.getHelperid());
            getRateByHelpInfo = new GetRateByHelpInfo();
            getRateByHelpInfo.setHelpInfo(helpInfo);
            getRateByHelpInfo.setRateByHelpInfo(rateByHelpInfo);
            getRateByHelpInfo.setUser(user);
            getRateByHelpInfo.setHelper(helper);
        }
        return  getRateByHelpInfo;
    }

    @Override
    public Integer insert(RateByHelpInfo rateByHelpInfo) {
        return rateByHelpInfoMapper.insert(rateByHelpInfo);
    }
}
