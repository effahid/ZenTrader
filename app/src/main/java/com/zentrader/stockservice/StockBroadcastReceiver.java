package com.zentrader.stockservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;



public class StockBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle notificationData = intent.getExtras();
        String newData  = notificationData.getString("ServiceToActivityKey");
    }


}
