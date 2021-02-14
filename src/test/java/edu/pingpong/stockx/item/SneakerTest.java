package edu.pingpong.stockx.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SneakerTest {
    
    @Test
    public void constructorTest() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        assertNotNull(sneaker);
        assertEquals("555088-105", sneaker.getStyle());
        assertEquals("Jordan 1 Retro High Dark Mocha", sneaker.getName());
    }
}
