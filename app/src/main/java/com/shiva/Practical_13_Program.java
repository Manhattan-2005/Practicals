package com.shiva;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Practical_13_Program extends AppCompatActivity {

    HashMap<String, String> users = new HashMap<>();
    String loginResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical13_program);

        ActivityResultLauncher<Intent> registerActivityLauncher = registerForActivityResult(

                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                users = (HashMap<String, String>) data.getSerializableExtra("users");
                                ((ProgressBar) findViewById(R.id.progressBar_For_Practical13_Program)).setProgress(25);
                            }
                        }
                    }
                }
        );

        ActivityResultLauncher<Intent> loginActivityLauncher = registerForActivityResult(

                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                loginResult = data.getStringExtra("result");
                                if(loginResult.equals("success")) {
                                    Toast.makeText(getApplicationContext(), "Log-in Successful", Toast.LENGTH_SHORT).show();
                                    ((ProgressBar) findViewById(R.id.progressBar_For_Practical13_Program)).setProgress(50);
                                }
                            }
                        }
                    }
                }
        );

        ((Button) findViewById(R.id.registerButton_For_Practical13_Program)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), Register_Page.class);
                it.putExtra("users", users);
                registerActivityLauncher.launch(it);

            }
        });

        ((Button) findViewById(R.id.loginButton_For_Practical13_Program)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), Practical_10_Exercise1.class);
                it.putExtra("users", users);
                loginActivityLauncher.launch(it);

            }
        });

    }
}