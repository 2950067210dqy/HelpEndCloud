package com.dqy.helpeachothers.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

//需要 lombok依赖
@Data//自动添加get set方法
@AllArgsConstructor //添加全部参数构造方法
@NoArgsConstructor //添加无参构造方法
@Repository
@ToString
public class CityCode {
    private Integer id;
    private String name;
    private Integer adcode;
    private Integer citycode;
    private Integer level;
    private Integer fatherId;
    private Integer fatherAdcode;


}
