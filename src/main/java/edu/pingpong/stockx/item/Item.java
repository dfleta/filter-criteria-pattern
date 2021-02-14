package edu.pingpong.stockx.item;

public interface Item {
    
    int getBid();
    int getAsk();
    int getSale();
    void add(Offer offer);
}
