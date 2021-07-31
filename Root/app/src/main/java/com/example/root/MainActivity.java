package com.example.root;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity
{
    private boolean detectTestKeys()
    {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    private TextView main;
    private ImageView image;
    Animation animation;

    private String[] binaryPaths= {
            "/data/local/",
            "/data/local/bin/",
            "/data/local/xbin/",
            "/sbin/",
            "/su/bin/",
            "/system/bin/",
            "/system/bin/.ext/",
            "/system/bin/failsafe/",
            "/system/sd/xbin/",
            "/system/usr/we-need-root/",
            "/system/xbin/",
            "/system/app/Superuser.apk",
            "/cache",
            "/data",
            "/dev"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        image = findViewById(R.id.image);


    }
    private void checkForBinary(String filename)
    {
        for (String path : binaryPaths)
        {
            File f = new File(path, filename);
            boolean fileExists = f.exists();
            if (fileExists)
            {
               main.setText("ROOTED!");
               main.setVisibility(View.VISIBLE);
               animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
               main.startAnimation(animation);
            }
            else
            {
                main.setText("NOT ROOTED!");
                main.setVisibility(View.VISIBLE);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                main.startAnimation(animation);

            }
        }
    }

    private void checkForSuBinary()
    {
        checkForBinary("su"); // function is available below
    }

    private void checkForBusyBoxBinary() {
        checkForBinary("busybox");//function is available below
    }

    public void checkRoot(View view)
    {
        checkForSuBinary();
        checkForBusyBoxBinary();
    }
}