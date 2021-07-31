package com.example.signupmd5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button save, refresh;
    EditText username, password;
    @Override
    protected void onCreate(Bundle readdInstanceState) {
        super.onCreate(readdInstanceState);
        setContentView(R.layout.activity_main);
        final DatabaseHelper helper = new DatabaseHelper(this);
        final ArrayList array_list = helper.getAllCotacts();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty())
                {

                    if (helper.insert(username.getText().toString(), password.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Some Error Occured. Please try again later", Toast.LENGTH_LONG).show();
                    }
                } else {
                    username.setError("Enter username");
                    password.setError("Enter password");
                }
            }
        });
    }

    public void showSignIn(View view)
    {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
