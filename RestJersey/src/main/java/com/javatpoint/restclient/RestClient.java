package com.javatpoint.restclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) {
        try {
        	//localhost:3306/Peoples?autoReconnect=true&useSSL=false
            URL url = new URL("http://localhost:8080/autoReconnect=true&useSSL=false/RestJersey/rest/hello/plain");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");

            if (conn.getResponseCode() != 200) 
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());

            String output;
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            br.close();
        } 
        catch (Exception e) {
        e.printStackTrace();
        
        }
        
        
    }
}
