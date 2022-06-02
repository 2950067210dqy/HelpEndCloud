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
public class MyHelpEachNum {
    Integer myHelpBy2;
    Integer myHelpBy3;
    Integer myHelpBy4;
}
