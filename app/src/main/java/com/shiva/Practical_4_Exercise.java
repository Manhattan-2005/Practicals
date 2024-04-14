package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Practical_4_Exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4_exercise);
    }

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> marks = new ArrayList<Integer>();

    @SuppressLint("SetTextI18n")
    public void add_details(View v) {

        EditText n = findViewById(R.id.name);
        EditText m = findViewById(R.id.layout_constraint);

        names.add(n.getText().toString());
        marks.add(Integer.parseInt(m.getText().toString()));

        TextView result = findViewById(R.id.result);
        result.setText("Record Added Successfully!");

    }

    public void show_details(View v) {

        StringBuilder text = new StringBuilder();

        for(int i = 0; i < names.size(); i++)
            text.append("Name: ").append(names.get(i)).append(", Marks: ").append(marks.get(i)).append("\n");

        TextView result = findViewById(R.id.result);
        result.setText(text);
    }

}