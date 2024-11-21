package com.example.regformvalidation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class display extends AppCompatActivity {

    TextView name, email, num;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.dispt1);
        email = findViewById(R.id.dispt2);
        num = findViewById(R.id.dispt3);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        String uname = sharedPreferences.getString("username","");
        String mail = sharedPreferences.getString("emailid","");
        String number = sharedPreferences.getString("number","");

        name.setText("Name : "+uname);
        email.setText("Email ID : "+mail);
        num.setText("Phone Number : "+number);
    }
}