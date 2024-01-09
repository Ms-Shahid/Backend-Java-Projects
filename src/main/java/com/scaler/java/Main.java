package com.scaler.java;

import com.google.gson.internal.GsonBuildConfig;
import com.scaler.java.assign01.FileOperations;
import com.scaler.java.greetings.Greetings;
import com.scaler.java.http.OkHTTP;
import com.scaler.java.restapi.RestClient;
import retrofit2.Retrofit;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("args -> " + Arrays.toString(args));

        /*
        * How to achieve triggering single method
        * */

        String arg = "greet";
        if( args.length > 0 ) arg = args[0];

        switch (arg){
            case "greet":
                System.out.println("Greeting -> " + new Greetings().greeting());
                break;
            case "http":
                System.out.println("Ok http -> " + new OkHTTP().triggerGetRequest("https://example.com"));
                break;
            case "rest":
                var restClient = new RestClient();
                var getComments = restClient.getResponseComments().getEmail();
                System.out.println(getComments);
        }
//        Greetings greet = new Greetings();
//        System.out.println(greet.greeting());
//
//        OkHTTP client = new OkHTTP();
//        String response = client.triggerGetRequest("https://example.com");
//        System.out.println(response);

        FileOperations file = new FileOperations();

        String in1 = "src/main/java/assign01/in1.txt";
        String in2 = "src/main/java/assign01/in2.txt";

        List<Integer> file1Contents = file.readFileContents(new File(in1));
        List<Integer> file2Contents = file.readFileContents(new File(in2));

        System.out.println("file1 -> " + file1Contents + "\n " + "file2 -> " + file2Contents);

        List<Integer> mergedContents = file.mergeSort(file1Contents, file2Contents);
        System.out.println(mergedContents);

        file.writeIntoTheFile(mergedContents);



    }
}