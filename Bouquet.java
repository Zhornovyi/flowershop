package flowershop;

import flowershop.Flower.Flower;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bouquet {
    private ArrayList<Flower> flowers = new ArrayList<>();
    private ArrayList<Decoration> decor = new ArrayList<>();

    public Bouquet(FlowerShop Shop) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("What type of bouquet do you want to collect?\n1-Fresh flowers\n2-Plastic flowers\n3-Buy the plant");
        int choice = in.nextInt();
        if (choice > 3 || choice < 1) {
            throw new IOException();
        }
        System.out.println("Here we have some flowers. You can choose whatever you want from list below!");
        for (Flower i : Shop.getAllFlowers()) {
            if(choice == 1){
                if(i.getClass().getSimpleName().equals("FreshFlower")){
                    System.out.println(Shop.getAllFlowers().indexOf(i) + "     " + i.toString());
                }
            }
            else if(choice == 2){
                if(i.getClass().getSimpleName().equals("PlasticFlowers")){
                    System.out.println(Shop.getAllFlowers().indexOf(i) + "     " + i.toString());
                }
            }
            else if (choice == 3){
                if(i.getClass().getSimpleName().equals("Plant")){
                    System.out.println(Shop.getAllFlowers().indexOf(i) + "     " + i.toString());
                }
            }
            else {
                throw new IOException();
            }
        }
        if (choice == 3){
            System.out.println("Just put the number here:");
            int choice2 = in.nextInt();
            if (choice2 > flowers.size() || choice2 < 0) {
                throw new IOException();
            }
            Flower currentFlower = Shop.getAllFlowers().get(choice2);
            currentFlower.setQuantity(currentFlower.getQuantity() - 1);
            if (currentFlower.getQuantity() == 0) {
                Shop.getAllFlowers().remove(choice2);
            }
            flowers.add(currentFlower);
            flowers.get(flowers.size() - 1).setQuantity(1);
        }
        else {
            System.out.println("Just put the numbers here(Any letter in the end to stop):");
            while (in.hasNextInt()) {
                int choice2 = in.nextInt();
                if (choice2 > flowers.size() || choice2 < 0) {
                    throw new IOException();
                }
                int count;
                Flower currentFlower = Shop.getAllFlowers().get(choice2);
                System.out.println("How much flowers do you need?");
                while ((count = in.nextInt()) > currentFlower.getQuantity()) {
                    Main.log.error("We don't have so much flowers.");
                }
                currentFlower.setQuantity(currentFlower.getQuantity() - count);
                if (currentFlower.getQuantity() == 0) {
                    Shop.getAllFlowers().remove(choice2);
                }
                flowers.add(currentFlower);
                flowers.get(flowers.size() - 1).setQuantity(count);
            }
            in.nextLine();
            in.nextLine();
            System.out.println("Do you want to decorate your bouquet?(y/n)");
            String choiceL = in.nextLine();
            if (choiceL.equals("y")) {
                for (Decoration i : Shop.getAllDecoration()) {
                    System.out.println(Shop.getAllDecoration().indexOf(i) + "     " + i.toString());
                }
                System.out.println("Just put the numbers here:");
                while (in.hasNextInt()) {
                    int choice3 = in.nextInt();
                    Decoration currentDecor = Shop.getAllDecoration().get(choice3);
                    currentDecor.setQuantity(currentDecor.getQuantity() - 1);
                    if (currentDecor.getQuantity() == 0) {
                        Shop.getAllFlowers().remove(choice3);
                    }
                    decor.add(currentDecor);
                }
            } else if (!choiceL.equals("n")) {
                throw new IOException();
            }
        }
        System.out.println("Congrats, you created the bouquet!");
        System.out.println(this.toString().replaceAll("\\[|\\]|}", " "));
    }

    @Override
    public String toString() {
        return flowers.toString().replaceAll(",", " ") + decor.toString().replaceAll("\n", " ") + "\nTotalPrice:" + calcThePrice() + "\n";
    }

    public int calcThePrice() {
        int totalPrice = 0;
        for (Flower i : flowers) {
            totalPrice += i.getPrice();
        }
        for (Decoration i : decor) {
            totalPrice += i.getPrice();
        }
        return totalPrice;
    }
}
