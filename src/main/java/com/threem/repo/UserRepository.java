package com.threem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threem.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
