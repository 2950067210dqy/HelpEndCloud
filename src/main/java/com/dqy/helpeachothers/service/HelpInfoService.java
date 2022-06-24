package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.*;
import com.dqy.helpeachothers.vo.GetHelpInfoVO;

import java.util.List;

public interface HelpInfoService {

    Integer setHelpInfo(HelpInfo helpInfo);





    //  list[0]装载 分页工具类 HelpInfoPageUtil
    // list[1]装载数据
    GetHelpInfoVO getByPage(Integer currentPage, String adcode, String searchText, String orderBy, String descOrAsc, String fromTime, String toTime, Integer state, Integer type, Integer emergency);

    SetHelp setHelp(Integer helpInfoId, User helpUser,String adcode);

    Integer getByUserIdAndStateCount(Integer userid, Integer state, String tablename);

    Integer getByHelperIdAndStateCount(Integer helperid, Integer state, String tablename);

    Boolean createTableAndStoreTableName(String adcode);

    List<GetMyIssueHelpInfo> getAllByUserIdAndState(Integer userid, Integer state);

    List<GetMyHelpHelpInfo> getAllByHelperIdAndState(Integer helperid, Integer state);

    SetHelp setCancelByMe(Integer helpInfoId, User loginUser, String adcode);

    SetHelp setCancelByHelper(Integer helpInfoId, User loginUser, String adcode);

    SetHelp setFinishByHelper(Integer helpInfoId, User loginUser, String adcode);

    HelpInfo selectOkcode(String okcode, Integer helpinfoid, String adcode);


    List<GetHelpInfo> getByAdcode(String adcode);

    List<GetHelpInfo> selectAll();
}
