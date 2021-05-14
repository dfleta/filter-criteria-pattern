package edu.pingpong.stockx.criteria;

import java.util.List;
import java.util.Optional;

import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class MaxBid implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        
        Optional<Offer> max = sneaker.offers()
                                        .stream()
                                        .filter(o -> o instanceof Bid)
                                        .max(Offer::compareTo);
        // Effective java, Item 54: Return empty collections or arrays, not nulls
        return max.isPresent()? List.of(max.get()) : List.of();
    }
}
