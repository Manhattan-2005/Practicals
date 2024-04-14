package com.shiva;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class Practical_6_Exercise1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6_exercise1);

        addData();
    }

    public void addData(){

        String[][] data = new String[10][4];
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace", "Henry", "Isabella", "Jack"};
        String[] departments = {"CM", "CE", "ME", "IT", "EE", "ENTC"};
        Random random = new Random();
        int minAge = 17;
        int maxAge = 21;

        for (int i = 0; i < 10; i++) {
            // Name
            data[i][0] = names[random.nextInt(names.length)];
            // Age
            int age = random.nextInt(maxAge - minAge + 1) + minAge;
            data[i][1] = String.valueOf(age);
            // Mobile
            data[i][2] = "1234567890";
            // Department
            data[i][3] = departments[random.nextInt(departments.length)];
        }

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        for (int i = 1; i < tableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < tableRow.getChildCount(); j++) {
                TextView textView = (TextView) tableRow.getChildAt(j);
                textView.setText(data[i-1][j]);
            }
        }

    }

}