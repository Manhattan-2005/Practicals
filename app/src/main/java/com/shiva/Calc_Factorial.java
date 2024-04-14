package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Calc_Factorial extends AppCompatActivity {

    int number, currentNumber;
    long fact;
    TextView displayNum, outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_factorial);

        number = getIntent().getIntExtra("Number", 0);
        fact = 1;
        currentNumber = number;
        displayNum = findViewById(R.id.displayNum);
        outputText = findViewById(R.id.output);
        displayNum.setText(displayNum.getText() + String.valueOf(number));

        while (currentNumber > 0) {
            fact = fact * currentNumber;
            currentNumber = currentNumber - 1;
        }

        outputText.setText(String.valueOf(fact));
    }
}
