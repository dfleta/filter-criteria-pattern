package edu.pingpong.stockx.criteria;

import java.util.ArrayList;
import java.util.List;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class AndCriteria implements Criteria {

    private Criteria criteria = null;
    private Criteria otherCriteria = null;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        List<Offer> firstCriteriaItems = criteria.checkCriteria(sneaker);
        List<Offer> otherCriteriaItems = otherCriteria.checkCriteria(sneaker);

        List<Offer> items = new ArrayList<Offer>();
        for (Offer offer : firstCriteriaItems) {
            if (otherCriteriaItems.contains(offer)) {
                items.add(offer);
            }
        }
        return items;
    }
}
