package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.*;
import com.dqy.helpeachothers.mapper.HelpInfoMapper;
import com.dqy.helpeachothers.util.HelpInfoPageUtil;
import com.dqy.helpeachothers.util.RandomUtil;
import com.dqy.helpeachothers.util.TimeUtil;
import com.dqy.helpeachothers.vo.DataCountVO;
import com.dqy.helpeachothers.vo.GetHelpInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HelpInfoServiceImpl implements HelpInfoService{
    @Autowired
    HelpInfoMapper helpInfoMapper;
    @Autowired
    TimeUtil timeUtil;
    @Autowired
    RandomUtil randomUtil;
    @Autowired
    StateService stateService;
    @Autowired
    TypeService typeService;
    @Autowired
    EmergencyService emergencyService;
    @Autowired
    UserService userService;
    @Autowired
    HelpInfoTableNamesService helpInfoTableNamesService;
    @Autowired
    CityCodeService cityCodeService;
    GetHelpInfoVO getHelpInfoVO;
    HelpInfoPageUtil helpInfoPageUtil;

    @Override
    public  List<GetMyIssueHelpInfo> getAllByUserIdAndState(Integer userid, Integer state) {
        getHelpInfoVO = new GetHelpInfoVO();
        //根据adcode 找出城市名 然后分类 并且弄成前端所需要的数据
        Map<String,List<GetHelpInfo>> hadleLocationDatas= new HashMap<>();
        //获取所有helpinfo 表名
        List<HelpInfoTableNames> helpInfoTableNames = helpInfoTableNamesService.select();
        for (HelpInfoTableNames helpInfoTableName:helpInfoTableNames
             ) {
            //获取 每个表的数据
            List<HelpInfo> helpInfos=  helpInfoMapper.selectByUserIdAndState(userid,state,helpInfoTableName.getName());//un

            for (HelpInfo h:helpInfos){
                    String adcode= h.getAdcode();
                    CityCode districtCode=cityCodeService.getByAdcode(Integer.valueOf(adcode));
                    CityCode cityCode =cityCodeService.getByAdcode(Integer.valueOf(districtCode.getFatherAdcode()));
                    CityCode provinceCode =cityCodeService.getByAdcode(Integer.valueOf(cityCode.getFatherAdcode()));
                    String key=adcode+","+provinceCode.getName()+","+cityCode.getName()+","+districtCode.getName();
                    List<GetHelpInfo> datas=null;
                    if (hadleLocationDatas.containsKey(key)){
                        datas=  hadleLocationDatas.get(key);
                    }else{
                        datas =  new ArrayList<>();
                    }
                    GetHelpInfo getHelpInfo = new GetHelpInfo();
                    getHelpInfo.setId(h.getId());
                    getHelpInfo.setAdcode(h.getAdcode());
                    getHelpInfo.setLatitude(h.getLatitude());
                    getHelpInfo.setLongitude(h.getLongitude());
                    getHelpInfo.setDetailLocation(h.getDetailLocation());
                    getHelpInfo.setMessage(h.getMessage());
                    getHelpInfo.setTitle(h.getTitle());
                    getHelpInfo.setImages(Arrays.asList(h.getImages().split(",")));
                    getHelpInfo.setOkcode(h.getOkcode());
                    getHelpInfo.setCreatetime(h.getCreatetime());
                    getHelpInfo.setUpdatetime(h.getUpdatetime());
                    getHelpInfo.setEmergency(emergencyService.selectById(h.getEmergency()));
                    getHelpInfo.setType(typeService.selectById(h.getType()));
                    getHelpInfo.setState(stateService.selectById(h.getState()));
                    getHelpInfo.setUser(userService.selectById(h.getUserid()));
                    getHelpInfo.setHelpUser(userService.selectById(h.getHelperid()));
                    datas.add(getHelpInfo);
                    hadleLocationDatas.put(key,datas);
            }
        }
        //将map键 解析成我们所需要的 样式 并存入
        List<GetMyIssueHelpInfo> getMyIssueHelpInfos = new ArrayList<>();
        for (String key :hadleLocationDatas.keySet()) {
            GetMyIssueHelpInfo getMyIssueHelpInfo = new GetMyIssueHelpInfo();
            String[] splits=key.split(",");
            getMyIssueHelpInfo.setAdcode(splits[0]);
            getMyIssueHelpInfo.setProvince(splits[1]);
            getMyIssueHelpInfo.setCity(splits[2]);
            getMyIssueHelpInfo.setDistrict(splits[3]);
            getMyIssueHelpInfo.setDatas(hadleLocationDatas.get(key));
            getMyIssueHelpInfos.add(getMyIssueHelpInfo);
        }
        return  getMyIssueHelpInfos;
    }

    @Override
    public List<GetMyHelpHelpInfo> getAllByHelperIdAndState(Integer helperid, Integer state) {
        getHelpInfoVO = new GetHelpInfoVO();
        //根据adcode 找出城市名 然后分类 并且弄成前端所需要的数据
        Map<String,List<GetHelpInfo>> hadleLocationDatas= new HashMap<>();
        //获取所有helpinfo 表名
        List<HelpInfoTableNames> helpInfoTableNames = helpInfoTableNamesService.select();
        for (HelpInfoTableNames helpInfoTableName:helpInfoTableNames
        ) {
            //获取 每个表的数据
            List<HelpInfo> helpInfos=  helpInfoMapper.selectByHelperIdAndState(helperid,state,helpInfoTableName.getName());//un

            for (HelpInfo h:helpInfos){
                String adcode= h.getAdcode();
                CityCode districtCode=cityCodeService.getByAdcode(Integer.valueOf(adcode));
                CityCode cityCode =cityCodeService.getByAdcode(Integer.valueOf(districtCode.getFatherAdcode()));
                CityCode provinceCode =cityCodeService.getByAdcode(Integer.valueOf(cityCode.getFatherAdcode()));
                String key=adcode+","+provinceCode.getName()+","+cityCode.getName()+","+districtCode.getName();
                List<GetHelpInfo> datas=null;
                if (hadleLocationDatas.containsKey(key)){
                    datas=  hadleLocationDatas.get(key);
                }else{
                    datas =  new ArrayList<>();
                }
                GetHelpInfo getHelpInfo = new GetHelpInfo();
                getHelpInfo.setId(h.getId());
                getHelpInfo.setAdcode(h.getAdcode());
                getHelpInfo.setLatitude(h.getLatitude());
                getHelpInfo.setLongitude(h.getLongitude());
                getHelpInfo.setDetailLocation(h.getDetailLocation());
                getHelpInfo.setMessage(h.getMessage());
                getHelpInfo.setTitle(h.getTitle());
                getHelpInfo.setImages(Arrays.asList(h.getImages().split(",")));
                getHelpInfo.setCreatetime(h.getCreatetime());
                getHelpInfo.setUpdatetime(h.getUpdatetime());
                getHelpInfo.setEmergency(emergencyService.selectById(h.getEmergency()));
                getHelpInfo.setType(typeService.selectById(h.getType()));
                getHelpInfo.setState(stateService.selectById(h.getState()));
                getHelpInfo.setUser(userService.selectById(h.getUserid()));
                getHelpInfo.setHelpUser(userService.selectById(h.getHelperid()));
                datas.add(getHelpInfo);
                hadleLocationDatas.put(key,datas);
            }
        }
        //将map键 解析成我们所需要的 样式 并存入
        List<GetMyHelpHelpInfo> getMyHelpHelpInfos = new ArrayList<>();
        for (String key :hadleLocationDatas.keySet()) {
            GetMyHelpHelpInfo getMyHelpHelpInfo = new GetMyHelpHelpInfo();
            String[] splits=key.split(",");
            getMyHelpHelpInfo.setAdcode(splits[0]);
            getMyHelpHelpInfo.setProvince(splits[1]);
            getMyHelpHelpInfo.setCity(splits[2]);
            getMyHelpHelpInfo.setDistrict(splits[3]);
            getMyHelpHelpInfo.setDatas(hadleLocationDatas.get(key));
            getMyHelpHelpInfos.add(getMyHelpHelpInfo);
        }
        return  getMyHelpHelpInfos;
    }

    @Override
    public SetHelp setCancelByMe(Integer helpInfoId, User loginUser, String adcode) {
        Boolean isCreate =createTableAndStoreTableName( adcode);
        if (isCreate){
            Integer result = helpInfoMapper.setCancelByMe(helpInfoId,adcode);
            if (result==1){
                HelpInfo helpInfo=helpInfoMapper.selectById(helpInfoId,adcode);
                if (helpInfo!=null){
                    SetHelp setHelp=new SetHelp();
                    setHelp.setId(helpInfo.getId());
                    setHelp.setHelperUser(null);
                    setHelp.setState(stateService.selectById(helpInfo.getState()));
                    setHelp.setTimestamp(helpInfo.getUpdatetime());
                    return setHelp;
                }else {
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public SetHelp setCancelByHelper(Integer helpInfoId, User loginUser, String adcode) {
        Boolean isCreate =createTableAndStoreTableName( adcode);
        if (isCreate){
            Integer result = helpInfoMapper.setCancelByHelper(helpInfoId,adcode);
            if (result==1){
                HelpInfo helpInfo=helpInfoMapper.selectById(helpInfoId,adcode);
                if (helpInfo!=null){
                    SetHelp setHelp=new SetHelp();
                    setHelp.setId(helpInfo.getId());
                    setHelp.setHelperUser(null);
                    setHelp.setState(stateService.selectById(helpInfo.getState()));
                    setHelp.setTimestamp(helpInfo.getUpdatetime());
                    return setHelp;
                }else {
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public SetHelp setFinishByHelper(Integer helpInfoId, User loginUser, String adcode) {
        Boolean isCreate =createTableAndStoreTableName( adcode);
        if (isCreate){
            Integer result = helpInfoMapper.setFinishByHelper(helpInfoId,adcode);
            if (result==1){
                HelpInfo helpInfo=helpInfoMapper.selectById(helpInfoId,adcode);
                if (helpInfo!=null){
                    SetHelp setHelp=new SetHelp();
                    setHelp.setId(helpInfo.getId());
                    setHelp.setHelperUser(null);
                    setHelp.setState(stateService.selectById(helpInfo.getState()));
                    setHelp.setTimestamp(helpInfo.getUpdatetime());
                    return setHelp;
                }else {
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public HelpInfo selectOkcode(String okcode, Integer helpinfoid, String adcode) {
        return helpInfoMapper.selectOkcode(okcode,helpinfoid,adcode);
    }

    @Override
    public List<GetHelpInfo> getByAdcode(String adcode) {
        List<HelpInfo> helpInfos=helpInfoMapper.selectByAdcode(adcode);
        List<GetHelpInfo> datas =  new ArrayList<>();
        for (HelpInfo h:helpInfos
        ) {
            GetHelpInfo getHelpInfo = new GetHelpInfo();
            getHelpInfo.setId(h.getId());
            getHelpInfo.setAdcode(h.getAdcode());
            getHelpInfo.setLatitude(h.getLatitude());
            getHelpInfo.setLongitude(h.getLongitude());
            getHelpInfo.setDetailLocation(h.getDetailLocation());
            getHelpInfo.setMessage(h.getMessage());
            getHelpInfo.setTitle(h.getTitle());
            getHelpInfo.setImages(Arrays.asList(h.getImages().split(",")));
            getHelpInfo.setCreatetime(h.getCreatetime());
            getHelpInfo.setUpdatetime(h.getUpdatetime());
            getHelpInfo.setEmergency(emergencyService.selectById(h.getEmergency()));
            getHelpInfo.setType(typeService.selectById(h.getType()));
            getHelpInfo.setState(stateService.selectById(h.getState()));
            getHelpInfo.setUser(userService.selectById(h.getUserid()));
            getHelpInfo.setHelpUser(userService.selectById(h.getHelperid()));
            datas.add(getHelpInfo);
        }
        return datas;
    }

    @Override
    public HelpInfo getByAdcodeAndIdPure(String adcode, Integer id) {
        HelpInfo helpInfo=helpInfoMapper.selectById(id,adcode);
        return helpInfo;
    }

    @Override
    public List<GetHelpInfo> selectAll() {
        List<GetHelpInfo> datas =  new ArrayList<>();
        //获取所有helpinfo 表名
        List<HelpInfoTableNames> helpInfoTableNames = helpInfoTableNamesService.select();
        for (HelpInfoTableNames helpInfoTableName:helpInfoTableNames
        ) {
            List<HelpInfo> helpInfos=helpInfoMapper.selectByAdcode(helpInfoTableName.getName());
            for (HelpInfo h:helpInfos
            ) {
                GetHelpInfo getHelpInfo = new GetHelpInfo();
                getHelpInfo.setId(h.getId());
                getHelpInfo.setAdcode(h.getAdcode());
                getHelpInfo.setLatitude(h.getLatitude());
                getHelpInfo.setLongitude(h.getLongitude());
                getHelpInfo.setDetailLocation(h.getDetailLocation());
                getHelpInfo.setMessage(h.getMessage());
                getHelpInfo.setTitle(h.getTitle());
                getHelpInfo.setImages(Arrays.asList(h.getImages().split(",")));
                getHelpInfo.setCreatetime(h.getCreatetime());
                getHelpInfo.setUpdatetime(h.getUpdatetime());
                getHelpInfo.setEmergency(emergencyService.selectById(h.getEmergency()));
                getHelpInfo.setType(typeService.selectById(h.getType()));
                getHelpInfo.setState(stateService.selectById(h.getState()));
                getHelpInfo.setUser(userService.selectById(h.getUserid()));
                getHelpInfo.setHelpUser(userService.selectById(h.getHelperid()));
                datas.add(getHelpInfo);
            }
        }

        return datas;
    }


    @Override
    public  GetHelpInfoVO getByPage(Integer currentPage, String adcode, String searchText, String orderBy, String descOrAsc, String fromTime, String toTime, Integer state, Integer type, Integer emergency) {
        getHelpInfoVO = new GetHelpInfoVO();
        helpInfoPageUtil = new HelpInfoPageUtil();
        Boolean isCreate =createTableAndStoreTableName( adcode);
       if (isCreate){
           helpInfoPageUtil.setDataNums(helpInfoMapper.getCount(adcode,searchText,orderBy,descOrAsc,fromTime,toTime,state,type,emergency).getCount());
           if (helpInfoPageUtil.getDataNums()>0){
               helpInfoPageUtil.setPageNums(helpInfoPageUtil.getDataNums()/helpInfoPageUtil.getPerPageNum()+(helpInfoPageUtil.getDataNums()%helpInfoPageUtil.getPerPageNum()==0?0:1));
           }else{
               helpInfoPageUtil.setPageNums(1);
           }
           if (currentPage<1){
               helpInfoPageUtil.setCurrentPage(1);
           }else if(currentPage>helpInfoPageUtil.getPageNums()){
               helpInfoPageUtil.setCurrentPage(helpInfoPageUtil.getPageNums());
           }else{
               helpInfoPageUtil.setCurrentPage(currentPage);
           }

           Integer limit=(helpInfoPageUtil.getCurrentPage()-1)*helpInfoPageUtil.getPerPageNum();
           Integer num=helpInfoPageUtil.getPerPageNum();
           if (limit+num>helpInfoPageUtil.getDataNums()) {
               num = helpInfoPageUtil.getDataNums() - limit;
           }

           List<HelpInfo> helpInfos=helpInfoMapper.selectLimitTo(limit,num,adcode,searchText,orderBy,descOrAsc,fromTime,toTime,state,type,emergency);
           List<GetHelpInfo> datas =  new ArrayList<>();
           for (HelpInfo h:helpInfos
           ) {
               GetHelpInfo getHelpInfo = new GetHelpInfo();
               getHelpInfo.setId(h.getId());
               getHelpInfo.setAdcode(h.getAdcode());
               getHelpInfo.setLatitude(h.getLatitude());
               getHelpInfo.setLongitude(h.getLongitude());
               getHelpInfo.setDetailLocation(h.getDetailLocation());
               getHelpInfo.setMessage(h.getMessage());
               getHelpInfo.setTitle(h.getTitle());
               getHelpInfo.setImages(Arrays.asList(h.getImages().split(",")));
               getHelpInfo.setCreatetime(h.getCreatetime());
               getHelpInfo.setUpdatetime(h.getUpdatetime());
               getHelpInfo.setEmergency(emergencyService.selectById(h.getEmergency()));
               getHelpInfo.setType(typeService.selectById(h.getType()));
               getHelpInfo.setState(stateService.selectById(h.getState()));
               getHelpInfo.setUser(userService.selectById(h.getUserid()));
               getHelpInfo.setHelpUser(userService.selectById(h.getHelperid()));
               datas.add(getHelpInfo);
           }
           getHelpInfoVO.setDatas(datas);
           getHelpInfoVO.setPageUtil(helpInfoPageUtil);
           return getHelpInfoVO;
       }else {
           return null;
       }
//        DataCountVO dataCountVO =helpInfoMapper.getCount(adcode);

    }

    @Override
    public SetHelp setHelp(Integer helpInfoId, User helpUser,String adcode) {
        Boolean isCreate =createTableAndStoreTableName( adcode);
        if (isCreate){
            Integer result = helpInfoMapper.setHelp(helpInfoId, helpUser.getId(),adcode);
            if (result==1){
                HelpInfo helpInfo=helpInfoMapper.selectById(helpInfoId,adcode);
                if (helpInfo!=null){
                    SetHelp setHelp=new SetHelp();
                    setHelp.setId(helpInfo.getId());
                    setHelp.setHelperUser(helpUser);
                    setHelp.setState(stateService.selectById(helpInfo.getState()));
                    setHelp.setTimestamp(helpInfo.getUpdatetime());
                    return setHelp;
                }else {
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }


    }

    @Override
    public Integer getByUserIdAndStateCount(Integer userId, Integer state, String adcode) {
        DataCountVO dataCountVO =null;
        dataCountVO=helpInfoMapper.getByUserIdAndStateCount(userId,state,adcode);
        if (dataCountVO!=null){
            return dataCountVO.getCount();
        }else{
            return 0;
        }

    }

    @Override
    public Integer getByHelperIdAndStateCount(Integer helperid, Integer state, String adcode) {
        DataCountVO dataCountVO =null;
        dataCountVO=helpInfoMapper.getByHelperIdAndStateCount(helperid,state,adcode);
        if (dataCountVO!=null){
            return dataCountVO.getCount();
        }else{
            return 0;
        }
    }

    @Override
    public Boolean createTableAndStoreTableName(String adcode) {
        Boolean result=helpInfoMapper.createTableIfNotExist(adcode);
        List<HelpInfoTableNames> helpInfoTableNames= helpInfoTableNamesService.selectByName(adcode);
        if (helpInfoTableNames!=null&&helpInfoTableNames.size()==0){
            Integer result0 =helpInfoTableNamesService.insert(adcode);
            if(result0!=1){
                return false;
            }else{
                return  true;
            }
        }
        return  true;
    }




    @Override
    public Integer setHelpInfo(HelpInfo helpInfo) {
        helpInfo.setCreatetime(timeUtil.getCurrentTime());
        helpInfo.setOkcode(randomUtil.random());
        Boolean isCreate =createTableAndStoreTableName( helpInfo.getAdcode());
        if (isCreate){
            return helpInfoMapper.insert(helpInfo);
        }else{
            return null;
        }

    }


}
