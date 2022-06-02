package com.dqy.helpeachothers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

//需要 lombok依赖
@Data//自动添加get set方法
@AllArgsConstructor //添加全部参数构造方法
@NoArgsConstructor //添加无参构造方法
@Repository
@ToString
public class HelpInfo {
    Integer id;
    String adcode;
    Double longitude;
    Double latitude;
    String detailLocation;
    String message;
    String title;
    String images;
    Integer emergency;
    Integer type;
    Integer state;
    Integer userid;
    Integer helperid;
    String okcode;
    Date createtime;
    Timestamp updatetime;
}
