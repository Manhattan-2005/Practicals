package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Practical_19_Exercise1 extends AppCompatActivity {

    EditText name, marks;
    Button submit, show;
    TextView result;
    ContentValues contentValues;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical19_exercise1);

        name = findViewById(R.id.name);
        marks = findViewById(R.id.marks);
        submit = findViewById(R.id.submit);
        show = findViewById(R.id.show);
        result = findViewById(R.id.result);
        contentValues = new ContentValues();

        uri = Uri.parse("content://com.shiva.StudentContentProvider/Student");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentValues.put("name", name.getText().toString());
                contentValues.put("marks", marks.getText().toString());
                getContentResolver().insert(uri, contentValues);
                contentValues.clear();
                name.setText("");
                marks.setText("");
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = getContentResolver().query(uri, new String[]{"name", "marks"}, null, null, null);
                if(cursor!=null && cursor.getCount() > 0) {
                    while(cursor.moveToNext()) {
                        result.setText(result.getText() + "Name: " + cursor.getString(0) + ", Marks: " + cursor.getString(1) + "\n");
                    }
                }
            }
        });
    }
}