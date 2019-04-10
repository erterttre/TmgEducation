package io.tmg.lesson09.dao.user;

import io.tmg.lesson09.dao.exception.CustomDAOException;
import io.tmg.lesson09.model.user.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;
    private static final String SQL = "INSERT INTO users (user_name, user_password, user_country, registration_time) VALUES (?,?,?,?)";
    private static final String sql = "SELECT user_name FROM users";
    private static final String sql1 = "SELECT * FROM users";
    private static final Logger log = org.apache.log4j.Logger.getLogger(UserDaoImpl.class);

    RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        User user1 = new User();
        user1.setId(resultSet.getInt("user_id"));
        user1.setUserName(resultSet.getString("user_name"));
        user1.setUserPassword(resultSet.getString("user_password"));
        user1.setUserCountry(resultSet.getString("user_country"));
        user1.setRegistrationDate(resultSet.getString("registration_time"));
        return user1;
    };

    @Override
    public List<User> getAllUsers() {
        List<User> users = jdbcTemplate.query(sql1, ROW_MAPPER);
        if (users == null) {
            log.error("Issue: The user list is empty!");
            throw new CustomDAOException("The user list is empty!");
        } else log.info("Everything OK!");
        return users;
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(SQL, user.getUserName(), user.getUserPassword(), user.getUserCountry(), user.getRegistrationDate());
        try {
            log.info("user successfully created.\nName: " + user.getUserName() + ";\nCountry: " +
                    user.getUserCountry() + ";\nTime: " + user.getRegistrationDate() + "\n");
        } catch (Exception e) {
            log.error("Something went wrong", e);
            throw new CustomDAOException(e.getMessage(),e);
        }
    }

    @Override
    public List<User> selectUserName(){
        List<User> usersName = jdbcTemplate.query(sql,ROW_MAPPER1);
        return usersName;
    }

    RowMapper<User> ROW_MAPPER1 = (ResultSet resultSet, int rowNum) -> {
        User user1 = new User();
        user1.setUserName(resultSet.getString("user_name"));
        return user1;
    };
}


