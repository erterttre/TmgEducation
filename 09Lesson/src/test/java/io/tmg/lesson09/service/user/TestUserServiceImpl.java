package io.tmg.lesson09.service.user;

import io.tmg.lesson09.dao.user.UserDAO;
import io.tmg.lesson09.model.user.User;
import io.tmg.lesson09.service.exception.CustomException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestUserServiceImpl {
    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;

    private User user;
    private User user1;

    @Before
    public void setUp() throws CustomException {
        user = new User("top","qwe","Ukraine","22.09.2018");
        user1 = new User("nikol","qweqweewq","Ukraine","22.09.2018");
    }

    @Test(expected = CustomException.class)
    public void testAddingUserWhichDoesNotFit() throws CustomException{
        //given
        User addUser = this.user1;
        //when
        userService.addUser(addUser);
        //then
        Assert.fail();
    }

    @Test
    public void  testAddingUserWhichOk() throws CustomException {
        //given
        User addUser = this.user;
        //when
        userService.addUser(addUser);
        //then
        Mockito.verify(userDAO).addUser(addUser);
    }
}
