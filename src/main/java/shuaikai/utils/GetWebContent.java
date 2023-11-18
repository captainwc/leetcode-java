package shuaikai.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWebContent {
    public static void main(String[] args) {
        String url = "https://pyxt.ustc.edu.cn/?menu=public_replay";

        try {
            URL obj = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            System.out.println(responseCode);

            // read the contex
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;

            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            String webContent = response.toString();

            System.out.println(webContent);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
