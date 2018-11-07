package com.fap.speak24;

import android.os.Bundle;
import android.util.Log;

import com.fap.speak24.model.User;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity {
    @Override
    protected void initView(Bundle bundle) {
        User user= new User();
        String data = new Gson().toJson(user);
        Log.e("data", data);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
