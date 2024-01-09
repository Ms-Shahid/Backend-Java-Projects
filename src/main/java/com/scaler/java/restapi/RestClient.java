package com.scaler.java.restapi;

import com.scaler.java.restapi.models.JSONResponseComments;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private JSONResponseComments responseComments;

    public RestClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        responseComments = retrofit.create(JSONResponseComments.class);
    }

    public JSONResponseComments getResponseComments(){
        return responseComments;
    }
}
