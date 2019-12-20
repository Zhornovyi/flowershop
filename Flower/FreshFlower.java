package flowershop.Flower;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FreshFlower extends Flower {
    private Date periodOfStorage;
    private String pattern = "dd-MM-yyyy";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    public FreshFlower(String name, String periodOfStorage, int length,  double price, int quantity) throws ParseException {
        super(name, length, price, quantity);
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        this.periodOfStorage = simpleDateFormat.parse(periodOfStorage);

    }

    public FreshFlower() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the flower:");
        super.setName(in.nextLine());
        System.out.println("Enter the average length of flowers");
        super.setLength(in.nextInt());
        System.out.println("Enter the period of storage of flowers(till dd-MM-yyyy)");
        in.nextLine(); //additional nextLine after nextInt
        periodOfStorage = simpleDateFormat.parse(in.nextLine());
        System.out.println("Enter the price of flower");
        super.setPrice(in.nextDouble());
        System.out.println("Enter the quantity:");
        super.setQuantity(in.nextInt());
    }

    public Date getPeriodOfStorage() {
        return periodOfStorage;
    }
    @Override
    public String toString() {
        return super.getName() + "\tLength= " + super.getLength() + "\tPeriodOfStorage= " + simpleDateFormat.format(periodOfStorage) + "\tPrice= " + super.getPrice() + "\tQuantity= " + super.getQuantity() + '\n';
    }
}