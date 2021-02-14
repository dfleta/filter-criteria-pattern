package edu.pingpong.stockx.item;

public class Sneaker implements Item {

    private String style = "";
    private String name = "";

    public Sneaker(String style, String name) {
        this.style = style;
        this.name = name;
    }

	public Object getStyle() {
		return this.style;
	}

	public Object getName() {
		return this.name;
	}

    @Override
    public String toString() {
        return this.name + "\n \t \t" + this.style;
    }
    
}
