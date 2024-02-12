package com.scaler.java.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class OkHTTP {

    OkHttpClient client;

    public OkHTTP() {
        client = new OkHttpClient();
    }

    public String triggerGetRequest(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();

        try{
            return client.newCall(request).execute().body().string();
        }catch (IOException e){
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }
}
