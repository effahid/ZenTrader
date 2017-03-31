package com.zentrader.homescreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zentrader.instrumentdetail.InstrumentDetailActivity;
import com.zentrader.R;
import com.zentrader.addinstrument.Stock;
import com.zentrader.addinstrument.AddInstrumentActivity;
import com.zentrader.stockservice.StockBroadcastReceiver;
import com.zentrader.stockservice.StockService;

import java.util.ArrayList;
import java.util.Random;

public class HomeScreen extends AppCompatActivity {
    private static final int ADD_INSTRUMENT_ACTIVITY_RESULT_CODE = 1;
    final Handler handler = new Handler();
    private ArrayList<Stock> stockPortfolio = new ArrayList<>();
    InstrumentRowAdapter listAdapter;
    Runnable runnable;
    ListView listView;
    boolean isStockServiceRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        StartStockService();

        //ButterKnife.bind(this);

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mainToolbar);

        listAdapter = new InstrumentRowAdapter(this, stockPortfolio);

        listView = (ListView) findViewById(R.id.MyList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent openInstrumentDetail = new Intent(getBaseContext(), InstrumentDetailActivity.class);

                startActivity(openInstrumentDetail);
            }
        });

        LocalBroadcastManager.getInstance(this).registerReceiver(mStockPriceReceiver,new IntentFilter("stock-price-updated"));

    }

    private void StartStockService() {
        if(isStockServiceRunning)return;
        Intent stockServiceIntent= new Intent(this,StockService.class);
        stockServiceIntent.putParcelableArrayListExtra("selectedStocks",stockPortfolio);
        getApplicationContext().startService(stockServiceIntent);
        isStockServiceRunning=true;
    }

    private BroadcastReceiver mStockPriceReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            listAdapter.stockData = intent.getParcelableArrayListExtra("updatedStockPrices");
            listAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mStockPriceReceiver);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    public void ShowAddInstrument(MenuItem item) {
        Intent addInstrumentIntent = new Intent(getBaseContext(), AddInstrumentActivity.class);
        ArrayList<Stock> selectedStocks = new ArrayList<>();
        for(Stock stock:stockPortfolio)
        {
            selectedStocks.add(stock);
        }
        addInstrumentIntent.putExtra("SelectedStocks", selectedStocks);

       startActivityForResult(addInstrumentIntent, ADD_INSTRUMENT_ACTIVITY_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_INSTRUMENT_ACTIVITY_RESULT_CODE) {
            if (resultCode == RESULT_OK) {


                // get String data from Intent
                //THIS IS PROBABLY THE PROBLEM AREA WHICH IS CRASHING
                ArrayList<String> addedStocks = data.getStringArrayListExtra("SelectedStocks");
                for(String addedStock:addedStocks)
                {
                    stockPortfolio.add(new Stock(addedStock,addedStock));
                }
                listAdapter.stockData=stockPortfolio;
                listAdapter.notifyDataSetChanged();
                Intent intent = new Intent("stocks-list-updated");
                intent.putParcelableArrayListExtra("selectedStockList", stockPortfolio);

                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//                listAdapter.notifyDataSetChanged();
//
//                if(!beganUpdating){
//                    beganUpdating=true;
//                    handler.postDelayed(runnable, 2000);
//                }
            }
        }
    }
}


