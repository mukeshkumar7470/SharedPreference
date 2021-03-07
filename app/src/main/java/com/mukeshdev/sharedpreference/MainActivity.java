package com.mukeshdev.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    Button save,otherBtn;
    SharedPreferences sp;
    String strName, strEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name  = findViewById(R.id.name);
        email  = findViewById(R.id.email);
        save  = findViewById(R.id.button);
        otherBtn  = findViewById(R.id.otherBtn);

        sp = getSharedPreferences("User", Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strName = name.getText().toString();
                strEmail = email.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name", strName);
                editor.putString("email", strEmail);
                editor.commit();
                Toast.makeText(MainActivity.this, "Information saved", Toast.LENGTH_SHORT).show();

                name.getText().clear();
                email.getText().clear();
            }
        });

        otherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });
    }
}