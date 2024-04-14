package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Practical_17_Exercise1 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle_Message", "onStart Method Called");
        if(textView != null)
            textView.setText(textView.getText() + "\nonStart Method Called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical17_exercise1);
        textView = findViewById(R.id.textView);
        Log.d("Lifecycle_Message", "onCreate Method Called");
        textView.setText(textView.getText() + "\nonCreate Method Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle_Message", "onPause Method Called");
        textView.setText(textView.getText() + "\nonPause Method Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle_Message", "onResume Method Called");
        textView.setText(textView.getText() + "\nonResume Method Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle_Message", "onStop Method Called");
        textView.setText(textView.getText() + "\nonStop Method Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle_Message", "onRestart Method Called");
        textView.setText(textView.getText() + "\nonRestart Method Called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle_Message", "onDestroy Method Called");
        textView.setText(textView.getText() + "\nonDestroy Method Called");
    }
}