package com.scaler.java.restapi;

import com.scaler.java.restapi.models.JSONResponseComments;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface JSONPlaceHolder {

    @GET("/comments")
    Call<List<JSONResponseComments>> getComments();
}
