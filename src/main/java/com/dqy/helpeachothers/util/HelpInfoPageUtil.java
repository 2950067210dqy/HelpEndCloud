package com.dqy.helpeachothers.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HelpInfoPageUtil {

    //每页多少数据
    Integer perPageNum=6;
    //页数
    Integer pageNums;
    //数据总量
    Integer dataNums;
    //当前页
    Integer currentPage;

}
