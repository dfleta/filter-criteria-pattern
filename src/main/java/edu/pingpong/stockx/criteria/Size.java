package edu.pingpong.stockx.criteria;

import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class Size implements Criteria {

    private String number = "";

    public Size(String size) {
        this.number = size;
    }
    
    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        
        return sneaker.offers()
                        .stream()
                        .filter(o -> o.size().equals(number))
                        .collect(Collectors.toList());
    }
}
