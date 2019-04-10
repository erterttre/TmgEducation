package io.tmg.lesson09.service.twitt;

import io.tmg.lesson09.dao.twitt.TwittDAO;
import io.tmg.lesson09.model.twitt.Twitt;
import io.tmg.lesson09.service.exception.CustomException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TwittServiceImpl implements TwittService {
    private static final Logger log = org.apache.log4j.Logger.getLogger(TwittServiceImpl.class);
    @Resource
    private TwittDAO twittDAO;

    @Override
    public List<Twitt> getUserTwitt() {
        return twittDAO.getUserMessage(1);
    }

    @Override
    public void addTwitt(Twitt twitt) throws CustomException {
        if (twitt.getBodyMessage().length() >= 6 && twitt.getBodyMessage().length() <= 256) {
            isTwittOk(twitt);
            twittDAO.createTwitt(twitt);
            log.info("Twitt added " + twitt.getTopMessage());
        } else {
            log.error("Not allowed twitt length =" + twitt.getBodyMessage().length() + " Must be from 6 to 256!");
            throw new CustomException("Not allowed twitt length =" + twitt.getBodyMessage().length() + " Must be from 6 to 256!");
        }
    }

    public boolean isTwittOk(Twitt twitt)throws CustomException{
        try{
            if(twitt == null){
                throw new NullPointerException("twitt must not be null");
            }
            return true;
        }catch (NullPointerException e){
            throw new CustomException(e.getMessage(),e);
        }
    }
}
