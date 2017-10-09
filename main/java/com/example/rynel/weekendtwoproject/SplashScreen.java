package com.example.rynel.weekendtwoproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rynel on 10/8/2017.
 */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //2 second start up delay to display logo
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //telling app to initiate splash at boot
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
