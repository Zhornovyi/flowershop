package flowershop.Buttons;

import flowershop.Flower.Flower;
import flowershop.Flower.FreshFlower;
import flowershop.FlowerShop;
import flowershop.Main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Remove implements Command {
    FlowerShop Kvitka;

    public Remove(FlowerShop kvitka) {
        this.Kvitka = kvitka;
    }

    @Override
    public void execute() throws ParseException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("1-enter the flowers that you want to remove\n2-remove all spoilt flowers");
        if (in.nextInt() == 1) {
            while (true) {
                for (Flower i : Kvitka.getAllFlowers()) {
                    System.out.println(Kvitka.getAllFlowers().indexOf(i) + "     " + i.toString());
                }
                System.out.println("Enter the num:");
                int choice = in.nextInt();
                if (choice > Kvitka.getAllFlowers().size() || choice < 0) {
                    throw new IOException();
                }
                Kvitka.getAllFlowers().remove(in.nextInt());
            }
        } else {
            for (Flower i : Kvitka.getAllFlowers()) {
                if(i.getClass().getSimpleName().equals("FreshFlower")){
                    System.out.println(Kvitka.getAllFlowers().indexOf(i) + "     " + i.toString());
                }
            }
            System.out.println("What day is today?(dd-MM-yyyy)");
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            in.nextLine();
            try {
                Date date = simpleDateFormat.parse(in.nextLine());
                for (int i = 0; i < Kvitka.getAllFlowers().size(); i++) {
                    if(Kvitka.getAllFlowers().get(i) instanceof FreshFlower) {
                        if (date.after(((FreshFlower) Kvitka.getAllFlowers().get(i)).getPeriodOfStorage())) {
                            Kvitka.getAllFlowers().remove(i);
                            i--;
                        }
                    }
                }
            }
            catch (Exception e){
                Main.log.error("Follow the pattern of data");
            }
        }
        for (Flower i : Kvitka.getAllFlowers()) {
            System.out.println(Kvitka.getAllFlowers().indexOf(i) + "     " + i.toString());
        }

    }
}
