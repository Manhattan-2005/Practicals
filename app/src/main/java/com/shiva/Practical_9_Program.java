package com.shiva;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class Practical_9_Program extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9_program);
    }

    public void display(View v) {

        if(v.getId() == R.id.button) {

            Toast.makeText(this, "Simple Button Clicked.", Toast.LENGTH_SHORT).show();

        } else if(v.getId() == R.id.imageButton) {

            Toast.makeText(this, "Image Button Clicked.", Toast.LENGTH_SHORT).show();

        } else if(v.getId() == R.id.toggleButton) {

            Toast.makeText(this, "Toggle Button Clicked.", Toast.LENGTH_SHORT).show();

        }

    }

}