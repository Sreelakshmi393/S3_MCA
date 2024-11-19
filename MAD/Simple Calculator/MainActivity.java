package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    String first_num="", op="";
    Button clr;
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

        t1 = findViewById(R.id.t1);
        clr = findViewById(R.id.btn_c);
        int btn[] = new int[15];

        for(int i=0;i<=14;i++){
            String s = "btn_"+(i);
            int resid = getResources().getIdentifier(s,"id",getPackageName());
            btn[i]=resid;
        }
        for(int id:btn){
            Button butn = findViewById(id);
            if(butn != null){
                butn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handleButtonClick(v.getId());
                    }
                });
            }
        }

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
            }
        });
    }


    private void handleButtonClick(int id) {
        String txt = t1.getText().toString();

        if (id >= R.id.btn_0 && id <= R.id.btn_9) { // Number buttons
            t1.setText(txt + ((Button) findViewById(id)).getText().toString());
        } else if (id == R.id.btn_10 || id == R.id.btn_11 || id == R.id.btn_12 || id == R.id.btn_13) { // Operator buttons
            if (!txt.isEmpty()) {
                first_num = txt;
                op = ((Button) findViewById(id)).getText().toString();
                t1.setText(""); // Clear for the second number
            }
        } else if (id == R.id.btn_14) { // Equals button
            if (!first_num.isEmpty() && !op.isEmpty()  && !txt.isEmpty()) {
                String sec_num = txt;
                int res = 0;
                int num1 = Integer.parseInt(first_num);
                int num2 = Integer.parseInt(sec_num);

                switch (op) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                }
                t1.setText(String.valueOf(res));
                first_num = "";
                op = "";
            }
        }
    }

}