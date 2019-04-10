package io.tmg.lesson09.facade.twitt;


import io.tmg.lesson09.facade.data.DataTwitt;
import io.tmg.lesson09.model.twitt.Twitt;

import java.util.List;

public interface TwittFacade {
    List<DataTwitt> transformListTwittModetToListTwittModelShow(List<Twitt> dataTwitt);

    DataTwitt transformTwittModetToTwittModelShow(DataTwitt dataTwitt);

    List<DataTwitt> showUserTwitt();

    void addTwitt(Twitt twitt) throws Exception;
}
