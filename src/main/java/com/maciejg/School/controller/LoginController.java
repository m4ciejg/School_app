package com.maciejg.School.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.School.model.LoginAndPassword;
import com.maciejg.School.repository.LoginRepository;

@RestController
@RequestMapping("api")
public class LoginController {

	@Autowired
	LoginRepository loginRepository;
	
	@PostMapping("/login")
	public LoginAndPassword addLoginPassword(@Valid @RequestBody LoginAndPassword entity) {
		
		return loginRepository.save(entity);
	}
}
