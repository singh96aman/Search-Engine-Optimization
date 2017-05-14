package com.example.zailetapp;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by amansinghthakur on 14/05/17.
 */

public class SuggestionProvider extends ContentProvider {

    ArrayList<String> names;

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        names =new ArrayList<String>();

        names.add("How you can perform telekinesis!");
        names.add("Should you be chasing your dreams?");
        names.add("Three things you should never do!");

        MatrixCursor matrixCursor = new MatrixCursor(
                new String[]{
                        BaseColumns._ID,
                        SearchManager.SUGGEST_COLUMN_TEXT_1,
                        SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID
                }
        );
        if (names != null) {
            String query = uri.getLastPathSegment().toString();
            int limit = Integer.parseInt(uri.getQueryParameter(
                    SearchManager.SUGGEST_PARAMETER_LIMIT));

            int length = names.size();

            for (int i = 0; i < length && matrixCursor.getCount() < limit; i++) {
                String recipe = names.get(i);
                if (recipe.contains(query)) {
                    matrixCursor.addRow(new Object[]{i, recipe, i});
                }
            }
        }
        return matrixCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
