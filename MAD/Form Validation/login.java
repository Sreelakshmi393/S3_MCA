package com.example.regformvalidation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    EditText uname, pass;
    Button login;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        uname = findViewById(R.id.lgnt1);
        pass = findViewById(R.id.lgnt2);
        login = findViewById(R.id.btn2);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pass.getText().toString();
                String shUsername = sharedPreferences.getString("username","");
                String shPassword = sharedPreferences.getString("password","");

                if (username.equals(shUsername) && password.equals(shPassword)){
                    Toast.makeText(login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(login.this, display.class);
                startActivity(i);
            }
        });

    }
}