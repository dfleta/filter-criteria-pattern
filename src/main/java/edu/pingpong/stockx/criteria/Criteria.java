package edu.pingpong.stockx.criteria;

import java.util.List;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public interface Criteria {

    List<Offer> checkCriteria(Item sneaker);
    
}
