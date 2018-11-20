package com.fap.speak24.home;

import android.util.Log;

import com.fap.speak24.Const;
import com.fap.speak24.ParseHelper;
import com.fap.speak24.model.User;
import com.fap.speak24.net.BaseRequest;
import com.vn.fa.base.data.net.FaRequest;
import com.vn.fa.base.data.net.FaRequestLoader;
import com.vn.fa.base.data.net.request.RequestType;
import com.vn.fa.base.mvp.BasePresenter;
import com.vn.fa.net.RequestLoader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class MainPresenter extends BasePresenter<MainView> {
    public void loadUserList() {
        List<User> listUsers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUser_name("User " + i);
            listUsers.add(user);
        }
/*        new FaRequestLoader.Builder()
                .api(loadFromSpk24())
                .callback(new RequestLoader.CallBack<List<User>>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onFinish(List<User> result) {

                    }
                }).container(getMvpView())
                .build();*/

        Map<String, String> params = new HashMap<>();
        params.put("age", "30");
        params.put("byl","yes");
        params.put("country","VN");
        params.put("gg","");
        params.put("icq","");
        params.put("id","17045861");
        params.put("info","I just want to chat in English for a while to improve my speaking skills.");
        params.put("lang","en");
        params.put("level","1");
        params.put("msn","");
        params.put("msnP","on");
        params.put("nick","binhbt");
        params.put("qq","");
        params.put("rememberMe","on");
        params.put("sex","M");
        params.put("skype","thanhbinh.gd");
        params.put("skypeP","on");
        params.put( "status","1");
        params.put("subject72","on");
        params.put("yahoo","");
        params.put("yahooP","on");
        //params.put("showme", "off");
        new BaseRequest().path("refresh.php")
                .type(RequestType.POST)
                .params(params)
                .callBack(new FaRequest.RequestCallBack<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onFinish(String result) {
                        Log.e("Result", result);
                        processHtml(result);
                    }
                })
                .container(getMvpView())
                .doRequest();
    }
    private void processHtml(String result){
        new FaRequestLoader.Builder()
                .api(loadFromSpk24(result))
                .callback(new RequestLoader.CallBack<List<User>>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onFinish(List<User> result) {
                        getMvpView().loadUserToview(result);
                    }
                }).container(getMvpView())
                .build();
    }
    public Observable<List<User>> loadFromSpk24(final String htmlT) {

        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return ParseHelper.parse(htmlT);
            }
        });

    }
}
