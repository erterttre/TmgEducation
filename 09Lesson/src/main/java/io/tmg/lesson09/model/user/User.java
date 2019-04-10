package io.tmg.lesson09.model.user;

public class User {
    private int id;
    private String userName;
    private String userPassword;
    private String userCountry;
    private String registrationDate;

    public User() {
    }

    public User(String userName, String userPassword, String userCountry, String registrationDate) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userCountry = userCountry;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userCountry='" + userCountry + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
