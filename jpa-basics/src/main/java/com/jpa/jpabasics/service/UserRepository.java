package com.jpa.jpabasics.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.jpabasics.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
