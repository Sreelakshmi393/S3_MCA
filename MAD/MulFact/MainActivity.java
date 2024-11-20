package com.example.mulfact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num, range;
    Button mul, fact;

    EditText factres;

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

        num = findViewById(R.id.t1);
        range = findViewById(R.id.t2);
        mul = findViewById(R.id.b1);
        fact = findViewById(R.id.b2);
        factres = findViewById(R.id.factview);

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = num.getText().toString();
                String val2 = range.getText().toString();
                int no = Integer.parseInt(val1);
                int ran = Integer.parseInt(val2);
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("number",no);
                i.putExtra("range", ran);
                startActivity(i);
            }
        });

        fact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int f=1;
                String val1 = num.getText().toString();
                int no = Integer.parseInt(val1);
                for(int i=1;i<=no;i++){
                    f *= i;
                }
                factres.setText(String.valueOf(f));
            }

        });

    }
}