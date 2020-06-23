package com.vishnusivadas.advancedhttpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.vishnusivadas.advanced_httpurlconnection.FetchData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Starting Read data from URL
        FetchData fetchData = new FetchData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/readTest.php");
        fetchData.start();
        Log.i("FetchData", fetchData.getResult());
        //End Read data from URL

        //Starting Write and Read data with URL
        //Creating array for parameters
        String[] param = new String[2];
        param[0] = "param-1";
        param[1] = "param-2";
        //Creating array for data
        String[] data = new String[2];
        data[0] = "data-1";
        data[1] = "data-2";
        PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "GET", param, data);
        putData.start();
        Log.i("PutData", putData.getResult());
        //End Write and Read data with URL

    }
}