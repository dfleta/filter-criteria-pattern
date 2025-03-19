package edu.pingpong.stockx.item;

public interface Offer extends Comparable<Offer> {

    String size();
    int value();
    @Override
    int compareTo(Offer offer);
    
}
