package com.marketplace.User;

import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Component
public interface UserRepository extends JpaRepository<User,Long>{
	
	 List<User> findUserByRole(String role);
	
}
