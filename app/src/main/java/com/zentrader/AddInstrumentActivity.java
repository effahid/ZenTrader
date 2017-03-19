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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AddInstrumentActivity extends AppCompatActivity {

    List<String> addedInstruments= new ArrayList<String>();
    Drawable defaultBackground;
    private int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_instrument);

        Toolbar instrumentToolbar = (Toolbar) findViewById(R.id.action_addInstrument);
        String [] availableStockName= getAvailableStockName();
        AvailableInstrumentsAdapter adapter = new AvailableInstrumentsAdapter(this,availableStockName);
        ListView availableInstruments = (ListView)findViewById(R.id.available_instruments_list);
        availableInstruments.setAdapter(adapter);
        setSupportActionBar(instrumentToolbar);

    }

    private String[] getAvailableStockName() {

        return new String[]{
                "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
       , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                ,"Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
,"Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
,"Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"
                , "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD", "Gold","Silver","Platinum","ANET","BNET","CSAV","TLSD","TDXD"


        };
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
            selectedTextView.setBackground(null);
            selectedTextView.setTextColor(getResources().getColor(R.color.black));
        }
        else{
            addedInstruments.add(stock);
            selectedTextView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            selectedTextView.setTextColor(Color.WHITE);
        }


    }
}

