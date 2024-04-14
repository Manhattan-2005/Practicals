package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Practical_8_Exercise2 extends AppCompatActivity {

    ArrayList<String> suggestions = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical8_exercise2);

        suggestions.add("Python");
        suggestions.add("Mobile App Development");
        suggestions.add("ETI");
        suggestions.add("EDE");
        suggestions.add("PHP");

        AutoCompleteTextView at = findViewById(R.id.auto_For_Practical8_Exercise2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, suggestions);
        at.setAdapter(adapter);
    }

    public void display(View v) {

        TextView t = findViewById(R.id.result_For_Practical8_Exercise2);
        EditText name = findViewById(R.id.auto_For_Practical8_Exercise2);

        t.setText(String.format("Sub Selected: %s", name.getText()));

    }

}