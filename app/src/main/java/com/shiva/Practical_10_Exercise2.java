package com.shiva;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.HashMap;


public class Practical_10_Exercise2 extends AppCompatActivity {

    HashMap<String,String> students = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical10_exercise2);

        students.put("2100150084", "shiva");
        students.put("2100150082", "athrava");
        students.put("2100150081", "yashwant");
        students.put("2100150037", "prats");
        students.put("2100150052", "radhe");
        students.put("2100150091", "wasim");

        ((Button) findViewById(R.id.submitButton_For_Practical10_Exercise2)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String enroll = ((EditText) findViewById(R.id.enrollment_For_Practical10_Exercise2)).getText().toString();
                String password = ((EditText) findViewById(R.id.pass_For_Practical10_Exercise2)).getText().toString();

                if(students.containsKey(enroll)) {

                    if(password.equals(students.get(enroll))) {

                        Toast.makeText(getApplicationContext(), "Student Login Successful!", Toast.LENGTH_SHORT).show();

                    } else {

                        failedMessage();
                    }

                } else {

                    failedMessage();

                }

            }

        });

    }

    public void failedMessage() {

        Toast.makeText(getApplicationContext(), "Incorrect Enrollment or Password. Retry", Toast.LENGTH_SHORT).show();
        ((EditText) findViewById(R.id.enrollment_For_Practical10_Exercise2)).setText("");
        ((EditText) findViewById(R.id.pass_For_Practical10_Exercise2)).setText("");

    }

}