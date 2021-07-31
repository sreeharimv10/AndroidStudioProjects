package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String intentAction = intent.getAction();
        if(intentAction != null)
        {
            String toastMessage = "Unknown Intent Action";
            switch (intentAction)
            {
                case Intent.ACTION_POWER_CONNECTED:
                toastMessage = "Power is Connected";
                break;

                case Intent.ACTION_POWER_DISCONNECTED:
                toastMessage = "Power is Disconnected";
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}