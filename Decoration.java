package flowershop;

import java.util.Scanner;

public class Decoration {
    private final String name;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return  name + "   Price=" + price + "   Quantity=" + quantity;
    }


    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int inQuantity) {
        this.quantity = inQuantity;
    }

    public Decoration(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Decoration() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the decoration:");
        name = in.nextLine();
        System.out.println("Enter the price of decoration");
        price = in.nextDouble();
        System.out.println("Enter the quantity:");
        quantity = in.nextInt();
    }
}

