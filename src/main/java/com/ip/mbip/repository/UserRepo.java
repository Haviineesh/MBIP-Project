package com.ip.mbip.repository;

// import org.springframework.data.repository.CrudRepository;

import com.ip.mbip.model.User;

// public interface UserRepo extends CrudRepository<User, Long> {
//     User findByUsername(String username);
// }

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
