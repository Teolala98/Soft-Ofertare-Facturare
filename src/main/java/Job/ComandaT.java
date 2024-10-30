package Job;

import Procese.AtributeProces;
import com.example.softofertarefacturare.TableViewItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComandaT {
    private String denumireProdus;
    private double pretTotalFaraTva;
    private double pretTotalCuTva;
    private double profit;
    private int cantitate;
    private ObservableList<TableViewItem> tableItems;

    public ComandaT(String denumireProdus, double pretTotalFaraTva, double pretTotalCuTva, double profit) {
        this.denumireProdus = denumireProdus;
        this.pretTotalFaraTva = pretTotalFaraTva;
        this.pretTotalCuTva = pretTotalCuTva;
        this.profit = profit;
        this.tableItems = FXCollections.observableArrayList();
    }

    // Getters și Setters pentru proprietăți
    public String getDenumireProdus(AtributeProces atributeProces) {
        return atributeProces.getDenumireProces();
    }

    public void setDenumireProdus(String denumireProdus) {
        this.denumireProdus = denumireProdus;
    }

    public double getPretTotalFaraTva() {
        return pretTotalFaraTva;
    }

    public void setPretTotalFaraTva(double pretTotalFaraTva) {
        this.pretTotalFaraTva = pretTotalFaraTva;
    }

    public double getPretTotalCuTva() {
        return pretTotalCuTva;
    }

    public void setPretTotalCuTva(double pretTotalCuTva) {
        this.pretTotalCuTva = pretTotalCuTva;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public ObservableList<TableViewItem> getTableItems() {
        return tableItems;
    }

    public void setTableItems(ObservableList<TableViewItem> tableItems) {
        this.tableItems = tableItems;
    }
}
