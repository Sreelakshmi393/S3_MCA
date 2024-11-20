package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        sp = (Spinner) findViewById(R.id.sp);
        t1 = (TextView) findViewById(R.id.textView);
        ArrayList <String> al = new ArrayList<String>();
        al.add("Apple");
        al.add("Orange");
        al.add("Grapes");
        al.add("Avacado");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,al);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                t1.setText("Your favourite fruit is : "+al.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                t1.setText("Select a fruit!!!");
            }
        });
    }
}