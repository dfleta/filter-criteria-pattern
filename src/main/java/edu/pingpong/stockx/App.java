
package edu.pingpong.stockx;

import edu.pingpong.stockx.criteria.Asks;
import edu.pingpong.stockx.criteria.Bids;
import edu.pingpong.stockx.criteria.Criteria;
import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Sneaker;

public class App {

    public static void main(String[] args) {

        /**
         * Crear la zapatilla 
         * y printar sus datos.
         */

        Item sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(App.draw(sneaker));

        /**
         * Crear bids
         * y añadirlas a la zapatilla
         * en sus offers
         */

        Bid bid = new Bid("5.5", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("4.5", 480));
        sneaker.add(new Bid("5.5", 479));
        sneaker.add(new Bid("6", 472));

        /**
         * Crear asks
         * y añadirlas a la zapatilla
         * en sus offers
         */

        Ask ask = new Ask("15", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("13", 333));
        sneaker.add(new Ask("14", 340));
        sneaker.add(new Ask("13", 341));

        /**
         * Crear filtro que filtra
         * las bids de las offers
         * de la zapatilla. 
         */

        Criteria bids = new Bids();
        System.out.println("\n\t\t All BIDS");
        bids.checkCriteria(sneaker).forEach(System.out::print);

        /**
         * Crear filtro que filtra
         * las asks de las offers
         * de la zapatilla. 
         */

        Criteria asks = new Asks();
        System.out.println("\n\t\t All ASKS");
        asks.checkCriteria(sneaker).forEach(System.out::print);

        
    }

    public static String draw(Item sneaker) {
        return
        "\t\t" + sneaker.getAsk() + " Buy \t" 
        + sneaker.getBid() + " Sell \n" +  

        "\t\t" + " _    _" + "\n" +
        "\t\t" + "(_\\__/(,_" + "\n" +
        "\t\t" + "| \\ `_////-._" + "\n" +
        "\t\t" + "J_/___\"=> __/`\\" + "\n" +
        "\t\t" + "|=====;__/___./" + "\n" +
        "\t\t" + "\'-\'-\'-\"\"\"\"\"\"\"`" + "\n" +
        
        "\t" + sneaker.toString() + "\n" +
        "\t\tlast sale: " + sneaker.getSale();
    }
}
