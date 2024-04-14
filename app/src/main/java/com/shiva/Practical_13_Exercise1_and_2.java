package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Practical_13_Exercise1_and_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical13_exercise1_and2);

        Button download = findViewById(R.id.download);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView title = findViewById(R.id.title);
        TextView status = findViewById(R.id.status);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                status.setVisibility(View.VISIBLE);

                new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            progressBar.setProgress(i);
                            progressBar.refreshDrawableState();
                            status.setText(i + "%");

                            try {
                                Thread.sleep(100);
                            } catch(InterruptedException ie) {
                                ie.printStackTrace();
                            }
                        }
                        status.setText("100%");
                    }
                }.start();
            }
        });

    }
}