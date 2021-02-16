package edu.pingpong.stockx.criteria;

import java.util.List;
import java.util.stream.Collectors;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sale;

public class LastSale implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        
        List<Offer> sales = sneaker.offers()
                                    .stream()
                                    .filter(o -> o instanceof Sale)
                                    .collect(Collectors.toList());

        return sales.isEmpty()? 
                List.of()
                 : List.of(sales.get(sales.size() -1));
    }
}
