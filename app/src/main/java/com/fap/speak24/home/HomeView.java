package com.fap.speak24.home;

import com.fap.speak24.BaseMvpView;
import com.fap.speak24.model.User;

import java.util.List;

public interface HomeView extends BaseMvpView {
    void loadUserToview(List<User> userList);
}
