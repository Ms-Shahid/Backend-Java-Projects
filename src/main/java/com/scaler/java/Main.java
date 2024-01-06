package com.scaler.java;

import assignments.assign01.FileOperations;
import com.scaler.java.greetings.Greetings;
import com.scaler.java.http.OkHTTP;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        Greetings greet = new Greetings();
//        System.out.println(greet.greeting());
//
//        OkHTTP client = new OkHTTP();
//        String response = client.triggerGetRequest("https://example.com");
//        System.out.println(response);
//
        FileOperations file = new FileOperations();

        String in1 = "src/main/java/assignments/assign01/in1.txt";
        String in2 = "src/main/java/assignments/assign01/in2.txt";

        List<Integer> file1Contents = file.readFileContents(new File(in1));
        List<Integer> file2Contents = file.readFileContents(new File(in2));

        System.out.println("file1 -> " + file1Contents + "\n " + "file2 -> " + file2Contents);

        List<Integer> mergedContents = file.mergeSort(file1Contents, file2Contents);
        System.out.println(mergedContents);

        file.writeIntoTheFile(mergedContents);



    }
}