package com.fap.speak24;

import com.vn.fa.base.FaApplication;
import com.vn.fa.base.util.FaLog;

public class Speak24Application extends FaApplication {
    public static FaApplication faApplication;
    static volatile EndPoints singletonApi;
    @Override
    public void onCreate() {
        super.onCreate();
        faApplication = this;
        FaLog.init(BuildConfig.DEBUG);
    }
    public String getBaseUrl(){
        return EndPoints.API_ENDPOINT;
    }
    public static EndPoints getApi() {
        if (singletonApi == null) {
            synchronized (EndPoints.class) {
                if (singletonApi == null) {
                    if (instance == null){
                        instance = new Speak24Application();
                    }
                    singletonApi = instance.getApi(EndPoints.class);
                }
            }
        }
        return singletonApi;
    }

    @Override
    public boolean isLogging() {
        return true;
    }
}