package edu.pingpong.stockx.item;

import java.util.List;

public interface Item {
    
    int getBid();
    int getAsk();
    int getSale();
    void add(Offer offer);
    List<Offer> offers();
}
