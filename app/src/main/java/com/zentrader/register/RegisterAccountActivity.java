package com.zentrader.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.zentrader.GreenDao.App;
import com.zentrader.R;
import com.zentrader.addinstrument.AddInstrumentActivity;
import com.zentrader.addinstrument.Stock;
import com.zentrader.homescreen.InstrumentRowAdapter;
import com.zentrader.instrumentdetail.InstrumentDetailActivity;
import com.zentrader.stockservice.StockService;

import java.util.ArrayList;

public class RegisterAccountActivity extends AppCompatActivity {

    EditText forenameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        forenameEditText= (EditText)findViewById(R.id.register_screen_forename_edittext);

    }

    public void RegisterUser(View view) {
        UserEntity user = new UserEntity();
        user.setFirstName(forenameEditText.getText().toString());
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        UserEntityDao userEntityDao = daoSession.getUserEntityDao();

        userEntityDao.insert(user);

    }
}


