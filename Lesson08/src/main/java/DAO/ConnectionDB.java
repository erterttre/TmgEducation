package DAO;

import Model.BeanConections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private BeanConections bc = new BeanConections();
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.setConnection(DriverManager.getConnection(bc.getURL(),bc.getUSERNAME(),bc.getPASSWORD()));
        return connection;
    }
}