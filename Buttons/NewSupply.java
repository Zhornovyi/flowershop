package flowershop.Buttons;

import flowershop.Decoration;
import flowershop.Flower.Flower;
import flowershop.Flower.FreshFlower;
import flowershop.Flower.Plant;
import flowershop.Flower.PlasticFlowers;
import flowershop.FlowerShop;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class NewSupply implements Command {
    FlowerShop Kvitka;

    public NewSupply(FlowerShop kvitka) {
        this.Kvitka = kvitka;
    }

    @Override
    public void execute() throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("How do you want to enter data?(c-console,f-file)");
        String choice = in.nextLine();
        if (choice.equals("c")){
            while (true) {
                System.out.println("Choose the type of flower\n1-Fresh flower\n2-Plastic fLower\n3-Plant");
                int input = in.nextInt();
                Flower New =null;
                switch(input){
                    case 1:{
                        New = new FreshFlower();
                        break;
                    }
                    case 2:{
                        New = new PlasticFlowers();
                        break;
                    }
                    case 3:{
                        New = new Plant();
                        break;
                    }
                }
                Kvitka.getAllFlowers().add(New);
                 System.out.println("Continue?(y/n)");
                choice = in.nextLine();
                if (choice.equals("n")) {
                    break;
                }
                else if(!choice.equals("y")){
                    throw new IOException();
                }
            }
            System.out.println("Do you want to add the decorations(y/n)");
            choice = in.nextLine();
            if (choice.equals("y")) {
                while (true) {
                    Decoration New = new Decoration();
                    Kvitka.getAllDecoration().add(New);
                    System.out.println("Continue?(y/n)");
                    choice = in.nextLine();
                    if (choice.equals("n")) {
                        break;
                    }
                    else if (choice.equals("y")) {
                        throw new IOException();
                    }
                }
            }
            else if(!choice.equals("n")){
                throw new IOException();
            }
        } else if (choice.equals("f")){
            in = new Scanner(new File("/Users/yehorzhornovyi/IdeaProjects/FlowerShop/src/main/java/flowershop/DataBase/SupplyFileFlowers.txt"));
            while (in.hasNextLine()) {
                String[] DATA = in.nextLine().split("  ", 6);
                Flower New = null;
                switch (DATA[0]){
                    case "FreshFlower":{
                        New = new FreshFlower(DATA[1], DATA[2], Integer.parseInt(DATA[3]), Double.parseDouble(DATA[4]), Integer.parseInt(DATA[5]));
                        break;
                    }
                    case "PlasticFlower":{
                        New = new PlasticFlowers(DATA[1], DATA[2], Integer.parseInt(DATA[3]), Double.parseDouble(DATA[4]), Integer.parseInt(DATA[5]));
                        break;
                    }
                    case "Plant":{
                        New = new Plant(DATA[1], Integer.parseInt(DATA[2]), Integer.parseInt(DATA[3]),  Double.parseDouble(DATA[4]), Integer.parseInt(DATA[5]));
                        break;
                    }

                }
                Kvitka.getAllFlowers().add(New);
            }
            System.out.println("Flowers have just been added");
            in = new Scanner(System.in);
            System.out.println("Do you want to add the decorations(y/n)");
            choice = in.nextLine();
            if (choice.equals("y")) {
                in = new Scanner(new File("/Users/yehorzhornovyi/IdeaProjects/FlowerShop/src/main/java/flowershop/DataBase/SupplyFileDecoration.txt"));
                while (in.hasNextLine()) {
                    String[] DATA = in.nextLine().split("  ", 3);
                    Decoration New = new Decoration(DATA[0], Double.parseDouble(DATA[1]), Integer.parseInt(DATA[2]));
                    Kvitka.getAllDecoration().add(New);
                }
            }
            else if(!choice.equals("n")){
                throw new IOException();
            }
        }
        else throw new IOException();
    }
}

