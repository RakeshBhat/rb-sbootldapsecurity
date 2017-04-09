package com.rbsbootldapsecurity.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rbsbootldapsecurity.entity.User;

@Service
public class UserService {

	private static Map<Long, User> users = new HashMap<>();
	
	static{
		users.put(new Long(1000), new User(1000, "user1", "981028ab" , "IndiaND", "Active", String.valueOf(System.currentTimeMillis())));
	}
	
	public void addNewUser(){
		
	}
	
	public User getUserById(Long userId){
		return users.get(userId);
	}
	
	public List<User> getUsers(){
		return null;
	}
}
