package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.GetRateByHelper;
import com.dqy.helpeachothers.entity.RateByHelper;
import com.dqy.helpeachothers.entity.User;
import com.dqy.helpeachothers.mapper.RateByHelperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RateByHelperServiceImpl implements RateByHelperService{
    @Autowired
    RateByHelperMapper rateByHelperMapper;
    @Autowired
    UserService userService;
    @Override
    public List<GetRateByHelper> select() {
        List<GetRateByHelper> getRateByHelpers = new ArrayList<>();
        List<RateByHelper> rateByHelpers = rateByHelperMapper.select();
        for (RateByHelper rateByHelper:
                rateByHelpers
             ) {
            User user = userService.selectById(rateByHelper.getUserid());
            GetRateByHelper getRateByHelper = new GetRateByHelper();
            getRateByHelper.setRateByHelper(rateByHelper);
            getRateByHelper.setUser(user);
            getRateByHelpers.add(getRateByHelper);
        }
        return getRateByHelpers;
    }


    @Override
    public GetRateByHelper selectById(Integer id) {
        GetRateByHelper getRateByHelper = null;
        RateByHelper rateByHelper = rateByHelperMapper.selectById(id);
        if (rateByHelper!=null){
            User user = userService.selectById(rateByHelper.getUserid());
            getRateByHelper = new GetRateByHelper();
            getRateByHelper.setRateByHelper(rateByHelper);
            getRateByHelper.setUser(user);
        }
        return  getRateByHelper;
    }

    @Override
    public GetRateByHelper selectByUserId(Integer userid) {
        GetRateByHelper getRateByHelper = null;
        RateByHelper rateByHelper = rateByHelperMapper.selectByUserId(userid);
        if (rateByHelper!=null){
            User user = userService.selectById(userid);
            getRateByHelper = new GetRateByHelper();
            getRateByHelper.setRateByHelper(rateByHelper);
            getRateByHelper.setUser(user);
        }
        return  getRateByHelper;
    }

    @Override
    public Integer insert(RateByHelper rateByHelper) {
        RateByHelper rateByHelper1 = rateByHelperMapper.selectByUserId(rateByHelper.getUserid());
        if (rateByHelper1!=null){
            rateByHelper1.setMannerrate(rateByHelper1.getMannerrate()+rateByHelper.getMannerrate());
            rateByHelper1.setClotherate(rateByHelper1.getClotherate()+rateByHelper.getClotherate());
            rateByHelper1.setServerate(rateByHelper1.getServerate()+rateByHelper.getServerate());
            rateByHelper1.setOntimerate(rateByHelper1.getOntimerate()+rateByHelper.getOntimerate());
            rateByHelper1.setPoliterate(rateByHelper1.getPoliterate()+rateByHelper.getPoliterate());
            rateByHelper1.setHumannum(rateByHelper1.getHumannum()+rateByHelper.getHumannum());
            return rateByHelperMapper.update(rateByHelper1);
        }else{
            return rateByHelperMapper.insert(rateByHelper);
        }

    }
}
