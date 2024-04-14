package com.shiva;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Practical_27_Exercise1 extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical27_exercise1);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Simple validation, you can add more complex validation as per your requirements
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Dummy username and password for demonstration
        String validUsername = "Shivpratap";
        String validPassword = "Shiva@123";

        // Check if the entered username and password match the valid credentials
        if (username.equals(validUsername) && password.equals(validPassword)) {
            // Display login successful message
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        } else {
            // Display login unsuccessful message
            Toast.makeText(this, "Login unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}
