package com.example.loic.gissippool.Provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LOIC on 09/07/2015.
 */
public class DataBase extends SQLiteOpenHelper {
    private static final String PROFIL = "profil";

    private static final String ID = "Id";

    private static final String SPEUDO = "speudo";

    private static final String PASSWD = "pass";
    private static final String EMAIL = "email";


    private static final String CREATE_A = "CREATE TABLE " + PROFIL + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SPEUDO + " TEXT NOT NULL, " + PASSWD + " TEXT NOT NULL, " + EMAIL + " TEXT NOT NULL); ";

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_A);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " +PROFIL);

        onCreate(db);

    }

}

