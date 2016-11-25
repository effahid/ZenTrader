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

    public ChartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chart_layout, container, false);

        LineChart lineChart = (LineChart)view.findViewById(R.id.linechart);
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1,6));
        entries.add(new Entry(2,7));
        entries.add(new Entry(3,8));

        LineDataSet set = new LineDataSet(entries,"Days/Hours");
        set.setColor(5);
        set.getValueTextColor(20);

        LineData lineData = new LineData(set);
        lineChart.setData(lineData);
        lineChart.invalidate();

        return view;
    }
}



