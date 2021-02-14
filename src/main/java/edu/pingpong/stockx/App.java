
package edu.pingpong.stockx;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Sneaker;

public class App {

    public static void main(String[] args) {

        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(App.draw(sneaker));
    }

    public static String draw(Item sneaker) {
        return 
        "\t\t" + " _    _" + "\n" +
        "\t\t" + "(_\\__/(,_" + "\n" +
        "\t\t" + "| \\ `_////-._" + "\n" +
        "\t\t" + "J_/___\"=> __/`\\" + "\n" +
        "\t\t" + "|=====;__/___./" + "\n" +
        "\t\t" + "\'-\'-\'-\"\"\"\"\"\"\"`" + "\n" +
        "\t" + sneaker.toString();
    }
}
