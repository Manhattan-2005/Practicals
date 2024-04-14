package com.shiva;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class StudentContentProvider extends ContentProvider {
    final String PROVIDER = "com.shiva.StudentContentProvider";
    final String DB = "shiva";
    final String TABLE = "Student";
    final String NAME = "name";
    final String MARKS = "marks";
    final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + NAME + " TEXT, " + MARKS + " INT);";
    final int MyUriCode = 69;

    SQLiteDatabase database;
    UriMatcher uriMatcher;


    @Override
    public boolean onCreate() {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER, TABLE, MyUriCode);
        database = getContext().openOrCreateDatabase(DB, Context.MODE_PRIVATE, null);
        database.execSQL(CREATE_TABLE_QUERY);
        if (database == null) {
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = null;
        switch (uriMatcher.match(uri)) {
            case MyUriCode:
                cursor = database.query(TABLE, projection, selection, selectionArgs, null, null, sortOrder==null?NAME:sortOrder);
                getContext().getContentResolver().notifyChange(uri, null);
                break;

            default:
                throw new IllegalArgumentException("No URI Found: " + uri.toString());
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case MyUriCode:
            return "com.shiva.StudentContentProvider.Student";

            default:
                throw new IllegalArgumentException("No URI Found: " + uri.toString());
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long rowId = 0;
        switch (uriMatcher.match(uri)) {
            case MyUriCode:
                rowId = database.insert(TABLE, "", values);
                Uri newUri = ContentUris.withAppendedId(uri, rowId);
                getContext().getContentResolver().notifyChange(newUri, null);
                return newUri;

            default:
                throw new IllegalArgumentException("No URI Found: " + uri.toString());
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case MyUriCode:
                count = database.delete(TABLE, selection, selectionArgs);
                getContext().getContentResolver().notifyChange(uri, null);
                break;

            default:
                throw new IllegalArgumentException("No URI Found: " + uri.toString());
        }
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case MyUriCode:
                count = database.update(TABLE, values, selection, selectionArgs);
                getContext().getContentResolver().notifyChange(uri, null);
                break;

            default:
                throw new IllegalArgumentException("No URI Found: " + uri.toString());
        }
        return count;
    }
}
