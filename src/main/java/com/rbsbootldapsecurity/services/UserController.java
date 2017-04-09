package com.rbsbootldapsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbsbootldapsecurity.entity.User;

@RestController
@RequestMapping(value = "/ldapscurapp/user/services/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 @GetMapping("/")
	 public String index() {
	    return "Welcome to the home page!";
	 }
	 
	@GetMapping(value ="/user/{id}", consumes =MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUserById(@PathVariable Long id){
		return userService.getUserById(id);
	}
}
