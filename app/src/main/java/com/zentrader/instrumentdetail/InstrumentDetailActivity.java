package com.zentrader.instrumentdetail;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.zentrader.R;

import org.w3c.dom.Text;

import java.util.Random;

public class InstrumentDetailActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Runnable runnable;
    final Handler handler = new Handler();
    TextView buyPriceTextView;
    TextView sellPriceTextView;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrument_detail);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        buyPriceTextView= (TextView)findViewById(R.id.buyPriceTextView);
        sellPriceTextView= (TextView)findViewById(R.id.sellPriceTextView);
        random= new Random();

        runnable = new Runnable() {
            @Override
            public void run() {
                UpdateStockList();
                handler.postDelayed(this, 2000);
            }
        };

        handler.postDelayed(runnable,500);
    }

    private void UpdateStockList() {
        buyPriceTextView.setText(String.format("%.2f",random.nextFloat()+1200));
        sellPriceTextView.setText(String.format("%.2f",random.nextFloat()+1190));
    }

    private void setupViewPager(ViewPager viewPager) {
        InstrumentDetailPagerAdapter adapter = new InstrumentDetailPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChartFragment(), "CHART");
        adapter.addFragment(new PositionsFragment(), "POSITIONS");
        adapter.addFragment(new ChangeFragment(), "CHANGE");
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.instrument_detail_menu, menu);

        return true;
    }

    public void GoBack(MenuItem item) {
        finish();
    }
}