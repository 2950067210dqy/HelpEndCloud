package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.HelpInfo;
import com.dqy.helpeachothers.vo.DataCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HelpInfoMapper {

    DataCountVO getCount(@Param("adcode") String adcode);
    List<HelpInfo> selectLimitTo(@Param("limit")Integer limit ,@Param("num") Integer num ,@Param("adcode") String adcode);
    //createTable if not exist
    Boolean createTableIfNotExist(@Param("adcode") String adcode);
    //插入
    Integer insert(@Param(value = "helpinfo") HelpInfo helpInfo);

    Integer setHelp(@Param("id") Integer helpInfoId, @Param("helperid") Integer helpUserid,@Param("adcode") String adcode);
    Integer setCancelByMe(@Param("id") Integer helpInfoId,@Param("adcode") String adcode);
    Integer setCancelByHelper(@Param("id") Integer helpInfoId,@Param("adcode") String adcode);
    Integer setFinishByHelper(@Param("id") Integer helpInfoId,@Param("adcode") String adcode);

    HelpInfo selectById(@Param("id") Integer helpInfoId,@Param("adcode") String adcode);

    DataCountVO getByUserIdAndStateCount(@Param("userid") Integer userId, @Param("state") Integer state,@Param("adcode") String adcode);

    DataCountVO getByHelperIdAndStateCount(@Param("helperid")Integer helperid, @Param("state") Integer state,@Param("adcode") String adcode);

    List<HelpInfo> selectByUserIdAndState(@Param("userid") Integer userid, @Param("state") Integer state,@Param("adcode") String adcode);


    List<HelpInfo> selectByHelperIdAndState(@Param("helperid")Integer helperid,  @Param("state")Integer state, @Param("adcode")String adcode);

    HelpInfo selectOkcode(@Param("okcode") String okcode,@Param("id") Integer helpinfoid,@Param("adcode") String adcode);


    List<HelpInfo> selectByAdcode(@Param("adcode") String adcode);
}
