package com.xxx.springboot.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.springboot.dao.UserDao;
import com.xxx.springboot.entity.User;
import com.xxx.springboot.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public int addUser(User user) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreatedTime(form.format(new Date()));
        return userDao.addUser( user );
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }
}
