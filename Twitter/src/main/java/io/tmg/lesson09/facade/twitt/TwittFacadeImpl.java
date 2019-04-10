package io.tmg.lesson09.facade.twitt;

import io.tmg.lesson09.facade.data.DataTwitt;
import io.tmg.lesson09.model.twitt.Twitt;
import io.tmg.lesson09.service.twitt.TwittService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component("twittFacade")
public class TwittFacadeImpl implements TwittFacade {

    @Resource
    private TwittService twittService;

    @Override
    public void addTwitt(Twitt twitt) throws Exception{
        twittService.addTwitt(twitt);
    }

    @Override
    public List<DataTwitt> transformListTwittModetToListTwittModelShow(List<Twitt> dataTwitt) {
        List<DataTwitt> showListTwitt = new ArrayList();
        DataTwitt showForm;
        for (DataTwitt twitt1 : dataTwitt) {
            showForm = transformTwittModetToTwittModelShow(twitt1);
            showListTwitt.add(showForm);
        }
        return showListTwitt;
    }

    @Override
    public DataTwitt transformTwittModetToTwittModelShow(DataTwitt twitt) {
        DataTwitt showFormTwitt = new DataTwitt();
        showFormTwitt.setTopMessage(twitt.getTopMessage());
        showFormTwitt.setBodyMessage(twitt.getBodyMessage());
        return showFormTwitt;
    }

    @Override
    public List<DataTwitt> showUserTwitt() {
        List<Twitt> listTwitt = twittService.getUserTwitt();
        return transformListTwittModetToListTwittModelShow(listTwitt);
    }
}
