package com.neoris.admUser.repositories;


import org.springframework.data.repository.CrudRepository;

import com.neoris.admUser.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username,String password);

}
