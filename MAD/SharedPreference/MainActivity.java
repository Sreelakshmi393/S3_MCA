package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Code changes below here
        TextView t1 = findViewById(R.id.t1);
        Button b1 = findViewById(R.id.btn_read);
        Button b2 = findViewById(R.id.btn_write);
        String usernamedemo = "testuser";
        String emaildemo = "test@gmail.com";

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences s1 = getSharedPreferences("SharedPreference_Name",MODE_PRIVATE);
                        // getSharedPreferences() takes 2 arguments: 1st is filename,2nd one is mode.
                SharedPreferences.Editor ed1 = s1.edit();
                // call edit function with SharedPreference object
                ed1.putString("Gudu Morningu 🍍",usernamedemo);
                ed1.putString("ginsandy@gmail.com",emaildemo);
                ed1.apply();
                t1.setText("Write Operation Successful");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences s2 = getSharedPreferences("SharedPreference_Name",MODE_PRIVATE);
                String username;
                String email;
                username = s2.getString("username", " ");
                email = s2.getString("email"," ");
                t1.setText("Username : "+ username + "/n Email: " + email);
            }
        });

    }
}