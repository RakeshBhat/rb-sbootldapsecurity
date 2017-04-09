package com.rbsbootldapsecurity.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFormController {

	 @PostMapping("/login")
	 public String indexLog() {
	    return "Welcome to the home page!";
	 }

}
