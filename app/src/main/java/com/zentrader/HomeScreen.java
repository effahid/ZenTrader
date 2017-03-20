package com.zentrader;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import butterknife.ButterKnife;

public class HomeScreen extends AppCompatActivity {
    private static final int ADD_INSTRUMENT_ACTIVITY_RESULT_CODE = 1;
    final Handler handler = new Handler();
    private ArrayList<Stock> stockPortfolio = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //ButterKnife.bind(this);

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mainToolbar);

        final MyListAdapter listAdapter = new MyListAdapter(this, stockPortfolio.toArray(new Stock[0]));

        ListView listView = (ListView) findViewById(R.id.MyList);
        listView.setAdapter(listAdapter);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                updateAdapter(listAdapter);
                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(runnable, 1000);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent openInstrumentDetail = new Intent(getBaseContext(), InstrumentDetailActivity.class);

                startActivity(openInstrumentDetail);
            }
        });

    }


    public void updateAdapter(MyListAdapter listAdapter) {
        Random random = new Random();
        for(Stock stock:stockPortfolio )
        {
            stock.Buy= random.nextFloat() + 1200;
            stock.Sell= random.nextFloat() + 1190;
            stock.Movement="U";
        }
        listAdapter.stockData = stockPortfolio.toArray(new Stock[stockPortfolio.size()]);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    public void ShowAddInstrument(MenuItem item) {
        Intent addInstrumentIntent = new Intent(getBaseContext(), AddInstrumentActivity.class);
        ArrayList<String> selectedStocks = new ArrayList<>();
        for(Stock stock:stockPortfolio)
        {
            selectedStocks.add(stock.Symbol);
        }
        addInstrumentIntent.putStringArrayListExtra("SelectedStocks", selectedStocks);
        startActivityForResult(addInstrumentIntent, ADD_INSTRUMENT_ACTIVITY_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == ADD_INSTRUMENT_ACTIVITY_RESULT_CODE) {
            if (resultCode == RESULT_OK) {

                // get String data from Intent
                ArrayList<String> addedStocks = data.getStringArrayListExtra("SelectedStocks");
                for(String addedStock:addedStocks)
                {
                    stockPortfolio.add(new Stock("",addedStock));
                }
            }
        }
    }
}


