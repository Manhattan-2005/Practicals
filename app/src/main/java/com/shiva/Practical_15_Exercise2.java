package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Practical_15_Exercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical15_exercise2);

        CheckBox ch1 = findViewById(R.id.checkbox1);
        CheckBox ch2 = findViewById(R.id.checkbox2);
        CheckBox ch3 = findViewById(R.id.checkbox3);
        ((Button) findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected Items:\n";
                int total = 0;
                if(ch1.isChecked()) {
                    result += "Pizza 200rs\n";
                    total += 200;
                } if(ch2.isChecked()) {
                    result += "Coffee 50rs\n";
                    total += 50;
                } if(ch3.isChecked()) {
                    result += "Burger 120rs\n";
                    total += 120;
                }
                Toast.makeText(getApplicationContext(), result + "Total: " + total, Toast.LENGTH_SHORT).show();
            }
        });

    }
}