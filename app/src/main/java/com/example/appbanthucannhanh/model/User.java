package com.example.appbanthucannhanh.model;

public class User {
    private String userAccount;
    private String userName;
    private int userPhone;
    private String userPassword;
    private String userAddress;
    private String userRole;

    public User() {
    }

    public User(String userAccount, String userName, int userPhone, String userPassword, String userAddress, String userRole) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userRole = userRole;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
