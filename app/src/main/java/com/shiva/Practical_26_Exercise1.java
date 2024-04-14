package com.shiva;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Practical_26_Exercise1 extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<DataModel> dataList;

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical26_exercise1);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        recyclerView = findViewById(R.id.recyclerView);

        Button buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        dataList = new ArrayList<>();
        adapter = new MyAdapter(this, dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Initialize database helper
        dbHelper = new DatabaseHelper(this);

        // Load data from database
        loadData();
    }

    private void insertData() {
        String name = editTextName.getText().toString().trim();
        String ageStr = editTextAge.getText().toString().trim();

        if (name.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Please enter name and age", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);

        // Insert data into SQLite database using AsyncTask
        new InsertDataTask().execute(name, String.valueOf(age));
    }

    private void loadData() {
        new LoadDataTask().execute();
    }

    private class InsertDataTask extends AsyncTask<String, Void, Long> {

        @Override
        protected Long doInBackground(String... params) {
            String name = params[0];
            int age = Integer.parseInt(params[1]);

            // Insert data into SQLite database
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            long id = dbHelper.insertData(db, name, age);
            db.close();

            return id;
        }

        @Override
        protected void onPostExecute(Long id) {
            super.onPostExecute(id);
            if (id != -1) {
                // Add data to list and notify adapter
                dataList.add(new DataModel(editTextName.getText().toString(), Integer.parseInt(editTextAge.getText().toString())));
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to insert data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class LoadDataTask extends AsyncTask<Void, Void, List<DataModel>> {

        @Override
        protected List<DataModel> doInBackground(Void... voids) {
            // Load data from SQLite database
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = dbHelper.getAllData(db);
            List<DataModel> dataList = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                    int ageIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_AGE);

                    // Check if column index is valid
                    if (nameIndex != -1 && ageIndex != -1) {
                        String name = cursor.getString(nameIndex);
                        int age = cursor.getInt(ageIndex);
                        dataList.add(new DataModel(name, age));
                    } else {
                        // Handle invalid column index
                        // This could indicate a database schema change or data corruption
                        // You can log an error message or handle it based on your application's requirements
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
            return dataList;
        }

        @Override
        protected void onPostExecute(List<DataModel> result) {
            super.onPostExecute(result);
            // Update adapter with loaded data
            dataList.clear();
            dataList.addAll(result);
            adapter.notifyDataSetChanged();
        }
    }
}
