package flowershop.Buttons;

import flowershop.Bouquet;
import flowershop.FlowerShop;

import java.io.*;

//CONCRETE COMMAND
public class GatherBouquet implements Command {
    FlowerShop Kvitka;

    public GatherBouquet(FlowerShop kvitka) {
        this.Kvitka = kvitka;
    }

    @Override
    public void execute() throws IOException {
        Bouquet bouquet = new Bouquet(Kvitka);
        Kvitka.getAllBouquets().add(bouquet);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Kvitka.getFileReport(),true)));
        out.print(bouquet.toString().replaceAll("\\[|\\]|}", " "));
        out.close();
    }
}
