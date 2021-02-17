package edu.pingpong.stockx.item;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BidTest {

    @Test
    public void constructorTest() {
        Bid bid = new Bid("9.5", 282);
        assertEquals(282, bid.value());
        assertEquals("9.5", bid.size());
    }
    
}
