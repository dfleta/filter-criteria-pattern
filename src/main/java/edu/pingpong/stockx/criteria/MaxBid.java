package edu.pingpong.stockx.criteria;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        
        List<Offer> maxList = new ArrayList<Offer>();
        maxList.add(max.isPresent()? max.get() : null);
        return maxList;        
    }
}
