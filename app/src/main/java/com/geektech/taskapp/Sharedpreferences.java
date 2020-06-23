package com.geektech.taskapp;
import android.content.Context;
import android.content.SharedPreferences;

public class Sharedpreferences {
    public Sharedpreferences(Context context) {

    }

    public class SharedPr {
        private SharedPreferences sharedPreferences;
        private volatile SharedPr place;

        public SharedPr(Context context) {
            place = this;
            sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);

        }

        public SharedPr getInstance(Context context) {
            if (place == null) new Sharedpreferences(context);
            return place;

        }

        public boolean isShown() {
            return sharedPreferences.getBoolean("isShown", false);
        }

        public void saveShown() {
            sharedPreferences.edit().putBoolean("isShown", true).apply();
        }

    }}
