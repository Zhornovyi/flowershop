package flowershop;

import flowershop.Buttons.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import flowershop.Flower.Flower;
import org.apache.log4j.*;

public class Main {
    public static final Logger log = Logger.getRootLogger();

    public static void main(String[] args) throws IOException, ParseException {
        FlowerShop Kvitka = new FlowerShop();
        Map<Integer, Command> commands = new HashMap<Integer, Command>();
        commands.put(1, new NewSupply(Kvitka));
        commands.put(2, new SortFlowers(Kvitka));
        commands.put(3, new GatherBouquet(Kvitka));
        commands.put(4, new Remove(Kvitka));
        commands.put(5,new CalcRevanue(Kvitka));
        log.trace("Start of work");
        while (true) {
            int choice = 0;
            Scanner in = new Scanner(System.in);
            System.out.println("1-Make new supply:");
            System.out.println("2-Sort flowers:");
            System.out.println("3-Gather Bouquet:");
            System.out.println("4-Remove flowers");
            System.out.println("5-Calculate Total revenue");
            System.out.println("6-Exit");
            try {
                choice = in.nextInt();
                if (choice != 1 && choice != 2 && choice != 3 && choice != 4 &&choice != 5 && choice != 6) {
                    throw new IOException();
                }
                switch (choice) {
                    case 1: {
                        commands.get(1).execute();
                        break;
                    }
                    case 2: {
                        commands.get(2).execute();
                        for (Flower i : Kvitka.getAllFlowers()) {
                            System.out.println(Kvitka.getAllFlowers().indexOf(i) + "     " + i.toString());
                        }
                        break;
                    }
                    case 3: {
                        commands.get(3).execute();
                        break;
                    }
                    case 4: {
                        commands.get(4).execute();
                        break;
                    }
                    case 5: {
                        commands.get(5).execute();
                        break;
                    }
                    case 6:
                        log.trace("Program ended");
                        System.exit(0);
                }
            } catch (IOException e) {
                log.error("Invalid input");
            }
            catch(NumberFormatException e){
                log.fatal("Check the input file");
            }
        }

    }

}


