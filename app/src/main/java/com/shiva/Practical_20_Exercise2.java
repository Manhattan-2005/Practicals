package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_20_Exercise2 extends AppCompatActivity {

    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical20_exercise2);

        start = findViewById(R.id.startButton);
        stop = findViewById(R.id.stopButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical_20_Exercise2.this, CustomService.class);
                intent.putExtra("name", "Shiva");
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practical_20_Exercise2.this, CustomService.class);
                stopService(intent);
            }
        });

    }
}