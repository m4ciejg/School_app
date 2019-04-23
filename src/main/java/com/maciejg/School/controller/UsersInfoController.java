package com.maciejg.School.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.School.exception.ResourceNotFoundException;
import com.maciejg.School.model.StudentsTeachersEntity;
import com.maciejg.School.repository.StudentsTeachersRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsersInfoController {

	@Autowired
	StudentsTeachersRepository studentsTeachersRepository;
	
	@GetMapping("/users")
	public List<StudentsTeachersEntity> getAll(){
		
		return studentsTeachersRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public StudentsTeachersEntity getById(@PathVariable(value = "id") Long id) {
		
		return studentsTeachersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Info", "Id", id));
	}
}
