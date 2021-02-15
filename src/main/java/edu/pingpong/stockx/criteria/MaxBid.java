package edu.pingpong.stockx.criteria;

import java.util.List;
import java.util.Optional;

import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class MaxBid implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        /*
        List<Offer> maxList = new ArrayList<Offer>();

        Offer maxOffer = new Bid("", 0);
        for (Offer actual: sneaker.offers()) {
            if (actual instanceof Bid && actual.value() > maxOffer.value()){
                maxOffer = actual;
            }
        }
        maxList.add(maxOffer);  
        return maxList; */
        
        Optional<Offer> max = sneaker.offers()
                                        .stream()
                                        .filter(o -> o instanceof Bid)
                                        .max(Offer::compareTo);
        
        if (max.isPresent()) {
            return List.of(max.get());
        } else {
            return List.of();
        }
        // return List.of(max.isPresent()? max.get() : new Offer("", 0));
    }
}
