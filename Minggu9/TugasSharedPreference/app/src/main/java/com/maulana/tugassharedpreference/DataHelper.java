package com.maulana.tugassharedpreference;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table biodata(nomor integer primary key autoincrement, nama text, username text, password text, tgl text, jk text, alamat text);";
        db.execSQL(sql);
    }

    public void saveBiodata(String nama, String username, String password, String tgl, String jk, String alamat, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("insert into biodata(nama, username, password, tgl, jk, alamat) values('" +
                nama + "','" +
                username + "','" +
                password + "','" +
                tgl + "','" +
                jk + "','" +
                alamat + "')");
        Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
