package com.maulana.minggu3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Pada, Subject, Pesan;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tugas);

        Pada = findViewById(R.id.pada);
        Subject = findViewById(R.id.subject);
        Pesan = findViewById(R.id.pesan);
        Submit = findViewById(R.id.submit);
    }
}