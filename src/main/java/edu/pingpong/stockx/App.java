
package edu.pingpong.stockx;

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
         */

        Bid bid = new Bid("5.5", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("5.5", 480));
        sneaker.add(new Bid("5.5", 479));

        System.out.println("All BIDS");

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
