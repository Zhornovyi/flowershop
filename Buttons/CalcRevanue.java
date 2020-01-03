package flowershop.Buttons;

import flowershop.FlowerShop;
import flowershop.Main;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class CalcRevanue implements Command{
    FlowerShop Kvitka;

    public CalcRevanue(FlowerShop kvitka) {
        this.Kvitka = kvitka;
    }
    @Override
    public void execute() throws IOException, ParseException {
        Scanner in =new Scanner (System.in);
        double TotalRevenue = 0;
        Scanner inFile = new Scanner(new File("/Users/yehorzhornovyi/IdeaProjects/FlowerShop 2.0/ReportFlowerShop.txt"));
        try {
            while (inFile.hasNextLine()){
                String line = inFile.nextLine();
                if(line.indexOf("TotalPrice")!=-1){
                    String[] DATA = line.split(":", 2);
                    TotalRevenue+= Double.parseDouble(DATA[1]);
                }
            }
        }
        catch (Exception e){
            Main.log.error("Follow the pattern of data");
        }
        System.out.println("Total Revanue: "+TotalRevenue);
    }
}
