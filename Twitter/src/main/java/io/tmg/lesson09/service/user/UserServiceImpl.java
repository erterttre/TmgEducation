package io.tmg.lesson09.service.user;

import io.tmg.lesson09.dao.user.UserDaoImpl;
import io.tmg.lesson09.model.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = org.apache.log4j.Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        try {
            userDao.addUser(user);
            log.info("User added " + user.getUserName());
        } catch (Exception e) {
            log.error("Something went wrong" + e);
        }

    }
}
