package com.dqy.helpeachothers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FullUser {
    User user;
    VolunReviewInfo volunReviewInfo;
}
