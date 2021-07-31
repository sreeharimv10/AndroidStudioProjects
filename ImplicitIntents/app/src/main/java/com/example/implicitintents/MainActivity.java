package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWebEdit, mLocEdit, mShareEdit;
    private Button mWebBtn, mLocBtn, mShareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebEdit = findViewById(R.id.edittext_web);
        mLocEdit = findViewById(R.id.edittext_loc);
        mShareEdit = findViewById(R.id.edittext_share);
    }

    public void openWebsite(View view) {
        String url = mWebEdit.getText().toString();
        Uri website = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, website);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("intent_error", "Can't find App");
        }

    }

    public void openLocation(View view) {
        String loc = mLocEdit.getText().toString();
        Uri location = Uri.parse("geo:0,0?q="+loc);

        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("intent_error", "Can't find App");
        }

    }

    public void shareText(View view) {
        String share = mShareEdit.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this).setType(mimeType)
                .setChooserTitle("Share this text")
                .setText(share).startChooser();

    }
}