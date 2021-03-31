package com.example.Image_Search_J2EE;
import java.io.File;
import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;



public class APIConnect {
    public static void main(String[] args) throws IOException, InterruptedException {
        String postEndpoint = "http://127.0.0.1:8000/";
        String inputJson = "{ \"url\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Pied_Imperial_Pigeon_04.jpg/1920px-Pied_Imperial_Pigeon_04.jpg\", \"k\":5 }";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());

        JSONArray json_data = new JSONArray(response.body());
        JSONObject object = json_data.getJSONObject(0);
        for(int i=0; i < 5; i++) {
            String encoded_image = object.getJSONArray("Images").getString(i);
            byte[] s = encoded_image.getBytes(StandardCharsets.US_ASCII);
            Base64.Decoder decoder = Base64.getDecoder();
            FileUtils.writeByteArrayToFile(new File("C:\\Users\\Vicky\\Documents\\Projects\\Image_Search_J2EE\\Downloaded_Images\\"+i+".jpg"), decoder.decode(s));
        }
    }
}

