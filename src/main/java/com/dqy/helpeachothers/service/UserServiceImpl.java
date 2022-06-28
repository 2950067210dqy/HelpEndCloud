package com.dqy.helpeachothers.service;

import com.dqy.helpeachothers.entity.User;
import com.dqy.helpeachothers.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper  userMapper;
    @Override
    public Integer register(User user) {
           List<User> repeat =userMapper.selectRepeat(user);
           if (repeat.size()==0){
               Integer result=userMapper.insertAll(user);
               return result;
           }else{
               return -1;
           }
    }
    @Override
    public Integer insert(User user) {
            Integer result=userMapper.insertAll(user);
            return result;

    }
    @Override
    public User  selectRepeat(User user){
        List<User> repeat =userMapper.selectRepeat(user);
        return repeat.get(0);
    }

    @Override
    public User login(String phone, String password) {
        List<User> loginUser=userMapper.login(phone,password);
        if (loginUser.size()==0){
            return null;
        }else {
            return loginUser.get(0);
        }

    }

    @Override
    public Integer updateHeadImg(User user) {
        return userMapper.updateHeadImg(user);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User selectById(Integer id) {

        return userMapper.selectById(id);
    }
}
