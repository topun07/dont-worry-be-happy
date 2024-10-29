package com.techelevator.locations.dao;

import com.techelevator.locations.models.User;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class MemoryUserDao implements UserDao {

    private final String USERS_DATA_FILE = "users.txt";
    private static List<User> users = new ArrayList<>();

    public MemoryUserDao() {
        users.add(new User(1L, "user", "$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC", "ROLE_USER", true));
        users.add(new User(2L, "admin", "$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC", "ROLE_ADMIN", true));
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                user = u;
            }
        }
        return user;
    }
}
