package com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.UserRepo;
import com.example.demo.model.User;


@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	
	public String RegisterUser(String username,String password, String type) {
		
		try {
			repo.save(new User(username, password, type));
			return "success";
		}catch(Exception e) {
			
			return "error";
		}
	}
	
	public User Login(String username,String password) {
		
		try {
			User user = repo.findByUsername(username);
			
			if(user!=null) {
				if(user.getPassword().equals(password)) {
					return user;
				}else { return null;}
			}else {
				return null;
			}
		}catch(Exception e) {
			
			return null;
		}
		
	}
	

}
