package com.zentrader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<Stock> {

    Stock[] stockData;
    public MyListAdapter(Context context, Stock[] values) {
        super(context, -1, values);
        stockData=values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.instrument_row, parent, false);
        TextView stockMovement = (TextView) rowView.findViewById(R.id.stockMovement);
        TextView stockBuy = (TextView) rowView.findViewById(R.id.stockBuy);
        TextView stockSell = (TextView) rowView.findViewById(R.id.stockSell);
        stockMovement.setText("↑");
        stockBuy.setText(stockData[position].Buy);
        stockSell.setText(stockData[position].Sell);
        return rowView;
    }


}
