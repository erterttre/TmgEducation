package DAO;

import Model.UsersBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AllUser {

    public List<UsersBean> list () throws SQLException, ClassNotFoundException {
        List<UsersBean> users = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        connectionDB.getConnection();
        Statement st = connectionDB.getConnection().createStatement();
        String sql = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            UsersBean usersBean = new UsersBean();
            usersBean.setId(rs.getInt("id"));
            usersBean.setName(rs.getString("name"));
            usersBean.setPassword(rs.getString("password"));
            users.add(usersBean);
        }
        return (users);
    }
}