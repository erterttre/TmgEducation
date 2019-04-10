package io.tmg.lesson09.service.twitt;

import io.tmg.lesson09.model.twitt.Twitt;

import java.util.List;

public interface TwittService {
    /*
    List getAllTwitt();

     */

    List getUserTwitt();

    void addTwitt(Twitt twitt) throws Exception;
}
