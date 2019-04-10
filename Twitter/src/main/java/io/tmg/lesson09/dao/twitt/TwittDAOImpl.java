package io.tmg.lesson09.dao.twitt;

import io.tmg.lesson09.dao.exception.CustomDAOException;
import io.tmg.lesson09.model.twitt.Twitt;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class TwittDAOImpl implements TwittDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;
    private static final String SQL = "INSERT INTO message1 (top_message, body_message, date_message, user_id) VALUES (?,?,?,?)";
    private static final String sql = "SELECT * FROM message1 WHERE message1.user_id = ?";

    private static final Logger log = org.apache.log4j.Logger.getLogger(TwittDAOImpl.class);

    RowMapper<Twitt> ROW_MAPPER2 = (ResultSet resultSet, int rowNum) -> {
        Twitt twitt1 = new Twitt();
        twitt1.setMessageId(resultSet.getInt("id_message"));
        twitt1.setTopMessage(resultSet.getString("top_message"));
        twitt1.setBodyMessage(resultSet.getString("body_message"));
        twitt1.setTimeMessage(resultSet.getString("date_message"));
        twitt1.setUserId(resultSet.getInt("user_id"));
        return twitt1;
    };


    @Override
    public List<Twitt> getUserMessage(Integer user_id) {
        List<Twitt> allUserTwitt = jdbcTemplate.query(sql, new Object[]{user_id}, ROW_MAPPER2);
        if (allUserTwitt == null) {
            log.error("ssue: The twitt list of user is empty!");
            throw new CustomDAOException("The twitt list is empty!");
        } else log.info("Everything OK!");
        return allUserTwitt;
    }

    @Override
    public void createTwitt(Twitt twitt) {
        try {
            jdbcTemplate.update(SQL, twitt.getTopMessage(), twitt.getBodyMessage(), twitt.getTimeMessage(), twitt.getUserId());
            log.info("Message successfully created.\nTop: " + twitt.getTopMessage() + ";\nBody: " + twitt.getBodyMessage() + ";\nTime: " + twitt.getTimeMessage() + "\n");
        } catch (Exception e) {
            log.error("Something went wrong", e);
            throw new CustomDAOException(e.getMessage(), e);
        }

    }
}
