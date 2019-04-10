package io.tmg.lesson09.service.user;

import io.tmg.lesson09.dao.user.UserDAO;
import io.tmg.lesson09.model.user.User;
import io.tmg.lesson09.service.exception.CustomException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = org.apache.log4j.Logger.getLogger(UserServiceImpl.class);
    @Resource
    private UserDAO userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) throws CustomException{
        try {
            seeUserName(user);
            userDao.addUser(user);
            log.info("User added " + user.getUserName());
        } catch (Exception e) {
            log.error("Something went wrong" + e);
            throw new CustomException("User already exists!");
        }

    }

    @Override
    public void seeUserName(User user){
        for (User user1:userDao.selectUserName()){
            if(user1.getUserName().equals(user.getUserName())){
                throw new CustomException("User already exists!");
            }
        }
    }
}
