package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Practical_4_Program extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4_program);
    }

    public void display(View v) {

        TextView t = findViewById(R.id.displayText);
        EditText name = findViewById(R.id.name);

        t.setText(String.format("Hello %s!", name.getText()));

    }

}