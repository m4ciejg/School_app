package com.maciejg.School.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School.model.StudentsTeachersEntity;

public interface StudentsTeachersRepository extends JpaRepository<StudentsTeachersEntity, Long> {

}
