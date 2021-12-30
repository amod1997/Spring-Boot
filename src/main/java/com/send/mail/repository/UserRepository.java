package com.send.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.send.mail.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserEmail(String email);

}
