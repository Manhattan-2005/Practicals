package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Practical_7_Exercise1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical7_exercise1);
    }

    @SuppressLint("SetTextI18n")
    public void display(View v) {

        TextView t = findViewById(R.id.displayText);
        EditText name = findViewById(R.id.name);
        EditText pass = findViewById(R.id.pass);

        if(name.getText().toString().equals("manhattan2005") && pass.getText().toString().equals("shivam@30")) {

            t.setText("Authentication Successful!\n Welcome, " + name.getText().toString() + "!");

        } else {

            t.setText("Incorrect Username or Password! Enter Again..");
            name.setText(null);
            pass.setText(null);

        }

    }

}