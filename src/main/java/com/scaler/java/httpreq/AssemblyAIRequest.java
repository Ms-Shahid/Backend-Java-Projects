package com.scaler.java.httpreq;

import com.google.gson.Gson;
import com.scaler.java.httpreq.models.Transcript;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class AssemblyAIRequest {

    public void sendAudioToAssemblyAI() throws URISyntaxException, IOException, InterruptedException {

        //building the request & use gson to build in JSON format
        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://github.com/johnmarty3/JavaAPITutorial/blob/main/Thirsty.mp4?raw=true");
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);

        /* Post uses the builder pattern */
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", "d99f721a773840d4979e2975dce57a16")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest)).build();

        /* client to trigger the request */
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse =  httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString()); //to tell that we are expecting string response

        getStatusOfAudioFile(gson, postResponse, httpClient);

    }

    private static void getStatusOfAudioFile(Gson gson, HttpResponse<String> postResponse, HttpClient httpClient) throws URISyntaxException, IOException, InterruptedException {
        Transcript transcript;
        /* Use the get call to check the status of the audio file*/
        //convert the gson to json to extract the id & sent in get call
        transcript = gson.fromJson(postResponse.body(), Transcript.class);

        //sending a get request on the id
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", "d99f721a773840d4979e2975dce57a16")
                .GET().build();

        //we have to keep sending the request unless its status is completed
        while(true) {
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            transcript = gson.fromJson(getResponse.body(), Transcript.class);
            System.out.println(transcript.getStatus());

            if("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus()))
                break;

            Thread.sleep(1000);
        }
        System.out.println("Process is completed8 😎");
        System.out.println(transcript.getText());
    }


}
