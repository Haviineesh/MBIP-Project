package com.ip.mbip.repository;

import org.springframework.data.repository.CrudRepository;

import com.ip.mbip.model.User;

public interface UserRepo extends CrudRepository<User,Long>{

}
