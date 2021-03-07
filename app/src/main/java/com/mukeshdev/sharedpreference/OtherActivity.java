package com.mukeshdev.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        name = findViewById(R.id.tv_name);
        email = findViewById(R.id.tv_email);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("User", Context.MODE_PRIVATE);

        String strname = sp.getString("name", "");
        String stremail = sp.getString("email", "");

        name.setText(strname);
        email.setText(stremail);
    }
}