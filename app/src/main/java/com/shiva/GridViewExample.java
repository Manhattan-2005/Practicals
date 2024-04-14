    package com.shiva;

    import androidx.appcompat.app.AppCompatActivity;

    import android.media.Image;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.GridView;

    import java.util.ArrayList;

    public class GridViewExample extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grid_view_example);

            GridView gridView = findViewById(R.id.gridView);
            String[] names = {
                    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
            };
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), names);
            gridView.setAdapter(adapter);

        }
    }