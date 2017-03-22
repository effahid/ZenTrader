package com.zentrader;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class InstrumentDetailActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrument_detail);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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