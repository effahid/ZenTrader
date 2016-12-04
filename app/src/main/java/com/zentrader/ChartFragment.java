package com.zentrader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChartFragment extends Fragment {

    final Handler handler = new Handler();
    protected View mView;
    int counter;
    Random random = new Random();
    public ChartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        counter++;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chart_layout, container, false);
        mView= view;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                updateChart();
                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(runnable, 1000);

        return view;
    }

    private void updateChart() {
        LineChart lineChart = (LineChart)mView.findViewById(R.id.linechart);
        List<Entry> entries = new ArrayList<>();



        int xValue= Math.round(random.nextInt(10));
        int yValue= Math.round(random.nextInt(10));
        entries.add(new Entry(xValue,yValue));
        counter++;

        LineDataSet set = new LineDataSet(entries,"Days/Hours");
        set.setColor(5);
        set.getValueTextColor(20);

        LineData lineData = new LineData(set);
        lineChart.setData(lineData);

        lineChart.invalidate();
    }
}



