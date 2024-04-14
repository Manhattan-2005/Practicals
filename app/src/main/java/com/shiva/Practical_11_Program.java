package com.shiva;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
public class Practical_11_Program extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical11_program);
        ((Button) findViewById(R.id.submit_For_Practical11_Program)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected Subjects: ";
                if(((CheckBox) findViewById(R.id.chBox1_For_Practical11_Program)).isChecked()) {
                    result = result + ((CheckBox) findViewById(R.id.chBox1_For_Practical11_Program)).getText().toString() + ", ";
                } if(((CheckBox) findViewById(R.id.chBox2_For_Practical11_Program)).isChecked()) {
                    result = result + ((CheckBox) findViewById(R.id.chBox2_For_Practical11_Program)).getText().toString() + ", ";
                } if(((CheckBox) findViewById(R.id.chBox3_For_Practical11_Program)).isChecked()) {
                    result = result + ((CheckBox) findViewById(R.id.chBox3_For_Practical11_Program)).getText().toString() + ", ";
                } if(((RadioButton) findViewById(R.id.radioButton)).isChecked()) {
                    result = result + "\nSelected Gender: " + ((RadioButton) findViewById(R.id.radioButton)).getText().toString();
                } else if(((RadioButton) findViewById(R.id.radioButton3)).isChecked()) {
                    result = result + "\nSelected Gender: " + ((RadioButton) findViewById(R.id.radioButton3)).getText().toString();
                }

                if(!result.equals("Selected Subjects: ")) {
                    result = result.substring(0, result.indexOf("\nSelected Gender: ") - 2) + result.substring(result.indexOf("\nSelected Gender: "));
                    if((result.contains("\nSelected Gender: "))){
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Select at least one gender!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Select at least one subject!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}