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
public class RateByHelper {
    Integer id;
    Integer userid;
    Float serverate;
    Float ontimerate;
    Float mannerrate;
    Float politerate;
    Float clotherate;
    Integer humannum;
    Timestamp updatetime;
}
