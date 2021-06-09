package com.maulana.tugassharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    TextView text1, text2, text3, text4, text5, text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);
        dbHelper = new DataHelper(this);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        text3 = findViewById(R.id.textView3);
        text4 = findViewById(R.id.textView4);
        text5 = findViewById(R.id.textView5);
        text6 = findViewById(R.id.textView6);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        if (getIntent().getStringExtra("username") == null) {
            cursor = db.rawQuery("select * from biodata where username = '"+
                    Preferences.getLoggedInUser(getBaseContext())+"'", null);
        } else {
            cursor = db.rawQuery("select * from biodata where username = '"+
                    getIntent().getStringExtra("username")+"'", null);
        }
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(4).toString());
            text5.setText(cursor.getString(5).toString());
            text6.setText(cursor.getString(6).toString());
        }
        ton1 = findViewById(R.id.button1);
        ton2 = findViewById(R.id.button2);
        ton1.setOnClickListener((arg0) -> {
            startActivity(new Intent(getBaseContext(),LihatSemuaBiodata.class));
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });
    }
}