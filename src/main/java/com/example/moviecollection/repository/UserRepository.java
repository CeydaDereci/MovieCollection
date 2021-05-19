package com.example.moviecollection.repository;

import com.example.moviecollection.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
