package Job;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Procese.AtributeProces;

public class Comenzi {
    private String denumireProdus;
    private int cantitate;
    private double pretFaraTva;
    private double pretCuTva;
    private double profit;
    private ObservableList<AtributeProces> procese;

    public Comenzi(String denumireProdus, int cantitate, double pretFaraTva, double profit) {
        this.denumireProdus = denumireProdus;
        this.cantitate = cantitate;
        this.pretFaraTva = pretFaraTva;
        this.pretCuTva = pretFaraTva * 1.19;
        this.profit = profit;
        this.procese = FXCollections.observableArrayList();
    }

    public void adaugaProces(AtributeProces proces) {
        this.procese.add(proces);
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getPretFaraTva() {
        return pretFaraTva;
    }

    public double getPretCuTva() {
        return pretCuTva;
    }

    public double getProfit() {
        return profit;
    }

    public ObservableList<AtributeProces> getProcese() {
        return procese;
    }
}
