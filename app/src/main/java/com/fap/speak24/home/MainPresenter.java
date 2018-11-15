package com.fap.speak24.home;

import com.fap.speak24.model.User;
import com.vn.fa.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter extends BasePresenter<MainView> {
    public void loadUserList(){
        List<User> listUsers = new ArrayList<>();
        for(int i=0; i<100; i++){
            User user = new User();
            user.setUser_name("User "+i);
            listUsers.add(user);
        }
    }
}
