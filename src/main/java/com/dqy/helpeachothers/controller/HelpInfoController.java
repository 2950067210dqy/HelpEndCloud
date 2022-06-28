package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.entity.*;
import com.dqy.helpeachothers.service.HelpInfoService;
import com.dqy.helpeachothers.service.HelpInfoTableNamesService;
import com.dqy.helpeachothers.service.StateService;
import com.dqy.helpeachothers.service.UserService;
import com.dqy.helpeachothers.vo.GetHelpInfoVO;
import com.dqy.helpeachothers.vo.ReturnVO;
import com.dqy.helpeachothers.vo.SetHelpInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/helpinfo")
public class HelpInfoController {
    @Autowired
    HelpInfoService helpInfoService;
    @Autowired
    UserService userService;
    @Autowired
    HelpInfoTableNamesService helpInfoTableNamesService;
    @Autowired
    StateService stateService;
    GetHelpInfoVO getHelpInfoVO;
    ReturnVO returnVO;

    @RequestMapping(value = "/selectByIdAndAdcode",method = RequestMethod.POST)
    public ReturnVO selectByIdAndAdcode(Integer id,String adcode){
        returnVO = new ReturnVO();
        GetHelpInfo data=null;
        data=helpInfoService.getByAdcodeAndId(adcode,id);
        if (data!=null){
            returnVO.setCode(200);
            returnVO.setMessage("查询成功！");
            returnVO.setData(data);
            return  returnVO;
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("查询数据为空");
            return returnVO;

        }
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public  ReturnVO selectAll(){
        returnVO = new ReturnVO();
        List<GetHelpInfo> datas=new ArrayList<>();
        datas=helpInfoService.selectAll();
        if (datas!=null&&datas.size()>0){
            returnVO.setCode(200);
            returnVO.setMessage("查询成功！");
            returnVO.setDatas(Collections.singletonList(datas));
            return  returnVO;
        }else{
            if (datas==null){
                returnVO.setCode(500);
                returnVO.setMessage("查询数据库错误！");
                return returnVO;
            }
            else {
                returnVO.setCode(500);
                returnVO.setMessage("查询数据为空");
                return returnVO;
            }
        }

    }

    @RequestMapping(value = "/selectByAdcode",method = RequestMethod.POST)
    public  ReturnVO selectByAdcode(String adcode){
        returnVO = new ReturnVO();
        List<GetHelpInfo> datas=new ArrayList<>();
        datas=helpInfoService.getByAdcode(adcode);
        if (datas!=null&&datas.size()>0){
            returnVO.setCode(200);
            returnVO.setMessage("查询成功！");
            returnVO.setDatas(Collections.singletonList(datas));
            return  returnVO;
        }else{
            if (datas==null){
                returnVO.setCode(500);
                returnVO.setMessage("查询数据库错误！");
                return returnVO;
            }
            else {
                returnVO.setCode(500);
                returnVO.setMessage("查询数据为空");
                return returnVO;
            }
        }

    }
    @RequestMapping(value = "/selectOkcode",method = RequestMethod.POST)
    public  ReturnVO selectOkcode(String okcode,Integer helpinfoid,String adcode){
        returnVO = new ReturnVO();
        HelpInfo helpInfo = helpInfoService.selectOkcode(okcode,helpinfoid,adcode);
        if (helpInfo!=null){
            returnVO.setCode(200);
            returnVO.setMessage("校验完成码成功！");
            returnVO.setData(helpInfo);
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("校验完成码错误！");
        }
        return returnVO;
    }
    @RequestMapping(value = "/getAllHelp{state}",method = RequestMethod.POST)
    public ReturnVO getAllHelpByState(@PathVariable(name = "state") Integer state,Integer userid){
        returnVO = new ReturnVO();
        if (userid!=null){
            User loginUser = userService.selectById(userid);
            if (loginUser!=null){

                List<State> states = stateService.getState();
                if (states!=null){
                    List<GetMyHelpHelpInfo> getMyHelpHelpInfos=null;
                    if (state==0){
                        getMyHelpHelpInfos=helpInfoService.getAllByHelperIdAndState(loginUser.getId(),0);
                    }else{
                        getMyHelpHelpInfos=helpInfoService.getAllByHelperIdAndState(loginUser.getId(),states.get(state-1).getId());
                    }
                    returnVO.setCode(200);
                    returnVO.setMessage("获取我的帮忙成功");
                    returnVO.setDatas(Collections.singletonList(getMyHelpHelpInfos));
                }else {
                    returnVO.setCode(500);
                    returnVO.setMessage("获取帮忙工单状态失败");
                }

            }else{
                returnVO.setCode(500);
                returnVO.setMessage("用户校验失败");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("用户为空！");
        }
        return  returnVO;
    }

    @RequestMapping(value = "/getAllIssue{state}",method = RequestMethod.POST)
    public ReturnVO getAllIssueByState(@PathVariable(name = "state") Integer state,Integer userid){
        returnVO = new ReturnVO();
        if (userid!=null){
            User loginUser = userService.selectById(userid);
            if (loginUser!=null){

                List<State> states = stateService.getState();
                if (states!=null){
                    List<GetMyIssueHelpInfo> getMyIssueHelpInfos=null;
                    if (state==0){
                        getMyIssueHelpInfos=helpInfoService.getAllByUserIdAndState(loginUser.getId(),0);
                    }else{
                        getMyIssueHelpInfos=helpInfoService.getAllByUserIdAndState(loginUser.getId(),states.get(state-1).getId());
                    }
                    returnVO.setCode(200);
                    returnVO.setMessage("获取我的发布成功");
                    returnVO.setDatas(Collections.singletonList(getMyIssueHelpInfos));
                }else {
                    returnVO.setCode(500);
                    returnVO.setMessage("获取发布工单状态失败");
                }

            }else{
                returnVO.setCode(500);
                returnVO.setMessage("用户校验失败");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("用户为空！");
        }
        return  returnVO;
    }

    @RequestMapping(value = "/getMyHelpEachNum",method = RequestMethod.POST)
    public ReturnVO getMyHelpEachNum(Integer helperid){
        returnVO = new ReturnVO();
        if (helperid!=null){
            User loginUser = userService.selectById(helperid);
            if (loginUser!=null){
                List<HelpInfoTableNames> helpInfoTableNames = helpInfoTableNamesService.select();
                if (helpInfoTableNames!=null){
                    MyHelpEachNum myHelpEachNum = new MyHelpEachNum(0,0,0);
                    List<State> states = stateService.getState();
                    if (states!=null){
                        for (HelpInfoTableNames tableName:helpInfoTableNames
                        ) {

                            myHelpEachNum.setMyHelpBy2(myHelpEachNum.getMyHelpBy2()+helpInfoService.getByHelperIdAndStateCount(loginUser.getId(),states.get(1).getId(),tableName.getName()));
                            myHelpEachNum.setMyHelpBy3(myHelpEachNum.getMyHelpBy3()+helpInfoService.getByHelperIdAndStateCount(loginUser.getId(),states.get(2).getId(),tableName.getName()));
                            myHelpEachNum.setMyHelpBy4(myHelpEachNum.getMyHelpBy4()+helpInfoService.getByHelperIdAndStateCount(loginUser.getId(),states.get(3).getId(),tableName.getName()));
                        }
                        returnVO.setCode(200);
                        returnVO.setMessage("获取我的帮助各种状态数量成功");
                        returnVO.setData(myHelpEachNum);
                    }else {
                        returnVO.setCode(500);
                        returnVO.setMessage("获取帮助工单状态失败");
                    }
                }else{
                    returnVO.setCode(500);
                    returnVO.setMessage("获取表名失败");
                }
            }else{
                returnVO.setCode(500);
                returnVO.setMessage("用户校验失败");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("用户为空！");
        }
        return  returnVO;
    }

    @RequestMapping(value = "/getMyIssueEachNum",method = RequestMethod.POST)
    public ReturnVO getMyIssueEachNum(Integer userid){
            returnVO = new ReturnVO();
            if (userid!=null){
                   User loginUser = userService.selectById(userid);
                   if (loginUser!=null){
                       List<HelpInfoTableNames> helpInfoTableNames = helpInfoTableNamesService.select();
                       if (helpInfoTableNames!=null){
                           MyIssueEachNum myIssueEachNum = new MyIssueEachNum(0,0,0,0);
                           List<State> states = stateService.getState();
                           if (states!=null){
                               for (HelpInfoTableNames tableName:helpInfoTableNames
                               ) {
                                   myIssueEachNum.setMyIssueBy1(myIssueEachNum.getMyIssueBy1()+helpInfoService.getByUserIdAndStateCount(loginUser.getId(),states.get(0).getId(),tableName.getName()));
                                   myIssueEachNum.setMyIssueBy2(myIssueEachNum.getMyIssueBy2()+helpInfoService.getByUserIdAndStateCount(loginUser.getId(),states.get(1).getId(),tableName.getName()));
                                   myIssueEachNum.setMyIssueBy3(myIssueEachNum.getMyIssueBy3()+helpInfoService.getByUserIdAndStateCount(loginUser.getId(),states.get(2).getId(),tableName.getName()));
                                   myIssueEachNum.setMyIssueBy4(myIssueEachNum.getMyIssueBy4()+helpInfoService.getByUserIdAndStateCount(loginUser.getId(),states.get(3).getId(),tableName.getName()));
                               }
                               returnVO.setCode(200);
                               returnVO.setMessage("获取我的发布各种状态数量成功");
                               returnVO.setData(myIssueEachNum);
                           }else {
                               returnVO.setCode(500);
                               returnVO.setMessage("获取发布工单状态失败");
                           }
                       }else{
                           returnVO.setCode(500);
                           returnVO.setMessage("获取表名失败");
                       }
                   }else{
                       returnVO.setCode(500);
                       returnVO.setMessage("用户校验失败");
                   }
            }else{
                returnVO.setCode(500);
                returnVO.setMessage("用户为空！");
            }
            return  returnVO;
    }

    @RequestMapping(value = "/setHelp",method = RequestMethod.POST)
    public ReturnVO setHelp(Integer helpInfoId,Integer loginUserId,String adcode){
        returnVO = new ReturnVO();
        User loginUser= userService.selectById(loginUserId);
        if (loginUser!=null){
            SetHelp setHelp =helpInfoService.setHelp(helpInfoId,loginUser,adcode);
            if (setHelp!=null){
                returnVO.setCode(200);
                returnVO.setMessage("帮助成功");
                returnVO.setData(setHelp);
            }else{
                returnVO.setCode(500);
                returnVO.setMessage("添加表名到数据库失败");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("用户校验失败");
        }

        return returnVO;
    }

    @RequestMapping(value = "/setCancelByMe",method = RequestMethod.POST)
    public ReturnVO setCancelByMe(Integer helpInfoId,Integer loginUserId,String adcode){
        returnVO = new ReturnVO();
        User loginUser= userService.selectById(loginUserId);
        if (loginUser!=null){
            SetHelp setHelp =helpInfoService.setCancelByMe(helpInfoId,loginUser,adcode);
            if (setHelp!=null){
                returnVO.setCode(200);
                returnVO.setMessage("取消成功");
                returnVO.setData(setHelp);
            }else{
                returnVO.setCode(500);
                returnVO.setMessage("添加表名到数据库失败");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("用户校验失败");
        }

        return returnVO;
    }

    @RequestMapping(value = "/setCancelByHelper",method = RequestMethod.POST)
    public ReturnVO setCancelByHelper(Integer helpInfoId,Integer loginUserId,String adcode){
        returnVO = new ReturnVO();
        User loginUser= userService.selectById(loginUserId);
        if (loginUser!=null){
            SetHelp setHelp =helpInfoService.setCancelByHelper(helpInfoId,loginUser,adcode);
            if (setHelp!=null){
                returnVO.setCode(200);
                returnVO.setMessage("取消成功");
                returnVO.setData(setHelp);
            }else{
                returnVO.setCode(500);
                returnVO.setMessage("添加表名到数据库失败");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("用户校验失败");
        }

        return returnVO;
    }

    @RequestMapping(value = "setFinishByHelper",method = RequestMethod.POST)
    public ReturnVO setFinishByHelper(Integer helpInfoId,Integer loginUserId,String adcode){
        returnVO = new ReturnVO();
        User loginUser= userService.selectById(loginUserId);
        if (loginUser!=null){
            SetHelp setHelp =helpInfoService.setFinishByHelper(helpInfoId,loginUser,adcode);
            if (setHelp!=null){
                returnVO.setCode(200);
                returnVO.setMessage("完成成功");
                returnVO.setData(setHelp);
            }else{
                returnVO.setCode(500);
                returnVO.setMessage("添加表名到数据库失败");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("用户校验失败");
        }

        return returnVO;
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public ReturnVO get(Integer currentPage,String adcode,
                        @RequestParam(required = false,defaultValue = "") String searchText,@RequestParam(required = false,defaultValue = "updateTime") String orderBy,
                        @RequestParam(required = false,defaultValue = "desc") String descOrAsc,@RequestParam(required = false,defaultValue = "") String fromTime,
                        @RequestParam(required = false,defaultValue = "") String toTime, @RequestParam(required = false,defaultValue = "0") Integer state,
                        @RequestParam(required = false,defaultValue = "0") Integer type,@RequestParam(required = false,defaultValue = "0") Integer emergency
                        ){
        returnVO = new ReturnVO();
        getHelpInfoVO=new GetHelpInfoVO();
        getHelpInfoVO=helpInfoService.getByPage(currentPage,adcode,searchText,orderBy,descOrAsc,fromTime,toTime,state,type,emergency);
        if (getHelpInfoVO!=null&&getHelpInfoVO.getDatas()!=null&&getHelpInfoVO.getDatas().size()>0){
            returnVO.setCode(200);
            returnVO.setMessage("查询成功！");
            returnVO.setData(getHelpInfoVO);
            return  returnVO;
        }else{
            if (getHelpInfoVO.getDatas()==null){
                returnVO.setCode(500);
                returnVO.setMessage("查询数据库错误！");
                return returnVO;
            }
            else {
                returnVO.setCode(500);
                returnVO.setMessage("查询数据为空");
                return returnVO;
            }
        }

    }

    @RequestMapping(value = "/setHelpInfo",method = RequestMethod.POST)
    public ReturnVO setHelpInfo(@RequestBody SetHelpInfoVO setHelpInfoVO){
        returnVO = new ReturnVO();
        User correctUser=userService.selectById(setHelpInfoVO.getUser().getId());
        if (correctUser!=null){
            if (setHelpInfoVO.getHelpInfo()!=null){
                if(!setHelpInfoVO.getHelpInfo().getAdcode().equals("")){
                    Integer result = helpInfoService.setHelpInfo(setHelpInfoVO.getHelpInfo());
                    if (result==null||result==0){
                        returnVO.setCode(500);
                        returnVO.setMessage("发布失败！");
                    }else{
                        returnVO.setCode(200);
                        returnVO.setMessage("发布成功");
                    }
                }else{
                    returnVO.setCode(500);
                    returnVO.setMessage("定位失败或为空！");
                }
            }else{
                returnVO.setCode(500);
                returnVO.setMessage("数据为空！");
            }
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("前台用户校验失败！");
        }

        return returnVO;
    }
}
