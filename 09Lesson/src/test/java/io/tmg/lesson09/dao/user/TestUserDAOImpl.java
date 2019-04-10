package io.tmg.lesson09.dao.user;

import io.tmg.lesson09.dao.exception.CustomDAOException;
import io.tmg.lesson09.model.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestUserDAOImpl {
@Mock
    UserDAO userDAO;

    private User user;
    private User user1;

    @Before
    public void setUp() {
        user = new User("top","qwe","Ukraine","22.09.2018");
        user1 = new User(null,"qweqweewq","Ukraine","22.09.2018");
    }

    @Test(expected = CustomDAOException.class)
    public void testAddingUserWhichDoesNotFit() throws CustomDAOException{
        //given
        User addUser = this.user1;
        //when
        userDAO.addUser(addUser);
        //then
        Assert.fail();
    }

    @Test
    public void  testAddingUserWhichOk() throws CustomDAOException {
        //given
        User addUser = this.user;
        //when
        userDAO.addUser(addUser);
        //then
       System.out.println("User added!");
    }

}
