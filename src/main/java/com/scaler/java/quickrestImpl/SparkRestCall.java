package com.scaler.java.quickrestImpl;

import static spark.Spark.*;
public class SparkRestCall {

    public static void main(String[] args) {
        get("/test", (req, res) -> "Hello test!");
        get("/greeting", (req, res) -> "Hello World! from our Spark REST API");
    }

}
