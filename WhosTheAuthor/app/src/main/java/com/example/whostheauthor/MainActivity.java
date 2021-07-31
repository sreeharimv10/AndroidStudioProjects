package com.example.whostheauthor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText mBookInput;
    private TextView mTitletext, mAuthorText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput  = (EditText) findViewById(R.id.book)      ;
        mTitletext  = (TextView) findViewById(R.id.titletext) ;
        mAuthorText = (TextView) findViewById(R.id.authortext);
    }

    public void searchBooks(View view)
    {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputManager != null)
        {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if(connMgr != null)
        {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        String queryString = mBookInput.getText().toString();

        if(networkInfo != null && networkInfo.isConnected() && queryString.length() != 0)
        {
            new FetchBook(mTitletext, mAuthorText).execute(queryString);
        }
        else
        {
            if(queryString.length() == 0)
            {
                mAuthorText.setText(" ");
                mTitletext.setText(R.string.no_search_term);
            }
            else
            {
                mAuthorText.setText(" ");
                mTitletext.setText("Not Connected");
            }
        }
        mAuthorText.setText("");
        mTitletext.setText(R.string.loading);
    }

}