package io.tmg.lesson09.dao.twitt;

import io.tmg.lesson09.model.twitt.Twitt;

import java.util.List;

public interface TwittDAO {
    List<Twitt> getUserMessage(Integer user_id);

    List<Twitt> getAllMessages();

    void createTwitt(Twitt twitt);
}
