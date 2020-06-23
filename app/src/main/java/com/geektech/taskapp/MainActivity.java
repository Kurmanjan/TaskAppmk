package com.geektech.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.geektech.boredapp.R;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        boolean isShow = (this).isShown();
        if (!isShow) {
            startActivity(new Intent(this, IntroActivity.class));
            finish();
            return;
        }



    }

    private boolean isShown() {
        return false;
    }}


