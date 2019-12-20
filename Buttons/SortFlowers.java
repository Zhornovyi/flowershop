package flowershop.Buttons;
//CONCRETE COMMAND

import flowershop.FlowerShop;
import flowershop.Main;

import java.io.IOException;
import java.util.Scanner;

public class SortFlowers implements Command {
    FlowerShop Kvitka;

    public SortFlowers(FlowerShop kvitka) {
        this.Kvitka = kvitka;
    }

    @Override
    public void execute() throws IOException {
            if(Kvitka.getAllFlowers().isEmpty()){
                Main.log.error("The Flower list is empty!");
                return;
            }
            System.out.println("Choose a measure:\n1-Length of stem\n2-Price of flower");
            Scanner in = new Scanner(System.in);
            int choice= in.nextInt();
            if (choice == 1) {
                Kvitka.getAllFlowers().sort(new FlowerShop.SortByLength());
            } else if (choice==2) {
                Kvitka.getAllFlowers().sort(new FlowerShop.SortByPrice());
            }
            else{
                throw new IOException();
        }
        System.out.println("Sorting complete!");

    }
}