package flowershop.Flower;

import java.text.ParseException;
import java.util.Scanner;

public class PlasticFlowers extends Flower{
    private String type;

    public PlasticFlowers(String name, String type, int length, double price, int quantity ) throws ParseException {
        super(name, length, price, quantity);
        this.type = type;
    }

    public PlasticFlowers() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the plastic flower:");
        super.setName(in.nextLine());
        System.out.println("For what we use this flower:");
        type = in.nextLine();
        System.out.println("Enter the average length of flower");
        super.setLength(in.nextInt());
        System.out.println("Enter the price of flower");
        super.setPrice(in.nextDouble());
        System.out.println("Enter the quantity:");
        super.setQuantity(in.nextInt());

    }
    @Override
    public String toString() {
        return super.getName() + "\tLength=" + super.getLength() + "\tType=" + type + "\tPrice=" + super.getPrice() + "\tQuantity=" + super.getQuantity() + '\n';
    }
}
