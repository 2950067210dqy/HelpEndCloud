package com.dqy.helpeachothers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Repository
public class MyIssueEachNum {
    Integer myIssueBy1;
    Integer myIssueBy2;
    Integer myIssueBy3;
    Integer myIssueBy4;
}
