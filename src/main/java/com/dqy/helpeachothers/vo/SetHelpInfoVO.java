package com.dqy.helpeachothers.vo;

import com.dqy.helpeachothers.entity.HelpInfo;
import com.dqy.helpeachothers.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SetHelpInfoVO {
    HelpInfo helpInfo;
    User user;
}
