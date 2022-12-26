package com.rifluxyss.app.analyticstracking;

public class SignupPojo {

    private final String registerNo;

    private final String fullName;

    public SignupPojo(String registerNo, String fullName) {
        this.registerNo = registerNo;
        this.fullName = fullName;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public String getFullName() {
        return fullName;
    }

}
