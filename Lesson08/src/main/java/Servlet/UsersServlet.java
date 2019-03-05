package Servlet;

import DAO.AllUser;
import Model.UsersBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private AllUser allUser;

    public void init() {
        allUser = new AllUser();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<UsersBean> users = allUser.list();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/Pages/Users.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}