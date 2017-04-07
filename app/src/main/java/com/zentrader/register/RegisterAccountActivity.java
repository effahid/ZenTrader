package com.zentrader.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import com.zentrader.GreenDao.App;
import com.zentrader.R;
import com.zentrader.addinstrument.AddInstrumentActivity;
import com.zentrader.addinstrument.Stock;
import com.zentrader.homescreen.HomeScreen;
import com.zentrader.homescreen.InstrumentRowAdapter;
import com.zentrader.instrumentdetail.InstrumentDetailActivity;
import com.zentrader.stockservice.StockService;

import java.util.ArrayList;
import java.util.List;

public class RegisterAccountActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText emailEditText;
    EditText passwordText;
    Boolean IsUserRegistered;
    Boolean savePassword;
    UserEntity user;
    Switch savePasswordSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user= GetUserDataFromDb();

        if(user!=null){
            StartHomeScreenActivity();
            return;
        }
        setContentView(R.layout.register_screen);

        emailEditText= (EditText)findViewById(R.id.register_screen_email_edittext);
        passwordText= (EditText)findViewById(R.id.register_screen_password_edittext);
        savePasswordSwitch =(Switch)findViewById(R.id.register_screen_savePasswordSwitch);

        savePasswordSwitch.setOnCheckedChangeListener(this);
        /*

            Get user dao from db
            if  no user found stay at the screen
            if found a user but no password go to login screen passing the username in the intent
            if found a user and saved password go to homescreen

        */
        //userEntityDao.deleteAll();
       // List<UserEntity> users=userEntityDao.queryBuilder().limit(1).list();
    }

    private UserEntity GetUserDataFromDb() {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        UserEntityDao userEntityDao = daoSession.getUserEntityDao();

        List<UserEntity> user = userEntityDao.queryBuilder().list();
        if(user==null || user.isEmpty() ) {
            return null;
        }
        return user.get(0);
    }

    public void RegisterUser(View view) {
        UserEntity user = new UserEntity();
        user.setEmail(emailEditText.getText().toString());
        if(savePassword){
            user.setPassword(emailEditText.getText().toString());
        }

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        UserEntityDao userEntityDao = daoSession.getUserEntityDao();

        userEntityDao.insert(user);

        StartHomeScreenActivity();
    }

    private void StartHomeScreenActivity() {
        Intent homeScreen = new Intent(this, HomeScreen.class);
        homeScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeScreen);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        savePassword=isChecked;
    }
}


