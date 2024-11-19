package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    RadioGroup rgrp1, rgrp2, rgrp3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rgrp1 = findViewById(R.id.rg1);
        rgrp2 = findViewById(R.id.rg2);
        rgrp3 = findViewById(R.id.rg3);
        btn = findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;
                if(rgrp1.getCheckedRadioButtonId() == R.id.rodri){
                    score += 10;
                } else if (rgrp1.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity2.this,"All questions are mandatory",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rgrp2.getCheckedRadioButtonId() == R.id.afa){
                    score += 10;
                } else if (rgrp2.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity2.this,"All questions are mandatory", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rgrp3.getCheckedRadioButtonId() == R.id.esp){
                    score += 10;
                } else if (rgrp3.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MainActivity2.this,"All questions are mandatory", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity2.this,"Your score is : "+score, Toast.LENGTH_SHORT).show();

            }
        });
    }
}