package edu.pingpong.stockx.criteria;

import java.util.List;
import java.util.Optional;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class Min implements Criteria {

    private Criteria criteria = null;
    private Criteria otherCriteria = null;

    public Min(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
    
        Criteria andCriteria = new AndCriteria(criteria, otherCriteria);
        Optional<Offer> offer = andCriteria.checkCriteria(sneaker)
                                    .stream()
                                    .min(Offer::compareTo);
        
        return offer.isPresent()? List.of(offer.get()) : List.of();
    }

    
}
