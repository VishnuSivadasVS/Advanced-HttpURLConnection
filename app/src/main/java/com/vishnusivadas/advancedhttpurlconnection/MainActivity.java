package com.vishnusivadas.advancedhttpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vishnusivadas.advanced_httpurlconnection.FetchData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.dataView);
        progressBar = findViewById(R.id.progress);
        Button buttonFetch = findViewById(R.id.btnFetchData);
        Button buttonPut = findViewById(R.id.btnPutData);

        buttonFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                //Starting Read data from URL
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        FetchData fetchData = new FetchData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/readTest.php");
                        if (fetchData.startFetch()) {
                            if (fetchData.onComplete()) {
                                String result = fetchData.getResult();
                                progressBar.setVisibility(View.GONE);
                                textView.setText(result);
                                Log.i("FetchData", result);
                            }
                        }
                    }
                });
                //End Read data from URL
            }
        });

        buttonPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[2];
                        field[0] = "param-1";
                        field[1] = "param-2";
                        //Creating array for data
                        String[] data = new String[2];
                        data[0] = "data-1";
                        data[1] = "data-2";
                        PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                progressBar.setVisibility(View.GONE);
                                textView.setText(result);
                                Log.i("PutData", result);
                            }
                        }
                        //End Write and Read data with URL
                    }
                });
            }
        });


    }
}