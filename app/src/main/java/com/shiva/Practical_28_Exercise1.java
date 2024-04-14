package com.shiva;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class Practical_28_Exercise1 extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private int loginAttempts = 0;
    private final int MAX_LOGIN_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical28_exercise1);

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

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (username.length() < 6 || password.length() < 6) {
            Toast.makeText(this, "Username and password should be at least 6 characters long", Toast.LENGTH_SHORT).show();
            return;
        }

        // Dummy valid credentials for demonstration
        String validUsername = "Shivpratap";
        String validPassword = "Shiva@123";

        if (username.equals(validUsername) && password.equals(validPassword)) {
            // Reset login attempts on successful login
            loginAttempts = 0;
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        } else {
            loginAttempts++;
            if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                Toast.makeText(this, "Max login attempts reached. Try again later.", Toast.LENGTH_SHORT).show();
                // Disable login button after max login attempts
                buttonLogin.setEnabled(false);
            } else {
                Toast.makeText(this, "Invalid username or password. Attempts left: " + (MAX_LOGIN_ATTEMPTS - loginAttempts), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
