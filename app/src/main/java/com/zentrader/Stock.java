package com.zentrader;

public class Stock {

    public Stock(char movement,int buy, int sell)
    {
        Movement= Character.toString(movement);
        Buy= Integer.toString(buy);
        Sell=Integer.toString(sell);

    }
    public String Movement ;
    public String Buy;
    public String Sell;
}
