package flowershop;

import flowershop.Flower.Flower;
import flowershop.Flower.FreshFlower;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;


public class FlowerShop {
    private  ArrayList<Flower> allFlowers = new ArrayList<>();
    private  ArrayList<Decoration> allDecoration = new ArrayList<>();
    private  ArrayList<Bouquet> allBouquets = new ArrayList<>();

    public File getFileReport() {
        return fileReport;
    }

    private File fileReport = new File("/Users/yehorzhornovyi/IdeaProjects/FlowerShop/Report"+this.getClass().getSimpleName()+".txt");

    public ArrayList<Decoration> getAllDecoration() {
        return allDecoration;
    }

    public ArrayList<Flower> getAllFlowers() {
        return allFlowers;
    }

    public ArrayList<Bouquet> getAllBouquets() {
        return allBouquets;
    }

    public static class SortByPrice implements Comparator<Flower> {
        public int compare(Flower a, Flower b) {
            if (a.getPrice() < b.getPrice()) return -1;
            else if (a.getPrice() == b.getPrice()) return 0;
            else return 1;
        }
    }

    public static class SortByLength implements Comparator<Flower> {
        public int compare(Flower a, Flower b) {
            if (a.getLength() < b.getLength()) return -1;
            else if (a.getLength() == b.getLength()) return 0;
            else return 1;
        }
    }

}
