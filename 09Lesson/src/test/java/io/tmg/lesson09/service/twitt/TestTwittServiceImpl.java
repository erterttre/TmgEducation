package io.tmg.lesson09.service.twitt;

import io.tmg.lesson09.dao.twitt.TwittDAOImpl;
import io.tmg.lesson09.model.twitt.Twitt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestTwittServiceImpl {
    @Mock
    private TwittDAOImpl twittDAO;

    @InjectMocks
    private TwittService twittService = new TwittServiceImpl();

    private Twitt twitt;
    private Twitt twitt1;

    @Before
    public void setUp() throws Exception {
         twitt = new Twitt("top","qwe","22.09.2018",1);
        twitt1 = new Twitt("top1","qweqweewq","22.09.2018",1);


    }

    @Test(expected = Exception.class)
    public void testAddingTwittWhichDoesNotFit() throws Exception {
        //given
        Twitt addTwitt = this.twitt;
        //when
        twittService.addTwitt(addTwitt);
        //then
        Assert.fail();
    }

    @Test
    public void  testAddingTwittWhichOk() throws Exception {
        //given
        Twitt addTwitt1 = this.twitt1;
        //when
        twittService.addTwitt(addTwitt1);
        //then
        Mockito.verify(twittDAO).createTwitt(addTwitt1);
    }
}
