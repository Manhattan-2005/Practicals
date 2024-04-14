package com.shiva;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Practical_25_Exercise1 extends AppCompatActivity {

    private ImageView imageView;
    private boolean isRotatingClockwise = true;
    private boolean isZoomedIn = true;
    private boolean isFadedIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical25_exercise1);

        imageView = findViewById(R.id.imageView);
        Button rotateButton = findViewById(R.id.rotateButton);
        Button zoomButton = findViewById(R.id.zoomButton);
        Button fadeButton = findViewById(R.id.fadeButton);

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateImage();
            }
        });

        zoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImage();
            }
        });

        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeImage();
            }
        });
    }

    private void rotateImage() {
        float degree = isRotatingClockwise ? 360f : -360f;
        RotateAnimation rotateAnimation = new RotateAnimation(0, degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(true);
        imageView.startAnimation(rotateAnimation);

        isRotatingClockwise = !isRotatingClockwise;
    }

    private void zoomImage() {
        float startScale = isZoomedIn ? 1.0f : 1.5f;
        float endScale = isZoomedIn ? 1.5f : 1.0f;

        ScaleAnimation scaleAnimation = new ScaleAnimation(startScale, endScale, startScale, endScale,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setFillAfter(true);
        imageView.startAnimation(scaleAnimation);

        isZoomedIn = !isZoomedIn;
    }

    private void fadeImage() {
        float startAlpha = isFadedIn ? 1.0f : 0.0f;
        float endAlpha = isFadedIn ? 0.0f : 1.0f;

        AlphaAnimation fadeAnimation = new AlphaAnimation(startAlpha, endAlpha);
        fadeAnimation.setDuration(500);
        fadeAnimation.setFillAfter(true);
        imageView.startAnimation(fadeAnimation);

        // Toggle fade state
        isFadedIn = !isFadedIn;
    }
}
