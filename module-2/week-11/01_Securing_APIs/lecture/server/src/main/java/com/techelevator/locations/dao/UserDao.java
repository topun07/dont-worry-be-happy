package com.techelevator.locations.dao;

import com.techelevator.locations.models.User;

public interface UserDao {

    User getUserByUsername(String username);

}
