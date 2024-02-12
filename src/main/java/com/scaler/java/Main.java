package com.scaler.java;

import com.scaler.java.greetings.Greetings;
import com.scaler.java.httpreq.AssemblyAIRequest;
import com.scaler.java.okhttp.OkHTTP;
import com.scaler.java.restapi.RestClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

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
            case "okhttp":
                System.out.println("Ok http -> " + new OkHTTP().triggerGetRequest("https://example.com"));
                break;
            case "rest":
                var restClient = new RestClient();
                var getComments = restClient.getResponseComments().getEmail();
                System.out.println(getComments);
                break;
            case "http":
                AssemblyAIRequest assemblyApiRequest = new AssemblyAIRequest();
                assemblyApiRequest.sendAudioToAssemblyAI();
                break;
        }
//        Greetings greet = new Greetings();
//        System.out.println(greet.greeting());
//
//        OkHTTP client = new OkHTTP();
//        String response = client.triggerGetRequest("https://example.com");
//        System.out.println(response);

//        FileOperations file = new FileOperations();
//
//        String in1 = "src/main/java/assign01/in1.txt";
//        String in2 = "src/main/java/assign01/in2.txt";
//
//        List<Integer> file1Contents = file.readFileContents(new File(in1));
//        List<Integer> file2Contents = file.readFileContents(new File(in2));
//
//        System.out.println("file1 -> " + file1Contents + "\n " + "file2 -> " + file2Contents);
//
//        List<Integer> mergedContents = file.mergeSort(file1Contents, file2Contents);
//        System.out.println(mergedContents);
//
//        file.writeIntoTheFile(mergedContents);



    }
}