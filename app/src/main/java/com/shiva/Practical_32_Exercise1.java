package com.shiva;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Practical_32_Exercise1 extends AppCompatActivity {

    private EditText sourceEditText;
    private EditText destinationEditText;
    private Button navigateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical32_exercise1);

        sourceEditText = findViewById(R.id.source_edit_text);
        destinationEditText = findViewById(R.id.destination_edit_text);
        navigateButton = findViewById(R.id.navigate_button);

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetch source and destination names
                String sourceName = sourceEditText.getText().toString();
                String destinationName = destinationEditText.getText().toString();

                // Create Uri to pass the source and destination names
                Uri gmmIntentUri = Uri.parse("http://maps.google.com/maps?saddr=" +
                        Uri.encode(sourceName) + "&daddr=" + Uri.encode(destinationName));

                // Create an Intent to open Google Maps with the URI
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                // Verify if there's an application that can handle the intent
                    startActivity(mapIntent);
            }
        });
    }
}
