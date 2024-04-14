package com.shiva;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

public class InsertDataTask extends AsyncTask<Void, Void, Long> {

    private Context context;
    private String name;
    private int age;
    private InsertionCallback callback;

    public InsertDataTask(Context context, String name, int age, InsertionCallback callback) {
        this.context = context;
        this.name = name;
        this.age = age;
        this.callback = callback;
    }

    @Override
    protected Long doInBackground(Void... voids) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_AGE, age);

        long insertedRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);

        db.close();
        return insertedRowId;
    }

    @Override
    protected void onPostExecute(Long insertedRowId) {
        super.onPostExecute(insertedRowId);
        if (insertedRowId != -1) {
            callback.onDataInserted();
        }
    }

    public interface InsertionCallback {
        void onDataInserted();
    }
}
