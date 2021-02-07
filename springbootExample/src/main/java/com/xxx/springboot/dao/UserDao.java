package com.xxx.springboot.dao;

import java.util.List;

import com.xxx.springboot.entity.User;

public interface UserDao {
	List<User> getAllUsers();
    int addUser(User user);
    int deleteUser(User user);
}
