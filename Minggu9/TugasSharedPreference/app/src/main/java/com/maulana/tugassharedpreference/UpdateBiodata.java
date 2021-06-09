package com.maulana.tugassharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5, text6, text7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);
        dbHelper = new DataHelper(this);
        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        text6 = findViewById(R.id.editText6);
        text7 = findViewById(R.id.editText7);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("select * from biodata where username = '"+
                getIntent().getStringExtra("username")+"'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
        }
        ton1 = findViewById(R.id.button1);
        ton2 = findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update biodata set nama='"+
                        text2.getText().toString() + "', username='"+
                        text3.getText().toString() + "', password='"+
                        text4.getText().toString() + "', tgl='"+
                        text5.getText().toString() + "', jk='"+
                        text6.getText().toString() + "', alamat='"+
                        text7.getText().toString() + "' where nomor='"+
                        text1.getText().toString() + "'");
                Preferences.setRegisteredUser(getApplicationContext(), text3.getText().toString());
                Preferences.setRegisteredPass(getApplicationContext(), text4.getText().toString());
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                LihatSemuaBiodata.lsb.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener((arg0) -> {
            finish();
        });
    }
}