package com.fap.speak24.model;

public class User {
    private int id =0;
    private String user_name="";
    private String email ="";
    private String avatar ="";
    private String facebook_id ="";
    private UserType userType = UserType.GUEST;
    private String status_message ="";
    private UserStatus user_status = UserStatus.OFF_LINE;
    private long last_logged = System.currentTimeMillis();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public UserStatus getUser_status() {
        return user_status;
    }

    public void setUser_status(UserStatus user_status) {
        this.user_status = user_status;
    }

    public long getLast_logged() {
        return last_logged;
    }

    public void setLast_logged(long last_logged) {
        this.last_logged = last_logged;
    }
}
