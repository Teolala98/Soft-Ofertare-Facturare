package Job;

import com.example.softofertarefacturare.TableViewItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Comanda {
    private String denumireProdus;
    private double totalFaraTva;
    private double totalCuTva;
    private double profit;
    private double cantitate;
    private ObservableList<TableViewItem> tableItems;

    public Comanda(String denumireProdus, double totalFaraTva, double totalCuTva, double profit) {
        this.denumireProdus = denumireProdus;
        this.totalFaraTva = totalFaraTva;
        this.totalCuTva = totalCuTva;
        this.profit = profit;
        this.tableItems = FXCollections.observableArrayList();

    }


    public void setCantitate(double cantitate) {
        this.cantitate = cantitate;
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public void setDenumireProdus(String denumireProdus) {
        this.denumireProdus = denumireProdus;
    }

    public double getTotalFaraTva() {
        return totalFaraTva;
    }

    public void setTotalFaraTva(double totalFaraTva) {
        this.totalFaraTva = totalFaraTva;
    }

    public double getTotalCuTva() {
        return totalCuTva;
    }

    public void setTotalCuTva(double totalCuTva) {
        this.totalCuTva = totalCuTva;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public ObservableList<TableViewItem> getTableItems() {
        return tableItems;
    }

    public void setTableItems(ObservableList<TableViewItem> tableItems) {
        this.tableItems = tableItems;
}
}