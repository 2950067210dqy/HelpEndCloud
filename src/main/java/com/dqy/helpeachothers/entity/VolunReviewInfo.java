package com.dqy.helpeachothers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;


@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VolunReviewInfo {
    Integer id;
    Integer userid;
    String reviewcomment;
    String reviewstatus;
    String volumentthink;
    Date createtime;
    Timestamp timestamp;
}
