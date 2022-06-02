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
@Repository
@ToString
public class SetHelp {
    Integer id;
    User helperUser;
    State state;
    Timestamp timestamp;
}
