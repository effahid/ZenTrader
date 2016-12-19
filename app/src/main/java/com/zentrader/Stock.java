package com.zentrader;

public class Stock {

    public Stock(char movement,float buy, float sell)
    {
        Movement= Character.toString(movement);
        Buy= String.format("%.2f",buy);
        Sell=String.format("%.2f",sell);

    }
    public String Movement ;
    public String Buy;
    public String Sell;
}
