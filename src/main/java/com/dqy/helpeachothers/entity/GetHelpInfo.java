package com.dqy.helpeachothers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Repository
public class GetHelpInfo {
    Integer id;
    String adcode;
    String message;
    String title;
    List<String> images;
    Double longitude;
    Double latitude;
    String detailLocation;
    Emergency emergency;
    Type type;
    State state;
    User user;
    User helpUser;
    String okcode;
    Date createtime;
    Timestamp updatetime;

}
