package Serv;

import DAO.Registration;
import Model.BeanConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws  ClassNotFoundException, SQLException {
        BeanConections bc = new BeanConections();
        Class.forName("com.mysql.jdbc.Driver");
        try( Connection connection = DriverManager.getConnection(bc.getURL(),bc.getUSERNAME(),bc.getPASSWORD())){
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        String n ="nikol";
        Registration registration = new Registration();
        System.out.println(registration.uniqueName(n));
        //throw new ServletException("Cannot obtain products from DB", e);

    }
}
