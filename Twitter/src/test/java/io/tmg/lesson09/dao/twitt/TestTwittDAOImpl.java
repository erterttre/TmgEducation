package io.tmg.lesson09.dao.twitt;

import io.tmg.lesson09.dao.exception.CustomDAOException;
import io.tmg.lesson09.model.twitt.Twitt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestTwittDAOImpl {
    @Mock
    private TwittDAOImpl twittDAO;

    private Twitt twitt;
    private Twitt twitt1;
    private int userExsistedId;
    private int userDontExsistedId;

    @Before
    public void setUp(){
        twitt = new Twitt("top","qwe","22.09.2018",10);
        twitt1 = new Twitt("top1","qweqweewq","22.09.2018",1);
        userExsistedId = 1;
        userDontExsistedId = 10;
    }

    @Test(expected = CustomDAOException.class)
    public void testAddingTwittWhichDoesNotFit() throws CustomDAOException {
        //given
        Twitt addTwitt = this.twitt;
        //when
        twittDAO.createTwitt(addTwitt);
        //then
        Assert.fail();
    }

    @Test
    public void  testAddingTwittWhichOk() throws CustomDAOException {
        //given
        Twitt addTwitt1 = this.twitt1;
        //when
        twittDAO.createTwitt(addTwitt1);
        //then
        System.out.println("Twitt added!");
    }

    @Test(expected = CustomDAOException.class)
    public void testGetUserTwittsWhichDoesNotFit() throws CustomDAOException{
        //given
       int user = this.userDontExsistedId;
        //when
        twittDAO.getUserMessage(user);
        //then
        Assert.fail();
    }

    @Test
    public void  testGetUserTwittsWhichOk() throws CustomDAOException {
        //given
        int user1 = this.userExsistedId;
        //when
        twittDAO.getUserMessage(user1);
        //then
        System.out.println(twittDAO.getUserMessage(user1));
    }


}
