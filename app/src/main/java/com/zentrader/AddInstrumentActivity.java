package com.zentrader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;

public class AddInstrumentActivity extends AppCompatActivity {

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
}


