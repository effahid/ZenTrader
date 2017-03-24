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
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
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
    LineData lineData;
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
        random = new Random();
        counter++;
        xCounter=0;
        runnable = new Runnable() {
            @Override
            public void run() {
                addEntry();
                handler.postDelayed(this,500);


            }
        };

    }

    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Dynamic Data");
        // set.setAxisDependency(AxisDependency.LEFT);
//        set.setColor(ColorTemplate.getHoloBlue());
//        set.setCircleColor(Color.WHITE);
//        set.setLineWidth(2f);
//        set.setCircleRadius(4f);
//        set.setFillAlpha(65);
//        set.setFillColor(ColorTemplate.getHoloBlue());
//        set.setHighLightColor(Color.rgb(244, 117, 117));
//        set.setValueTextColor(Color.WHITE);
//        set.setValueTextSize(9f);

       set.setDrawValues(false);
        return set;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chart_layout, container, false);
        mView= view;
        mChart=(LineChart)mView.findViewById(R.id.linechart);
        //mChart.setOnChartValueSelectedListener(view.getContext());

        // enable description text
        mChart.getDescription().setEnabled(true);

        // enable touch gestures
//        mChart.setTouchEnabled(true);
//
//        // enable scaling and dragging
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(true);
//        mChart.setDrawGridBackground(false);

        // if disabled, scaling can be done on x- and y-axis separately
        // mChart.setPinchZoom(true);

        // set an alternative background color
        //mChart.setBackgroundColor(Color.LTGRAY);

        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);

        // add empty data
        mChart.setData(data);

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);

        l.setTextColor(Color.WHITE);

        XAxis xl = mChart.getXAxis();

        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(false);
        //xl.setAvoidFirstLastClipping(true);
        //xl.setEnabled(true);

        YAxis leftAxis = mChart.getAxisLeft();

      //  leftAxis.setTextColor(Color.WHITE);
        leftAxis.setAxisMaximum(100f);
        leftAxis.setAxisMinimum(0f);
       // leftAxis.setDrawGridLines(true);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);
        handler.postDelayed(runnable,500);
        return view;
    }

    private void addEntry() {

        LineData data = mChart.getData();

        if (data != null) {

            ILineDataSet set = data.getDataSetByIndex(0);
            // set.addEntry(...); // can be called as well

            if (set == null) {
                set = createSet();
                data.addDataSet(set);
            }

            data.addEntry(new Entry(set.getEntryCount(), (float) (Math.random() * 40) + 30f), 0);

            data.notifyDataChanged();

            // let the chart know it's data has changed
            mChart.notifyDataSetChanged();

            // limit the number of visible entries
            mChart.setVisibleXRangeMaximum(5);
            // mChart.setVisibleYRange(30, AxisDependency.LEFT);

            // move to the latest entry
            mChart.moveViewToAnimated(data.getEntryCount(),data.getYMax(), YAxis.AxisDependency.LEFT,500);

            // this automatically refreshes the chart (calls invalidate())
            // mChart.moveViewTo(data.getXValCount()-7, 55f,
            // AxisDependency.LEFT);
        }
    }


    private void SetupChartDataSetStyle(LineChart mChart, LineDataSet lineDataSet) {


    }
}
