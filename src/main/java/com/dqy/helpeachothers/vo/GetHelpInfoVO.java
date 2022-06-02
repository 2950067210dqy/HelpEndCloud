package com.dqy.helpeachothers.vo;

import com.dqy.helpeachothers.entity.GetHelpInfo;
import com.dqy.helpeachothers.util.HelpInfoPageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Repository
public class GetHelpInfoVO {
    List<GetHelpInfo> datas;
    HelpInfoPageUtil pageUtil;
}
