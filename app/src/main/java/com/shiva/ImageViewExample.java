package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewExample extends AppCompatActivity {

    int index = 0;
    int images[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_example);

        ImageView imageView = findViewById(R.id.imageView);
        Button prev = findViewById(R.id.previous);
        Button next = findViewById(R.id.next);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                if(index > images.length - 1){
                    index = 0;
                } if(index < 0) {
                    index = images.length - 1;
                }
                imageView.setImageResource(images[index]);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if(index > images.length - 1){
                    index = 0;
                } if(index < 0) {
                    index = images.length - 1;
                }
                imageView.setImageResource(images[index]);
            }
        });

    }
}