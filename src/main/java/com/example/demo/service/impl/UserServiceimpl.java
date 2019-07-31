package com.example.demo.service.impl;

import com.example.demo.DAO.UserDAO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private ApplicationContext context;

	@Override
	public User getUserById(Integer userId) {
		UserDAO ud=(UserDAO)context.getBean("UserDAO");
		return ud.findById(userId);
	}

	@Override
	public void saveUser(User user) {
		UserDAO ud=(UserDAO)context.getBean("UserDAO");
		ud.update(user);
	}
	@Override
	public void delUser(User user) {
		UserDAO ud=(UserDAO)context.getBean("UserDAO");
		ud.delete(user);
	}

	@Override
	public List<User> getAllUsers() {
		UserDAO ud=(UserDAO)context.getBean("UserDAO");
		return ud.getAllUsers();

	}
}
