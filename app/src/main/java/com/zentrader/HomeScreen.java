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

import java.util.Random;

import butterknife.ButterKnife;

public class HomeScreen extends AppCompatActivity {
    final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //ButterKnife.bind(this);

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mainToolbar);

        final MyListAdapter listAdapter = new MyListAdapter(this, getStock());

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

                Intent openInstrumentDetail= new Intent(getBaseContext(),InstrumentDetailActivity.class);

                startActivity(openInstrumentDetail);
            }
        });

    }


    public void updateAdapter(MyListAdapter listAdapter) {
        Random random = new Random();
        Stock[] stocks = new Stock[5];
        for (int i = 0; i < 5; i++) {
            stocks[i] = new Stock('U', random.nextFloat()+1200,random.nextFloat()+1190);
        }
        listAdapter.stockData = stocks;
        listAdapter.notifyDataSetChanged();
    }

    public Stock[] getStock() {
        Stock[] stocks = new Stock[5];
        stocks[0] = new Stock('U', 20, 10);
        stocks[1] = new Stock('U', 30, 28);

        stocks[2] = new Stock('D', 25, 28);
        stocks[3] = new Stock('D', 25, 28);
        stocks[4] = new Stock('D', 25, 28);
        return stocks;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    public void ShowAddInstrument(MenuItem item) {
        Intent addInstrumentIntent= new Intent(getBaseContext(),AddInstrumentActivity.class);
        startActivity(addInstrumentIntent);
    }
}


