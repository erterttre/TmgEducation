package DAO;

import Model.UsersBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Registration {
   private boolean b = false;

    public List<UsersBean> nameUser () throws SQLException, ClassNotFoundException {
        ConnectionDB connectionDB = new ConnectionDB();
        List<UsersBean> names = new ArrayList<>();
        connectionDB.getConnection();
        Statement st = connectionDB.getConnection().createStatement();
        String sql = "SELECT name FROM users";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            UsersBean usersBean = new UsersBean();
            usersBean.setName(rs.getString("name"));
            names.add(usersBean);
        }
        return names;
    }

    public boolean uniqueName (String name)throws ClassNotFoundException, SQLException{
        for (UsersBean ub : nameUser()){
            if (name.equals(ub.getName())) {
                b = true;
            }
        }
        return b;
    }
}
