package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.User;

public interface UserService {


    public Integer register(User user);
    public User login(String phone,String password);

    public Integer updateHeadImg(User user);

    public Integer update(User user);

    public User selectById(Integer id);
}
