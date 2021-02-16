
package edu.pingpong.stockx;

import java.util.List;

import edu.pingpong.stockx.criteria.Asks;
import edu.pingpong.stockx.criteria.Bids;
import edu.pingpong.stockx.criteria.Criteria;
import edu.pingpong.stockx.criteria.LastSale;
import edu.pingpong.stockx.criteria.MaxBid;
import edu.pingpong.stockx.criteria.MinAsk;
import edu.pingpong.stockx.criteria.Sales;
import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sale;
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
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("5.5", 479));
        sneaker.add(new Bid("7", 338));
        sneaker.add(new Bid("4.5", 480));

        /**
         * Crear asks
         * y añadirlas a la zapatilla
         * en sus offers.
         */

        Ask ask = new Ask("15", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("13", 600));
        sneaker.add(new Ask("13", 333));
        sneaker.add(new Ask("14", 340));

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
         * Devuelve la bid maxima como unico
         * elemento de una lista de offers.
         * Guarda esta bid maxima en la
         * propiedad bid de sneaker.
         */

        Criteria maxBid = new MaxBid();
        List<Offer> maximum = maxBid.checkCriteria(sneaker);
        sneaker.setBid(maximum.isEmpty()? 0 : maximum.get(0).value());
        System.out.println(App.draw(sneaker));

        /**
         * Muestra la ask minima
         * de la zapatilla. 
         * 
         * Crea el filtro MinAsk que filtra
         * el minimo de las asks de la zapatilla.
         * Devuelve la ask minima como unico
         * elemento de una lista de offers.
         * Guarda esta ask minima en la propiedad
         * ask de sneaker.
         */

        Criteria minAsk = new MinAsk();
        List<Offer> minimum = minAsk.checkCriteria(sneaker);
        sneaker.setAsk(minimum.isEmpty()? 0 : minimum.get(0).value());
        System.out.println(App.draw(sneaker));

        /**
         * Dar de alta las ventas (sales) de 
         * una zapatilla.
         * Las ventas se añaden segun fecha
         * en la que se producen, de mas antigua
         * a ultima.
         */

        Sale sale = new Sale("10", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9", 352));
        sneaker.add(new Sale("10", 404));
        sneaker.add(new Sale("8", 372));

        /**
         * Crear el filtro "Sales" que filtra
         * solo las sales de entre las 
         * offers de la zapatilla.
         */

        Criteria sales = new Sales();
        System.out.println("\n\t\t All SALES");
        sales.checkCriteria(sneaker).forEach(System.out::print);
        
        /**
         * Crea un filtro que devuelva
         * la ULTIMA de las ventas (que 
         * es la ultima en ser dada de alta
         * en sneaker).
         */
        
        Criteria lastSale = new LastSale();
        
        List<Offer> actualSale = lastSale.checkCriteria(sneaker);
        sneaker.setSale(actualSale.isEmpty()? 0 : actualSale.get(0).value());
        System.out.println(App.draw(sneaker));

        // printar last sale
        // mostrar las bids sin esa

        // mostrar las listas ordenadas
        
        
    }

    public static String draw(Item sneaker) {
        return
        "\n\n\t\t" + sneaker.getAsk() + " Buy\t" 
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
