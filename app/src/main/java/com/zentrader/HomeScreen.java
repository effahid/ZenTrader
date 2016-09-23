package com.zentrader;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeScreen extends AppCompatActivity {
    final Handler handler = new Handler();
    //@BindView(R.id.instrumentTable)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);

        final MyListAdapter listAdapter = new MyListAdapter(this,getStock());

        ListView listView = (ListView)findViewById(R.id.MyList);
        listView.setAdapter(listAdapter);

        Runnable runnable = new Runnable()
        {
            @Override
            public void run() {
                updateAdapter(listAdapter);
                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(runnable,1000);
    }

    public void updateAdapter(MyListAdapter listAdapter)
    {
        Random random= new Random();
        Stock[] stocks = new Stock[5];
        for(int i=0;i<5;i++){
            stocks[i]= new Stock('U',random.nextInt(),random.nextInt());
        }
        listAdapter.stockData=stocks;
        listAdapter.notifyDataSetChanged();
    }

    public Stock[] getStock() {
        Stock[] stocks = new Stock[5];
        stocks[0]= new Stock('U',20,10);
        stocks[1]= new Stock('U',30,28);

        stocks[2]= new Stock('D',25,28);
        stocks[3]= new Stock('D',25,28);
        stocks[4]= new Stock('D',25,28);
        return stocks;
    }

}
