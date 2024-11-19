package com.example.menuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox c1, c2, c3;
    EditText t1, t2, t3;

    Button submit;

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

        c1 = findViewById(R.id.pizza);
        c2 = findViewById(R.id.burger);
        c3 = findViewById(R.id.sandwich);
        t1 = findViewById(R.id.pizzaqty);
        t2 = findViewById(R.id.burgerqty);
        t3 = findViewById(R.id.sandwichqty);
        submit = findViewById(R.id.btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = 0;
                if(c1.isChecked()){
                    int p = Integer.parseInt(t1.getText().toString());
                    amount += p*200;
                }
                if(c2.isChecked()){
                    int b = Integer.parseInt(t2.getText().toString());
                    amount += b*150;
                }
                if (c3.isChecked()){
                    int s = Integer.parseInt(t3.getText().toString());
                    amount += s*100;
                }

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("totalprice", amount);
                startActivity(i);
            }
        });


    }
}