package com.mypack.services;

import java.util.List;

import com.mypack.entity.User;

public interface UserServices {
	public User getUserById(int id);
	public List<User> login(String email,String password);
	public void save(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public void delete(int id);
}
