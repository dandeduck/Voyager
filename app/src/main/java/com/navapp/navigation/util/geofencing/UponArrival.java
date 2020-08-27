package com.navapp.navigation.util.geofencing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UponArrival extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        HasArrived.getInstance().update(true);
    }
}
