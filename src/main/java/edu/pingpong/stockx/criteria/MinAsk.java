package edu.pingpong.stockx.criteria;

import java.util.List;
import java.util.Optional;

import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class MinAsk implements Criteria {

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        
        Optional<Offer> min = sneaker.offers()
                                        .stream()
                                        .filter(o -> o instanceof Ask)
                                        .min(Offer::compareTo);

        if (min.isPresent()) {
            return List.of(min.get());
        } else {
            return List.of();
        }
        // return List.of(max.isPresent()? max.get() : new Offer("", 0));
    }    
}
