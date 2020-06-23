package com.vishnusivadas.advanced_httpurlconnection;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData extends Thread {
    private String url;
    String data = "Empty";

    public FetchData(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        Log.i("FetchData"+" State: ", "Start");
        try {
            URL url = new URL(this.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder result = new StringBuilder();
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                result.append(data);
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            setData(result.toString());
        } catch (IOException e) {
            setData(e.toString());
        }
    }

    public String getValue() {
        while (true) {
            if (!this.isAlive()) {
                return this.getData();
            }
        }
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getData() {
        return data;
    }
}
