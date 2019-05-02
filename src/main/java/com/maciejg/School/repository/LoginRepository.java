package com.maciejg.School.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School.model.LoginAndPassword;

public interface LoginRepository extends JpaRepository<LoginAndPassword, Long> {

}
