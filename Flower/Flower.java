package flowershop.Flower;
import java.util.Date;
import java.text.ParseException;

public class Flower {
    private String name;
    private int length;
    private double price;
    private int quantity;

    public Flower(String name, int length, double price, int quantity) throws ParseException {
        this.name = name;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }


    public Flower(){
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLength() {
        return length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
