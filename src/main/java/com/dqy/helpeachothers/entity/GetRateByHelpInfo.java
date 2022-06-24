package com.dqy.helpeachothers.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Repository
public class GetRateByHelpInfo {
    RateByHelpInfo rateByHelpInfo;
    HelpInfo helpInfo;
    User user;
    User helper;
}
