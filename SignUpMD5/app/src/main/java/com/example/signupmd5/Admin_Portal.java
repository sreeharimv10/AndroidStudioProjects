package com.example.signupmd5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin_Portal extends AppCompatActivity {

    ArrayAdapter arrayAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_portal);

        final DatabaseHelper helper = new DatabaseHelper(this);
        final ArrayList array_list = helper.getAllCotacts();
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(Admin_Portal.this, android.R.layout.simple_list_item_1, array_list);
        listView.setAdapter(arrayAdapter);

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array_list.clear();
                array_list.addAll(helper.getAllCotacts());
                arrayAdapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }
        });

        findViewById(R.id.Delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (helper.delete()) {
                    Toast.makeText(Admin_Portal.this, "Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Admin_Portal.this, "Not Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}