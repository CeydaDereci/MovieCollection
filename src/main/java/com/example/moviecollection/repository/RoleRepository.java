package com.example.moviecollection.repository;

import com.example.moviecollection.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
