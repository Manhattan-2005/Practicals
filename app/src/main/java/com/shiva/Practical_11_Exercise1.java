package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Practical_11_Exercise1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical11_exercise1);

        Button submit = findViewById(R.id.submitButton_For_Practical11_Exercise1);
        CheckBox check1 = findViewById(R.id.checkbox1);
        CheckBox check2 = findViewById(R.id.checkbox2);
        CheckBox check3 = findViewById(R.id.checkbox3);
        CheckBox check4 = findViewById(R.id.checkbox4);
        CheckBox check5 = findViewById(R.id.checkbox5);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultMessage = "Selected Fields: ";
                if(check1.isChecked()){
                    resultMessage += check1.getText().toString() + ", ";
                } if(check2.isChecked()){
                    resultMessage += check2.getText().toString() + ", ";
                } if(check3.isChecked()){
                    resultMessage += check3.getText().toString() + ", ";
                } if(check4.isChecked()){
                    resultMessage += check4.getText().toString() + ", ";
                } if(check5.isChecked()){
                    resultMessage += check5.getText().toString() + ", ";
                }

                if(resultMessage.equals("Selected Fields: ")) {
                    Toast.makeText(getApplicationContext(), "Select at least one field..", Toast.LENGTH_SHORT).show();
                } else  {
                    Toast.makeText(getApplicationContext(), resultMessage.substring(0, resultMessage.length()-2), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}