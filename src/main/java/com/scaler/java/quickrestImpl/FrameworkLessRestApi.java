package com.scaler.java.quickrestImpl;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class FrameworkLessRestApi {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create( new InetSocketAddress(2406), 0);
        server.createContext("/api/test", exchange -> {

            if("GET".equals(exchange.getRequestMethod())){
                String responseText = "Hello World! from our framework-less REST API\\n";
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
                OutputStream outputStream = exchange.getResponseBody(); //stream to write to output
                outputStream.write(responseText.getBytes());
                outputStream.flush();
            }else {
                exchange.sendResponseHeaders(405, -1);
            }
        });

        server.setExecutor(null);
        server.start();
    }
}
