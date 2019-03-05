package Model;

import java.io.Serializable;

public class BeanConections implements Serializable {
    private final String URL = "jdbc:mysql://localhost:3306/firstdb";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public String getURL() {

        return URL;
    }

    public String getUSERNAME() {

        return USERNAME;
    }

    public String getPASSWORD() {

        return PASSWORD;
    }
}
