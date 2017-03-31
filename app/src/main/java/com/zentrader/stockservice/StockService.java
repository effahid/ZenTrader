package com.zentrader.stockservice;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.zentrader.addinstrument.Stock;

import java.util.ArrayList;
import java.util.Random;

public class StockService extends Service{

    Runnable runnable;
    Random random = new Random();
    Handler handler= new Handler();
    private ArrayList<Stock> stockPortfolio = new ArrayList<>();
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    if(intent==null)return START_NOT_STICKY;
        stockPortfolio=intent.getParcelableArrayListExtra("selectedStocks");
        LocalBroadcastManager.getInstance(this).registerReceiver(mUpdatedStockListReceiver,new IntentFilter("stocks-list-updated"));

        runnable = new Runnable() {
            @Override
            public void run() {
                SendStockPrices();
                handler.postDelayed(runnable,2000);
            }
        };
        handler.postDelayed(runnable,500);
        return Service.START_STICKY;
    }



    private void sendMessageToActivity(String newData){
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("ServiceToActivityAction");
        broadcastIntent.putExtra("ServiceToActivityKey", newData);
        sendBroadcast(broadcastIntent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void SendStockPrices()
    {
        for(Stock stock:stockPortfolio )
        {
            stock.Buy= random.nextFloat()+1200;
            stock.Sell= random.nextFloat()+1190;
            stock.Movement="U";
        }
        Intent intent = new Intent("stock-price-updated");
        intent.putParcelableArrayListExtra("updatedStockPrices", stockPortfolio);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private BroadcastReceiver mUpdatedStockListReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            stockPortfolio = intent.getParcelableArrayListExtra("selectedStockList");
        }
    };
}
