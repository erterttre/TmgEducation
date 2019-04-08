package io.tmg.lesson09.facade.twitt;

import io.tmg.lesson09.model.twitt.Twitt;

import java.util.List;

public interface TwittFacade {
    List<Twitt> transformListTwittModetToListTwittModelShow(List<Twitt> twitt);

    Twitt transformTwittModetToTwittModelShow(Twitt twitt);

    List<Twitt> showUserTwitt();
}
