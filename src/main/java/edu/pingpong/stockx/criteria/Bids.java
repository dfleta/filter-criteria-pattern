package edu.pingpong.stockx.criteria;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class Bids implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        return sneaker.offers()
                        .stream()
                        .filter(o -> o instanceof Bid)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
    }
}
