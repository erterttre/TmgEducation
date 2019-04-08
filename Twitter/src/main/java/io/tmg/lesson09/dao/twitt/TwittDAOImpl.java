package io.tmg.lesson09.dao.twitt;

import io.tmg.lesson09.model.twitt.Twitt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class TwittDAOImpl implements TwittDAO {
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = org.apache.log4j.Logger.getLogger(TwittDAOImpl.class);

    @Autowired
    public TwittDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        String sql = "SELECT * FROM message1 WHERE message1.user_id = ?";
        List<Twitt> allUserTwitt = jdbcTemplate.query(sql, new Object[]{user_id}, ROW_MAPPER2);
        if (allUserTwitt == null) {
            log.error("ssue: The twitt list of user is empty!");
        } else log.info("Everything OK!");
        return allUserTwitt;
    }

    @Override
    public List<Twitt> getAllMessages() {
        String sql = "SELECT * FROM message1";
        List<Twitt> messages = jdbcTemplate.query(sql, ROW_MAPPER2);
        if (messages == null) {
            log.error("Issue: The twitt list is empty!");
        } else log.info("Everything OK!");
        return messages;
    }

    @Override
    public void createTwitt(Twitt twitt) {
        String sql = "INSERT INTO message1 (top_message, body_message, date_message, user_id) VALUES (?,?,?,?)";
        try {
            jdbcTemplate.update(sql, twitt.getTopMessage(), twitt.getBodyMessage(), twitt.getTimeMessage(), twitt.getUserId());
            log.info("Message successfully created.\nTop: " + twitt.getTopMessage() + ";\nBody: " + twitt.getBodyMessage() + ";\nTime: " + twitt.getTimeMessage() + "\n");
        } catch (Exception e) {
            log.error("Something went wrong", e);
        }

    }
}
