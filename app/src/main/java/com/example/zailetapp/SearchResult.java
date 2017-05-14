package com.example.zailetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by amansinghthakur on 14/05/17.
 */

public class SearchResult extends AppCompatActivity{

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent = getIntent();
        /*
        String value;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getString("id");

            Log.d("YOLO",value);
        }
        */
    }
}

