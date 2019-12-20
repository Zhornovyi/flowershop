package flowershop.Flower;

import java.text.ParseException;
import java.util.Scanner;

public class Plant extends Flower{

    private int potSize;

    public Plant(String name, int potSize, int length, double price, int quantity) throws ParseException {
        super(name, length, price, quantity);
        this.potSize = potSize;
    }

    public Plant() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the plant:");
        super.setName(in.nextLine());
        System.out.println("Enter the size of pot:");
        this.potSize = in.nextInt();
        System.out.println("Enter the average length of plant");
        super.setLength(in.nextInt());
        System.out.println("Enter the price of plant");
        super.setPrice(in.nextDouble());
        System.out.println("Enter the quantity:");
        super.setQuantity(in.nextInt());
    }
    @Override
    public String toString() {
        return super.getName() + "\tLength=" + super.getLength() + "\tPotSize=" + potSize + "\tPrice=" + super.getPrice() + "\tQuantity=" + super.getQuantity() + '\n';
    }

}
