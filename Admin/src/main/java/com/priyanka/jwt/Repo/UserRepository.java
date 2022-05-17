package com.priyanka.jwt.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.jwt. model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);



}
