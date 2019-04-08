package io.tmg.lesson09.dao.user;

import io.tmg.lesson09.model.user.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User user);
}
