package com.zentrader;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
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

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChartFragment extends Fragment {

    final Handler handler = new Handler();
    protected View mView;
    private LineChart mChart;
    List<Entry> entries = new ArrayList<>();
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
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                updateChart();
//                handler.postDelayed(this, 2000);
//            }
//        };
//
//        handler.postDelayed(runnable, 1000);
        mChart=(LineChart)mView.findViewById(R.id.linechart);

        setData(30, 100);
        return view;
    }

    private void setData(int count, float range) {
        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {

            float val = (float) (1200+Math.random() * range) + 3;
            values.add(new Entry(i, val));
        }
        LineDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "DataSet 1");

            // set the line to be drawn like this "- - - - - -"
            //set1.enableDashedLine(10f, 5f, 0f);
            //set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.GRAY);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);

            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
           // set1.setFormSize(15.f);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
//            if (Utils.getSDKInt() >= 18) {
//                // fill drawable only supported on api level 18 and above
//                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
//                set1.setFillDrawable(drawable);
//            }
//            else {
//                set1.setFillColor(Color.BLACK);
//            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(dataSets);

            // set data

            mChart.setData(data);
            mChart.setVisibleXRangeMaximum(10);

            mChart.moveViewToAnimated(100,100, YAxis.AxisDependency.LEFT,23000);





            YAxis leftAxis = mChart.getAxisLeft();

            leftAxis.setEnabled(false);






        }
    }
}



