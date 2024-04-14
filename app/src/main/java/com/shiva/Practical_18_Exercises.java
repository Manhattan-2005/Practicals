package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Practical_18_Exercises extends AppCompatActivity {

    EditText input, inputNumber;
    Button submit, submitNumber, openDialpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical18_exercises);

        input = findViewById(R.id.inputURL);
        submit = findViewById(R.id.submit);
        openDialpad = findViewById(R.id.dialPad);
        submitNumber = findViewById(R.id.submitNumber);
        inputNumber = findViewById(R.id.inputNumber);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(input.getText().toString()));
                startActivity(intent);
            }
        });

        openDialpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        submitNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calc_Factorial.class);
                int num = Integer.parseInt(inputNumber.getText().toString());
                intent.putExtra("Number", num);
                startActivity(intent);
            }
        });

    }
}