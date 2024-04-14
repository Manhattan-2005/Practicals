package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Practical_9_Exercise1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9_exercise1);
    }

    @SuppressLint("SetTextI18n")
    public void displayResult(View v) {

        if(((ToggleButton) findViewById(R.id.toggle_For_Practical9_Exercise1)).isChecked()) {

            ((TextView) findViewById(R.id.result_For_Practical9_Exercise1)).setText("Bluetooth turned ON!");

        } else {

            ((TextView) findViewById(R.id.result_For_Practical9_Exercise1)).setText("Bluetooth turned OFF!");

        }

    }

}