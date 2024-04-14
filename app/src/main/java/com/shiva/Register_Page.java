package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Register_Page extends AppCompatActivity {

    private HashMap<String, String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        users = (HashMap<String, String>) getIntent().getSerializableExtra("users");
    }

    public void addCredentials(View v) throws InterruptedException {

        String username = ((EditText) findViewById(R.id.user_For_Practical10_Exercise1_Register_Page)).getText().toString();
        String password = ((EditText) findViewById(R.id.pass_For_Practical10_Exercise1_Register_Page)).getText().toString();

        if (!users.containsKey(username)) {

            users.put(username, password);
            Toast.makeText(this, "User Added!\nRedirecting to Login..", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "User Already present!", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Redirecting to Login..", Toast.LENGTH_SHORT).show();

        }
        Thread.sleep(1000);
        backToLogin(v);

    }

    public void backToLogin(View v) {

            Intent resultIntent = new Intent();
            resultIntent.putExtra("users", users);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
    }
}
