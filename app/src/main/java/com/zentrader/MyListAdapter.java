package com.zentrader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<Stock> {

    ArrayList<Stock> stockData;
    public MyListAdapter(Context context, ArrayList<Stock> values) {
        super(context, -1, values);
        stockData=values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.instrument_row, parent, false);
        TextView stockName = (TextView) rowView.findViewById(R.id.stockName);
        TextView stockMovement = (TextView) rowView.findViewById(R.id.stockMovement);
        TextView stockBuy = (TextView) rowView.findViewById(R.id.stockBuy);
        TextView stockSell = (TextView) rowView.findViewById(R.id.stockSell);
        stockMovement.setText("↑");
        stockName.setText(stockData.get(position).Name);
        stockBuy.setText(String.format("%.2f",stockData.get(position).Buy));
        stockSell.setText(String.format("%.2f",stockData.get(position).Sell));
        return rowView;
    }


}
