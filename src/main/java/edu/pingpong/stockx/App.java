
package edu.pingpong.stockx;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Sneaker;

public class App {

    public static void main(String[] args) {

        Item sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(App.draw(sneaker));
    }

    public static String draw(Item sneaker) {
        return
        "\t\t" + sneaker.getBid() + " Buy \t" + sneaker.getAsk() + " Sell" + "\n" +  
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
