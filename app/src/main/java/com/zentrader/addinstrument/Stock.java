package com.zentrader.addinstrument;

import android.os.Parcel;
import android.os.Parcelable;

public class Stock implements Parcelable {

    public Stock(String symbol,String name)
    {
        Symbol=symbol;
        Name=name;
    }

    public String Movement ;
    public float Buy;
    public float Sell;
    public String Name;
    public String Symbol;

    protected Stock(Parcel in) {
        Movement = in.readString();
        Buy = in.readFloat();
        Sell = in.readFloat();
        Name = in.readString();
        Symbol = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Movement);
        dest.writeFloat(Buy);
        dest.writeFloat(Sell);
        dest.writeString(Name);
        dest.writeString(Symbol);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Stock> CREATOR = new Parcelable.Creator<Stock>() {
        @Override
        public Stock createFromParcel(Parcel in) {
            return new Stock(in);
        }

        @Override
        public Stock[] newArray(int size) {
            return new Stock[size];
        }
    };
}