package com.example.yml.mongodbcloud;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by yml on 2018/9/20
 **/
public class HTTPDataHandler {

    static String stream = null;

    public HTTPDataHandler() {
    }

    // 读数据库中数据
    public String GetHttpData(String urlString){
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            // check the connection status

            if(urlConnection.getResponseCode() == 200)
            {
                // if response code = 200 ~ HTTP.OK
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                // read the BufferedInputStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line=r.readLine()) != null)
                    sb.append(line);
                stream = sb.toString();
                urlConnection.disconnect();
            }
            else{

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stream;
    }

    // 添加数据
    public void PostHTTPData(String urlString, String json){
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            urlConnection.setFixedLengthStreamingMode(length);
            urlConnection.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
            urlConnection.connect();
            try(OutputStream os = urlConnection.getOutputStream())
            {
                os.write(out);
            }
            InputStream response = urlConnection.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  // 选中后，修改一条数据
    public void PutHTTPData(String urlString, String newValue){
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);

            byte[] out = newValue.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            urlConnection.setFixedLengthStreamingMode(length);
            urlConnection.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
            urlConnection.connect();
            try(OutputStream os = urlConnection.getOutputStream())
            {
                os.write(out);
            }
            InputStream response = urlConnection.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 选中后，删除一条数据
    public void DeleteHTTPData(String urlString, String json){
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("DELETE");
            urlConnection.setDoOutput(true);

            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            urlConnection.setFixedLengthStreamingMode(length);
            urlConnection.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
            urlConnection.connect();
            try(OutputStream os = urlConnection.getOutputStream())
            {
                os.write(out);
            }
            InputStream response = urlConnection.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
