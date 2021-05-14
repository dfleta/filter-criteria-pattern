package edu.pingpong.stockx.criteria;

import java.util.List;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

public class LastSale implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Criteria sales = new Sales();
        List<Offer> salesList = sales.checkCriteria(sneaker);

        return salesList.isEmpty()? 
                // Effective java, Item 54: Return empty collections or arrays, not nulls
                List.of()
                 : List.of(salesList.get(salesList.size() -1));
    }
}
