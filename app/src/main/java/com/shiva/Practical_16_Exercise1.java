package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class Practical_16_Exercise1 extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker, timePicker2;
    Button timeButton, dateButton, submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical16_exercise1);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        timePicker2 = findViewById(R.id.timePicker2);
        dateButton = findViewById(R.id.dateButton);
        timeButton = findViewById(R.id.timeButton);
        submitButton = findViewById(R.id.submitButton);
        timePicker.setIs24HourView(true);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();
                String time = (timePicker.getHour()>12? ((timePicker.getHour()-12) > 10)?String.valueOf(timePicker.getHour()-12): "0" + String.valueOf(timePicker.getHour()-12):(timePicker.getHour()<10?"0" + timePicker.getHour():timePicker.getHour())) + ":" + (timePicker.getMinute()<10?"0" + timePicker.getMinute():timePicker.getMinute());
                Toast.makeText(getApplicationContext(), "Date: " + date + "\nTime: " + time, Toast.LENGTH_SHORT).show();
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datePicker.getVisibility() == View.GONE) {
                    datePicker.setVisibility(View.VISIBLE);
                    dateButton.setText("Close Date Selector");
                } else {
                    datePicker.setVisibility(View.GONE);
                    dateButton.setText("Show Date Selector");
                }
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timePicker.getVisibility() == View.GONE) {
                    timePicker.setVisibility(View.VISIBLE);
                    timePicker2.setVisibility(View.VISIBLE);
                    timeButton.setText("Close Time Selector");
                } else {
                    timePicker.setVisibility(View.GONE);
                    timePicker2.setVisibility(View.GONE);
                    timeButton.setText("Show Time Selector");
                }
            }
        });
    }
}