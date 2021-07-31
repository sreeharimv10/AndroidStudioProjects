package com.example.refresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = findViewById(R.id.refreshLayout);
        textView = findViewById(R.id.tv1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                swipeRefreshLayout.setRefreshing(false);

                boolean connection=isNetworkAvailable();
                if(connection)
                {
                    textView.setText("Connected");
                    textView.setTextColor(Color.GREEN);
                }
                else
                {
                    textView.setText("Network Error. Please try again later....");
                    textView.setTextColor(Color.RED);
                }
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.YELLOW);
    }
    public boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo !=null;
    }
}