
package edu.pingpong.stockx;

import java.util.Optional;

import edu.pingpong.stockx.criteria.Asks;
import edu.pingpong.stockx.criteria.Bids;
import edu.pingpong.stockx.criteria.Criteria;
import edu.pingpong.stockx.criteria.MaxBid;
import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sneaker;

public class App {

    public static void main(String[] args) {

        /**
         * Crear la zapatilla 
         * y printar sus datos.
         * 
         * Lee la funcion draw() del main
         * para conocer que propiedades
         * de la zapatilla han de printarse.
         */

        Item sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(App.draw(sneaker));

        /**
         * Crear bids
         * y añadirlas a la zapatilla
         * en sus offers.
         */

        Bid bid = new Bid("5.5", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("4.5", 480));
        sneaker.add(new Bid("5.5", 479));
        sneaker.add(new Bid("6", 472));

        /**
         * Crear asks
         * y añadirlas a la zapatilla
         * en sus offers.
         */

        Ask ask = new Ask("15", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("13", 333));
        sneaker.add(new Ask("14", 340));
        sneaker.add(new Ask("13", 341));

        /**
         * Crear el filtro "Bids" que filtra
         * solo las bids de entre las 
         * offers de la zapatilla. 
         */

        Criteria bids = new Bids();
        System.out.println("\n\t\t All BIDS");
        bids.checkCriteria(sneaker).forEach(System.out::print);

        /**
         * Crea el filtro "Asks" que filtra
         * solo las asks de entre las
         * offers de la zapatilla. 
         */

        Criteria asks = new Asks();
        System.out.println("\n\t\t All ASKS");
        asks.checkCriteria(sneaker).forEach(System.out::print);

        /**
         * Muestra la bid maxima
         * de la zapatilla. 
         * 
         * Crea el filtro MaxBid que filtra
         * el maximo de las bids de la zapatilla.
         */

        Criteria maxBid = new MaxBid();
        Optional<Offer> maximum = Optional.ofNullable(maxBid.checkCriteria(sneaker).get(0));
        sneaker.setBid(maximum.isPresent()? maximum.get().value() : 0);
        System.out.println(App.draw(sneaker));

        /**
         * Muestra la ask minima
         * de la zapatilla. 
         * 
         * Crea el filtro MinAsk que filtra
         * el minimo de las asks de la zapatilla.
         */
        
    }

    public static String draw(Item sneaker) {
        return
        "\n\t\t" + sneaker.getAsk() + " Buy \t" 
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
