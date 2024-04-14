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
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Practical_10_Exercise1 extends AppCompatActivity {

    private static HashMap<String, String> users = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical10_exercise1);

        users = (HashMap<String, String>) getIntent().getSerializableExtra("users");

    }

    public void checkUserCredentials(View v) {

        String enteredUsername = ((EditText) findViewById(R.id.username_For_Practical10_Exercise1)).getText().toString();
        String enteredPassword = ((EditText) findViewById(R.id.pass_For_Practical10_Exercise1)).getText().toString();

        if (users.containsKey(enteredUsername)) {

            String storedPassword = users.get(enteredUsername);
            try {
                if(storedPassword.equals(enteredPassword)) {

                    Toast.makeText(this, "User Login Successful!", Toast.LENGTH_SHORT).show();
                    try{
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("result", "success");
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();

                } else {
                    Toast.makeText(this, "Incorrect Username or Password! Retry..", Toast.LENGTH_SHORT).show();
                    ((EditText) findViewById(R.id.username_For_Practical10_Exercise1)).setText("");
                    ((EditText) findViewById(R.id.pass_For_Practical10_Exercise1)).setText("");
                }
            } catch(NullPointerException ne) {
                Toast.makeText(this, "Incorrect Username or Password! Retry..", Toast.LENGTH_SHORT).show();
                ((EditText) findViewById(R.id.username_For_Practical10_Exercise1)).setText("");
                ((EditText) findViewById(R.id.pass_For_Practical10_Exercise1)).setText("");
                users.remove(enteredUsername);
            }

        } else {

            Toast.makeText(this, "No User Found! Retry or Register.", Toast.LENGTH_SHORT).show();
            ((EditText) findViewById(R.id.username_For_Practical10_Exercise1)).setText("");
            ((EditText) findViewById(R.id.pass_For_Practical10_Exercise1)).setText("");

        }

    }

    private ActivityResultLauncher<Intent> registerActivityLauncher = registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            users = (HashMap<String, String>) data.getSerializableExtra("users");
                        }
                    }
                }
            }
    );

    public void createUser(View v) {

        ((EditText) findViewById(R.id.username_For_Practical10_Exercise1)).setText("");
        ((EditText) findViewById(R.id.pass_For_Practical10_Exercise1)).setText("");
        Intent intent = new Intent(this, Register_Page.class);
        intent.putExtra("users", users);
        registerActivityLauncher.launch(intent);

    }

}