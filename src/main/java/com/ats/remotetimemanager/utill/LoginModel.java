package com.ats.remotetimemanager.utill;

public class LoginModel {
    private String cin;
    private String password;

    public LoginModel() {
    }


    public LoginModel(String cin, String password) {
        this.cin = cin;
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
