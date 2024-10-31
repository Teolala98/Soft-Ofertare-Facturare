package com.example.softofertarefacturare.Procese;

import com.example.softofertarefacturare.TableViewItem;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;

public class Comenzi {
    private String denumireProdus;
    private double pretTotalFaraTva;
    private double pretTotalCuTva;
    private double profit;
    private int cantitate;
    private DoubleProperty pretTotal;
    private ObservableList<TableViewItem> tableItems;

    public Comenzi(String denumireProdus, double pretTotalFaraTva, double pretTotalCuTva, double profit,double pretTotal) {
        this.denumireProdus = denumireProdus;
        this.pretTotalFaraTva = pretTotalFaraTva;
        this.pretTotalCuTva = pretTotalCuTva;
        this.profit = profit;
        this.cantitate = 1;
        this.pretTotal = new SimpleDoubleProperty(pretTotal);
    }

    public double getPretTotal() {
        return pretTotal.get();
    }

    public void setPretTotal(double pretTotal) {
        this.pretTotal.set(pretTotal);
    }

    public DoubleProperty pretTotalProperty() {
        return pretTotal;
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public double getPretTotalFaraTva() {
        return pretTotalFaraTva;
    }

    public double getPretTotalCuTva() {
        return pretTotalCuTva;
    }

    public double getProfit() {
        return profit;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setProfit(double profit) {
        this.profit = profit;
        // Recalculăm prețurile total fără și cu TVA după actualizarea profitului
        this.pretTotalFaraTva += pretTotalFaraTva * (profit / 100);
        this.pretTotalCuTva = this.pretTotalFaraTva * 1.19;
    }

    public ObservableList<TableViewItem> getTableItems() {
        return tableItems;
    }

    public void setTableItems(ObservableList<TableViewItem> tableItems) {
        this.tableItems = tableItems;
    }
}
