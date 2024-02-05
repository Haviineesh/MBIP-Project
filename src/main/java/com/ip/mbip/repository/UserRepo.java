package com.ip.mbip.repository;

import com.ip.mbip.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByResetToken(String resetToken);
}
