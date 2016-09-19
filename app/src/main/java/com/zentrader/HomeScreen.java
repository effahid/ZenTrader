package com.zentrader;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeScreen extends AppCompatActivity {

    @BindView(R.id.instrumentTable)
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ButterKnife.bind(this);
    }

    public void addRow(View view)
    {
        TableRow tableRow= new TableRow(this);

        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));

        TextView textLabel = new TextView(this);
        textLabel.setText("GOLD");
        textLabel.setTextColor(Color.BLACK);
        textLabel.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));

        TextView currentBuy = new TextView(this);
        textLabel.setTextColor(Color.BLACK);
        currentBuy.setText("15");

        currentBuy.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));

        //tableRow.addView(textLabel,new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,                TableLayout.LayoutParams.WRAP_CONTENT));

        //  tableRow.addView(currentBuy,new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,                TableLayout.LayoutParams.WRAP_CONTENT));
        tableRow.addView(currentBuy);
        tableRow.addView(textLabel);
        // tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    @OnClick(R.id.addRowIButton)
    public void addRowXml(View view)
    {
        TableRow tableRow= (TableRow)View.inflate(this,R.layout.instrument_row,null);
        tableLayout.addView(tableRow);
    }
}
