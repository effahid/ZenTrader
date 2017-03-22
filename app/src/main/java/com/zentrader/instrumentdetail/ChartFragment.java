package com.zentrader.instrumentdetail;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.zentrader.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChartFragment extends Fragment {


    protected View mView;
    private LineChart mChart;
    List<Entry> entries = new ArrayList<>();
    int counter;
    int xCounter;
    LineDataSet lineDataSet;
    Runnable runnable;
    final Handler handler = new Handler();
    ArrayList<Entry> values;
    Random random;

    ArrayList<ILineDataSet> dataSets;
    public ChartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter++;
        xCounter=0;
        runnable = new Runnable() {
            @Override
            public void run() {
                UpdateChart();

            }
        };

    }

    private void UpdateChart() {

        values.add(new Entry(xCounter,xCounter+1));

        LineDataSet set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
        set1.setValues(values);
        mChart.getData().notifyDataChanged();
        mChart.notifyDataSetChanged();

        if(xCounter>=9) {
            xCounter=0;
        }
        xCounter++;
        handler.postDelayed(runnable, 500);
        //mChart.moveViewToAnimated(10,5, YAxis.AxisDependency.LEFT,1000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chart_layout, container, false);
        mView= view;
        mChart=(LineChart)mView.findViewById(R.id.linechart);
        InitializeChart();
        UpdateChart();
        return view;
    }

    private void InitializeChart() {
        dataSets = new ArrayList<>();
        values = new ArrayList<>();
        values.add(new Entry(1,1));
        lineDataSet = new LineDataSet(values, "Stock Price");
        SetupChartDataSetStyle(mChart, lineDataSet);
        dataSets.add(lineDataSet);
        LineData data = new LineData(dataSets);
        mChart.setData(data);
    }

    private void SetupChartDataSetStyle(LineChart mChart, LineDataSet lineDataSet) {
        lineDataSet.setColor(Color.GRAY);
        lineDataSet.setCircleColor(Color.BLACK);
        lineDataSet.setLineWidth(1f);
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(9f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFormLineWidth(1f);
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setEnabled(false);
        leftAxis.setAxisMaximum(10);
        leftAxis.setAxisMinimum(1);

        YAxis rightAxis = mChart.getAxisRight();
        //rightAxis.setAxisMaximum(10);
        rightAxis.setAxisMinimum(10);

       // lineDataSet.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
        //lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);


    }
}
