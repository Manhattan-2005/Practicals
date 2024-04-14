package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Practical_7_Exercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical7_exercise2);
    }

    public void acceptDetails(View v) {

        EditText first_name = findViewById(R.id.firstname_For_Practical7_Exercise2);
        EditText last_name = findViewById(R.id.lastname_For_Practical7_Exercise2);
        EditText age = findViewById(R.id.age_For_Practical7_Exercise2);
        EditText dob = findViewById(R.id.dob_For_Practical7_Exercise2);
        EditText phone = findViewById(R.id.phone_For_Practical7_Exercise2);

        TextView result = findViewById(R.id.result_For_Practical7_Exercise2);

        String res = "First Name: " + first_name.getText().toString() + "\nLast Name: " + last_name.getText().toString() + "\nAge: " + age.getText().toString() +
                "\nDOB: " + dob.getText().toString() + "\nPhone: " + phone.getText().toString();

        result.setText(res);

    }

}