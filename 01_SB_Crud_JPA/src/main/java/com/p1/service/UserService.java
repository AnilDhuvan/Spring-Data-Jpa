package com.p1.service;

import java.util.Optional;

import com.p1.entity.User;

public interface UserService {
	
	public boolean userSave(String name,String email,String pwd);
	
	public boolean AllUserSave();
	
	public Optional<User> findById(int id);
	
	public Iterable<User> findAllById(Integer ...id);
	
	public Iterable<User> findAll();
	
	public Long userCount();
	
	public boolean userExistsById(int id);
	
	public void userDeleteById(int id);
	
	public String userDelete(Integer ...id);
	
    public void AllUserDelete();


}
