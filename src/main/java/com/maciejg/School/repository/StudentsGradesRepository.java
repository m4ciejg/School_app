package com.maciejg.School.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School.model.StudentsGradesEntity;

public interface StudentsGradesRepository extends JpaRepository<StudentsGradesEntity, Long> {

}
