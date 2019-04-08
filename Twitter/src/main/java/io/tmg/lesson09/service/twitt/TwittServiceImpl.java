package io.tmg.lesson09.service.twitt;

import io.tmg.lesson09.dao.twitt.TwittDAOImpl;
import io.tmg.lesson09.model.twitt.Twitt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwittServiceImpl implements TwittService {
    private static final Logger log = org.apache.log4j.Logger.getLogger(TwittServiceImpl.class);
    @Autowired
    private TwittDAOImpl twittDAO;

    @Override
    public List<Twitt> getAllTwitt() {
        return twittDAO.getAllMessages();
    }

    @Override
    public List<Twitt> getUserTwitt() {
        return twittDAO.getUserMessage(1);
    }

    @Override
    public void addTwitt(Twitt twitt) throws Exception {
        if (twitt.getBodyMessage().length() >= 6 && twitt.getBodyMessage().length() <= 256) {
            twittDAO.createTwitt(twitt);
            log.info("Twitt added " + twitt.getTopMessage());
        } else {
            log.error("Not allowed twitt length =" + twitt.getBodyMessage().length() + " Must be from 6 to 256!");
            throw new Exception("Not allowed twitt length =" + twitt.getBodyMessage().length() + " Must be from 6 to 256!");
        }


    }
}
