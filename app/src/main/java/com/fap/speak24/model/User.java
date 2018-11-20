package com.fap.speak24.model;

import com.fap.speak24.holder.UserItemView;
import com.vn.fa.adapter.multipleviewtype.DataBinder;
import com.vn.fa.adapter.multipleviewtype.IViewBinder;

public class User implements IViewBinder {

    private String age ="20";
    private String byl ="yes";
    private String country ="En";
    private String id ="";
    private String info ="";
    private String lang ="en";
    private String level ="1";
    private String msn ="";
    private String msnP ="on";
    private String nick ="";
    private String qq ="";
    private String rememberMe ="on";
    private String sex ="M";
    private String skype ="";
    private String skypeP ="on";
    private String status ="1";
    private String subject72 ="on";
    private String yahoo ="";
    private String yahooP ="on";

    private String topic ="";

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    //
    private String user_name="";
    private String email ="";
    private String avatar ="";
    private String facebook_id ="";
    private UserType userType = UserType.GUEST;
    private String status_message ="";
    private UserStatus user_status = UserStatus.OFF_LINE;
    private long last_logged = System.currentTimeMillis();
    private String skype_id ="";

    public String getSkype_id() {
        return skype_id;
    }

    public void setSkype_id(String skype_id) {
        this.skype_id = skype_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getByl() {
        return byl;
    }

    public void setByl(String byl) {
        this.byl = byl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getMsnP() {
        return msnP;
    }

    public void setMsnP(String msnP) {
        this.msnP = msnP;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSkypeP() {
        return skypeP;
    }

    public void setSkypeP(String skypeP) {
        this.skypeP = skypeP;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject72() {
        return subject72;
    }

    public void setSubject72(String subject72) {
        this.subject72 = subject72;
    }

    public String getYahoo() {
        return yahoo;
    }

    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }

    public String getYahooP() {
        return yahooP;
    }

    public void setYahooP(String yahooP) {
        this.yahooP = yahooP;
    }

    @Override
    public DataBinder getViewBinder() {
        return new UserItemView(this);
    }
}
