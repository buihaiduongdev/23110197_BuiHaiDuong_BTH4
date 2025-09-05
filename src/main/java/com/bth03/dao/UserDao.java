package com.bth03.dao;

import com.bth03.entity.User;

public interface UserDao {
	User login(String username, String password);

}
