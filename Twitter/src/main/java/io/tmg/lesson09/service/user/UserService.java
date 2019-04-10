package io.tmg.lesson09.service.user;


import io.tmg.lesson09.model.user.User;

import java.util.List;

public interface UserService {
    List getAllUsers();

    void addUser(User user);

    void seeUserName(User user);
}
