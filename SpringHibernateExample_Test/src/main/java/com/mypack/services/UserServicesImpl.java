package com.mypack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypack.dao.UserDao;
import com.mypack.entity.User;

@Service
@Transactional
public class UserServicesImpl implements UserServices{
	@Autowired
	private UserDao userdao;	
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	public User getUserById(int id) {
		User user = userdao.getUserById(id);
		return user;
	}
	public List<User> login(String email, String password) {
		List<User> ulist = userdao.login(email, password);
		return ulist;
	}
	public void save(User user) {
		userdao.save(user);
	}
	public User updateUser(User user) {
		userdao.updateUser(user);
		return user;
	}
	public List<User> getAllUsers() {
		List<User> ulist = userdao.getAllUsers();
		return ulist;
	}
	@Transactional
	public void delete(int id) {
		userdao.delete(id);
	}
	
}
