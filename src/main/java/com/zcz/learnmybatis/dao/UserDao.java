package com.zcz.learnmybatis.dao;

import java.util.List;

import com.zcz.learnmybatis.entity.User;

public interface UserDao {
	public void insert(User user);
	public User findUserById(int userId);
	public List<User> findAllUsers();
}
