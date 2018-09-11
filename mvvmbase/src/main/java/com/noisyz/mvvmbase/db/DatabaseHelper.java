package com.noisyz.mvvmbase.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_CHARTS = "db.sqlite";
    private static final int DB_VERSION = 1;
    private static DatabaseHelper instance;


    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, DB_CHARTS, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean isTableExists(String tableName) {
        try {
            Cursor cursor = getReadableDatabase().rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "'", null);
            if (cursor != null) {
                boolean result;
                if (cursor.getCount() > 0) {
                    result = true;
                } else {
                    result = false;
                }
                cursor.close();
                return result;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
