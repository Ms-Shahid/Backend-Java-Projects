package com.scaler.java;

import com.scaler.java.greetings.Greetings;
import com.scaler.java.http.OkHTTP;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Greetings greet = new Greetings();
        System.out.println(greet.greeting());

        OkHTTP client = new OkHTTP();
        String response = client.triggerGetRequest("https://example.com");
        System.out.println(response);
    }
}