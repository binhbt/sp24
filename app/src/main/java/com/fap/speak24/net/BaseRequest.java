package com.fap.speak24.net;

import com.vn.fa.base.data.net.FaRequest;
import com.vn.fa.base.data.net.request.StringAdtapterFactory;
import com.vn.fa.net.adapter.Request;

public class BaseRequest extends FaRequest {
    public BaseRequest(){
        //Add callback for all request
        addCallBack(new FaRequest.RequestCallBack() {
            @Override
            public void onStart() {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onFinish(Object result) {
//                if (container != null){
//                    Toast.makeText(((Activity)container), "base callback", Toast.LENGTH_LONG).show();
//                }
                //doRequest();
            }
        });
    }
    public static final String API_ENDPOINT = "http://speaking24.com/";
    @Override
    public boolean isLogging() {
        return true;
    }


    @Override
    public boolean isCache() {
        return true;
    }


    @Override
    public String getBaseUrl() {
        return API_ENDPOINT;
    }

    @Override
    public Request.Factory getRequestAdapter() {
        return new StringAdtapterFactory();
    }
//
//    @Override
//    public boolean isNewInstance() {
//        return true;
//    }
}