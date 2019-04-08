package io.tmg.lesson09.facade.twitt;

import io.tmg.lesson09.model.twitt.Twitt;
import io.tmg.lesson09.service.twitt.TwittServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("twittFacade")
public class TwittFacadeImpl implements TwittFacade {

    @Autowired
    private TwittServiceImpl twittService;

    @Override
    public List<Twitt> transformListTwittModetToListTwittModelShow(List<Twitt> twitt) {
        List<Twitt> showListTwitt = new ArrayList();
        Twitt showForm;
        for (Twitt twitt1 : twitt) {
            showForm = transformTwittModetToTwittModelShow(twitt1);
            showListTwitt.add(showForm);
        }
        return showListTwitt;
    }

    @Override
    public Twitt transformTwittModetToTwittModelShow(Twitt twitt) {
        Twitt showFormTwitt = new Twitt();
        showFormTwitt.setTopMessage(twitt.getTopMessage());
        showFormTwitt.setBodyMessage(twitt.getBodyMessage());
        return showFormTwitt;
    }

    @Override
    public List<Twitt> showUserTwitt() {
        List<Twitt> listTwitt = twittService.getUserTwitt();
        return transformListTwittModetToListTwittModelShow(listTwitt);
    }
}
