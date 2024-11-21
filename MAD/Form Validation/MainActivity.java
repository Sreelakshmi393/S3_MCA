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

public class MainActivity extends AppCompatActivity {

    EditText uname, email, phno, pass;
    Button reg;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        uname = findViewById(R.id.t1);
        email = findViewById(R.id.t2);
        phno = findViewById(R.id.t3);
        pass = findViewById(R.id.t4);
        reg = findViewById(R.id.btn);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String emailid = email.getText().toString();
                String num = phno.getText().toString();
                String passwd = pass.getText().toString();
                if(!username.matches("[a-zA-Z ]+") || username.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter a valid username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!emailid.contains("@") || !emailid.contains(".")){
                    Toast.makeText(MainActivity.this, "Enter a valid email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!(num.length() ==10) || !num.matches("\\d+")){
                    Toast.makeText(MainActivity.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!passwd.matches("^(?=.*[A-Z])(?=.*[@#$%^&*()_+!])(?=.*\\d).{6,}$")){
                    Toast.makeText(MainActivity.this, "Enter a valid password", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.putString("username",username);
                ed.putString("emailid",emailid);
                ed.putString("number",num);
                ed.putString("password",passwd);
                ed.commit();

                Intent i = new Intent(MainActivity.this, login.class);
                startActivity(i);
            }
        });
    }
}