package com.zentrader;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddInstrumentActivity extends AppCompatActivity {

    ArrayList<String> addedInstruments= new ArrayList<String>();
    Drawable defaultBackground;
    private int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_instrument);

        Toolbar instrumentToolbar = (Toolbar) findViewById(R.id.action_addInstrument);

        ArrayList<Stock> existingStockList =(ArrayList<Stock>)getIntent().getSerializableExtra("SelectedStocks");
        Stock[] availableStockName= getAvailableStocks(existingStockList);
        AvailableInstrumentsAdapter adapter = new AvailableInstrumentsAdapter(this,availableStockName);
        ListView availableInstruments = (ListView)findViewById(R.id.available_instruments_list);
        availableInstruments.setAdapter(adapter);
        availableInstruments.setOnItemClickListener(rowClickListener);
        availableInstruments.setItemsCanFocus(true);
        setSupportActionBar(instrumentToolbar);
    }

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

    private Stock[] getAvailableStocks(ArrayList<Stock> selectedStocks) {

        List<Stock> allStocks=new ArrayList<>();

        allStocks.add(new Stock("GLD","GOLD"));
        allStocks.add(new Stock("SLVR","SILVER"));
        allStocks.add(new Stock("PLTN","PLATINUM"));
        allStocks.add(new Stock("APPL","APPLE"));

        Iterator<Stock> i = allStocks.iterator();
        while(i.hasNext())
        {
            Stock s = i.next();
            for(Stock s2:selectedStocks)
            {
                if(s2.Symbol.equals(s.Symbol)){
                    i.remove();
                }
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