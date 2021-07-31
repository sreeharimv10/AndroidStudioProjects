 package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 public class SecondActivity extends AppCompatActivity {
     public static final String EXTRA_REPLY =
             "com.example.android.twoactivities.extra.REPLY";
     private static final String LOG_TAG = SecondActivity.class.getSimpleName();

     private EditText mReply;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_second);
         mReply = (EditText) findViewById(R.id.replymsg);
         Log.d(LOG_TAG,"-------------------------------------------");
         Log.d(LOG_TAG,"onCreate of SecondActivity activated");

         Intent intent = getIntent();
         String message =
                 intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
         TextView textView = (TextView) findViewById(R.id.text_message);
         textView.setText(message);
     }

     public void returnreply(View view) {
         String reply = mReply.getText().toString();

         Intent replyIntent = new Intent();
         replyIntent.putExtra(EXTRA_REPLY, reply);
         setResult(RESULT_OK, replyIntent);
         finish();
     }

     protected void onStart() {
         super.onStart();
         Log.d(LOG_TAG,"-------------------------------------------");
         Log.d(LOG_TAG,"onStart  of SecondActivity activated");
     }

     @Override
     protected void onResume() {
         super.onResume();
         Log.d(LOG_TAG,"-------------------------------------------");
         Log.d(LOG_TAG,"onResume  of SecondActivity activated");
     }

     @Override
     protected void onPause() {
         super.onPause();
         Log.d(LOG_TAG,"-------------------------------------------");
         Log.d(LOG_TAG,"onPause  of SecondActivity activated");
     }

     @Override
     protected void onRestart() {
         super.onRestart();
         Log.d(LOG_TAG,"-------------------------------------------");
         Log.d(LOG_TAG,"onRestart  of SecondActivity activated");
     }

     @Override
     protected void onStop() {
         super.onStop();
         Log.d(LOG_TAG,"-------------------------------------------");
         Log.d(LOG_TAG,"onStop  of SecondActivity activated");
     }

     @Override
     protected void onDestroy() {
         super.onDestroy();
         Log.d(LOG_TAG,"-------------------------------------------");
         Log.d(LOG_TAG,"onDestroy  of SecondActivity activated");
     }
 }