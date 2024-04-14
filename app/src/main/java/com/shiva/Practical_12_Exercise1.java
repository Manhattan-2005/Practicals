package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Practical_12_Exercise1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical12_exercise1);

        RadioButton rd1 = findViewById(R.id.rd1);
        RadioButton rd2 = findViewById(R.id.rd2);

        RadioButton male = findViewById(R.id.male);
        RadioButton female = findViewById(R.id.female);

        ((Button) findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultMessage = "Selected: ";
                if (rd1.isChecked()){
                    resultMessage += rd1.getText().toString() + ", ";
                } if (rd2.isChecked()){
                    resultMessage += rd2.getText().toString() + ", ";
                } if (male.isChecked()){
                    resultMessage += male.getText().toString() + ", ";
                } else if (female.isChecked()){
                    resultMessage += female.getText().toString() + ", ";
                }

                if(resultMessage.equals("Selected: ")) {
                    Toast.makeText(getApplicationContext(), "Select at least one radio!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), resultMessage.substring(0, resultMessage.length()-2), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}