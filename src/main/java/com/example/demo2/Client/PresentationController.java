package com.example.demo2.Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class PresentationController {

    private static HttpURLConnection connection;
//    public void register(String name, String password){
//        try{
//            user newUser = new user(name, password);
//            URL url = new URL("http://localhost:8080/");
//            connection = (HttpURLConnection) url.openConnection();
//            int status = connection.getResponseCode();
//            System.out.println(status);
//            connection.setRequestMethod("POST");
//
//        }catch (Exception e){
//        }
//    }

//    //method1
//    public void login(String value, String value1) {
//        try{
//            BufferedReader reader;
//            String line;
//            StringBuffer response = new StringBuffer();
//            URL url = new URL("http://localhost:8080/user");
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            int status = connection.getResponseCode();
//            System.out.println(status);
//            //read response from api controller
//            if (status > 299){}
//            else{
//                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                while ((line = reader.readLine()) != null){
//                    response.append(line);
//                }
//                reader.close();
//            }
//            parse(response.toString());
//            System.out.println(response.toString());
//        }catch (Exception e){}
//    }

//    //method2
    public void login(String name, String password){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/user")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse ::body)
                .thenAccept(System.out::println)
                .join();
    }

    //POST with arguments example
    public void register(){
        Map<String, String> values = new HashMap<>();
        values.put("name", "john");
        values.put("password", "123");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String requestBody = objectMapper.writeValueAsString(values);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/rest/register"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (Exception e){}
    }

    //GET with no arguments example
    public void login(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/user"))
                .build();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            parseUser(response.body());
        }catch (Exception e){}
    }

    public String parseUser(String responseBody){
        JSONObject user1 = new JSONObject(responseBody);
        String name = user1.getString("name");
        String password = user1.getString("password");
        System.out.println("name: " + name + " , password: "+ password);
//        JSONArray users = new JSONArray(responseBody);
//        for (int i = 0 ; i < users.length() ; i++){
//            JSONObject user = users.getJSONObject(i);
//            String name = user.getString("name");
//            String password = user.getString("password");
//            System.out.println("name: " + name + " , password: "+ password);
//        }
        return null;
    }
}
