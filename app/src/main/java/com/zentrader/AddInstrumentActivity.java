package com.zentrader;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AddInstrumentActivity extends AppCompatActivity {

    ArrayList<String> addedInstruments= new ArrayList<String>();
    Drawable defaultBackground;
    private int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_instrument);

        AdapterView.OnItemClickListener rowClickListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                LinearLayout row=(LinearLayout)view;
                if(defaultBackground==null){
                    defaultBackground=view.getBackground();
                }

                TextView stockSymbolTextView = (TextView)row.getChildAt(0);
                TextView stockNameTextView = (TextView)row.getChildAt(1);

                String stockSymbol = stockSymbolTextView.getText().toString();
                String
                        stockName = stockNameTextView.getText().toString();
                if(addedInstruments.contains(stockSymbol)){
                    stockNameTextView.setTextColor(getResources().getColor(R.color.black));
                    stockSymbolTextView.setTextColor(getResources().getColor(R.color.black));
                    addedInstruments.remove(stockName);
                    row.setBackground(null);
                }
                else{
                    addedInstruments.add(stockSymbol);
                    row.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    stockNameTextView.setTextColor(Color.WHITE);
                    stockSymbolTextView.setTextColor(Color.WHITE);
                }
            }};
        Toolbar instrumentToolbar = (Toolbar) findViewById(R.id.action_addInstrument);
        Intent intent = getIntent();


        Stock[] availableStockName= getAvailableStocks(intent.getStringArrayListExtra("SelectedStocks"));
        AvailableInstrumentsAdapter adapter = new AvailableInstrumentsAdapter(this,availableStockName);
        ListView availableInstruments = (ListView)findViewById(R.id.available_instruments_list);
        availableInstruments.setAdapter(adapter);
        availableInstruments.setOnItemClickListener(rowClickListener);
        availableInstruments.setItemsCanFocus(true);
        setSupportActionBar(instrumentToolbar);
    }

    private Stock[] getAvailableStocks(ArrayList<String> selectedStocks) {

        List<Stock> allStocks=new ArrayList<Stock>();

        allStocks.add(new Stock("GLD","GOLD"));
        allStocks.add(new Stock("SLVR","SILVER"));
        allStocks.add(new Stock("PLTN","PLATINUM"));
        allStocks.add(new Stock("APPL","APPLE"));

        Iterator<Stock> i = allStocks.iterator();
        while(i.hasNext())
        {
            Stock s = i.next();
            Log.d("","Selected stock symbol: current = " + s.Symbol);
            if(selectedStocks.contains(s.Symbol)){
                i.remove();
            }
        }

        allStocks.removeAll(selectedStocks);

        return allStocks.toArray(new Stock[allStocks.size()]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_instrument_menu,menu);
        return true;
    }

    public void ToggleSelectedInstrument(View view) {
        TextView selectedTextView = (TextView)view;
        if(defaultBackground==null){
            defaultBackground=view.getBackground();
           //
        }
        String stock = selectedTextView.getText().toString();

        if(addedInstruments.contains(stock)){
            addedInstruments.remove(stock);
            LinearLayout r = (LinearLayout) view.getParent();
            r.setBackground(null);
            final int childcount =r.getChildCount();

            for (int i = 0; i < childcount; i++) {
                TextView v = (TextView)r.getChildAt(i);
                if(v!=null)v.setTextColor(getResources().getColor(R.color.black));
            }
        }
        else{
            addedInstruments.add(stock);
            LinearLayout r = (LinearLayout) view.getParent();
            r.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            final int childcount =r.getChildCount();
            for (int i = 0; i < childcount; i++) {
                TextView v = (TextView)r.getChildAt(i);
                if(v!=null)v.setTextColor(Color.WHITE);
            }
        }


    }

    public void CancelAdd(View view) {
        finish();
    }

    public void AddInstrument(View view) {
        Intent intentResult=new Intent();

        intentResult.putStringArrayListExtra("SelectedStocks",addedInstruments);
        setResult(RESULT_OK,intentResult);
        finish();
    }
}