package com.maciejg.School.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public StudentsTeachersEntity getById(@PathVariable(value = "id") long id) {
		
		return studentsTeachersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Info", "Id", id));
	}
	
	@PostMapping("/users")
	public StudentsTeachersEntity createUser(@Valid @RequestBody StudentsTeachersEntity entity) {
		
		return studentsTeachersRepository.save(entity);
	}
	
	@PutMapping("/users/{id}")
	public StudentsTeachersEntity updateUser(@PathVariable(value = "id") long id,
											@Valid @RequestBody StudentsTeachersEntity entity) {
		
		StudentsTeachersEntity studentsTeachersEntity = studentsTeachersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("UsersEntity", "id", id));
	
	studentsTeachersEntity.setName(entity.getName());
	studentsTeachersEntity.setSurname(entity.getSurname());
	studentsTeachersEntity.setOccupation(entity.getOccupation());
	studentsTeachersEntity.setPesel(entity.getPesel());
	studentsTeachersEntity.setPhoneNumber(entity.getPhoneNumber());
	studentsTeachersEntity.setAddress(entity.getAddress());
	
	StudentsTeachersEntity updated = studentsTeachersRepository.save(studentsTeachersEntity);
	
	return updated;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id){
		StudentsTeachersEntity entity = studentsTeachersRepository
									.findById(id)
									.orElseThrow(() -> new ResourceNotFoundException("UsersEntity", "id", id));
		studentsTeachersRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
	
}









