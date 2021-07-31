package com.example.hellotoastpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private int mCount;
    TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView2);

    }

    public void showToast(View view)
    {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG).show();
    }

    public void countUp(View view)
    {
        ++mCount;
        if(mShowCount != null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }

    }
}