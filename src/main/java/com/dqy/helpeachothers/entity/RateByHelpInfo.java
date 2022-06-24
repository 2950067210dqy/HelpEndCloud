package com.dqy.helpeachothers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Repository
public class RateByHelpInfo {
    Integer id;
    Integer userid;
    Integer helperid;
    Integer helpinfoid;
    String adcode;
    Integer serverate;
    Integer ontimerate;
    Integer mannerrate;
    Integer politerate;
    Integer clotherate;
    Timestamp createtime;


}
