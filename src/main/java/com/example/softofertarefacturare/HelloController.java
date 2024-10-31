package com.example.softofertarefacturare;

import com.example.softofertarefacturare.Procese.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private CheckBox AbkantCheckBox;
    @FXML
    private CheckBox DebitareFierastrauCheckBox;
    @FXML
    private CheckBox DebitareGhilotinaCheckBox;
    @FXML
    private CheckBox GaurireCheckBox;
    @FXML
    private CheckBox SuduraCheckBox;
    @FXML
    private CheckBox PolizareCheckBox;
    @FXML
    private TableView<TableViewItem> tableView;
    @FXML
    private TableColumn<TableViewItem, Label> Denumire;
    @FXML
    private TableColumn<TableViewItem, Label> UnitateMasura;
    @FXML
    private TableColumn<TableViewItem, TextField> Cantitate;
    @FXML
    private TableColumn<TableViewItem, Label> Pret;
    @FXML
    private TextField denumireProdusField;
    @FXML
    private TextField profitField;
    @FXML
    private Label totalCuTvaLabel;
    @FXML
    private Label totalFaraTvaLabel;

    @FXML
    private TableView<Comenzi> comandaTableView;
    @FXML
    private TableColumn<Comenzi, String> ProdusDenumire;
    @FXML
    private TableColumn<Comenzi, Integer> ProdusCantitate;
    @FXML
    private TableColumn<Comenzi, Double> ProdusPret;

    private final ObservableList<TableViewItem> tableItems = FXCollections.observableArrayList();
    private final ObservableList<Comenzi> comenzi = FXCollections.observableArrayList();

    public void initialize() {

        Denumire.setCellValueFactory(new PropertyValueFactory<>("denumireLabel"));
        UnitateMasura.setCellValueFactory(new PropertyValueFactory<>("unitateDeMasuraLabel"));
        Cantitate.setCellValueFactory(new PropertyValueFactory<>("cantitateTextField"));
        Pret.setCellValueFactory(new PropertyValueFactory<>("pretLabel"));
        tableView.setItems(tableItems);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        ProdusDenumire.setCellValueFactory(new PropertyValueFactory<>("denumireProdus"));
        ProdusCantitate.setCellValueFactory(new PropertyValueFactory<>("cantitate"));
        ProdusPret.setCellValueFactory(new PropertyValueFactory<>("pretTotal"));
        comandaTableView.setItems(comenzi);


        profitField.textProperty().addListener((observable, oldValue, newValue) -> {
            Comenzi selectedProdus = comandaTableView.getSelectionModel().getSelectedItem();
            if (selectedProdus != null) {
                try {
                    double profit = Double.parseDouble(newValue);
                    selectedProdus.setProfit(profit);
                    updateTotalLabels();
                } catch (NumberFormatException e) {

                }
            }
        });
    }

    @FXML
    public void AbkantSelected() {
        addProcessToTable(new IndoitTabla(), AbkantCheckBox);
    }

    @FXML
    public void DebitareFierastrauSelected() {
        addProcessToTable(new DebitareFierastrau(), DebitareFierastrauCheckBox);
    }

    @FXML
    public void DebitareGhilotinaSelected() {
        addProcessToTable(new DebitareGhilotina(), DebitareGhilotinaCheckBox);
    }

    @FXML
    public void GaurireSelected() {
        addProcessToTable(new Gaurire(), GaurireCheckBox);
    }

    @FXML
    public void SuduraSelected() {
        addProcessToTable(new Sudura(), SuduraCheckBox);
    }

    @FXML
    public void PolizareSelected() {
        addProcessToTable(new Polizare(), PolizareCheckBox);
    }

    private void addProcessToTable(AtributeProces proces, CheckBox checkBox) {
        if (checkBox.isSelected()) {
            double cantitate = 0.0;
            double pret = 0.0;
            TableViewItem item = new TableViewItem(proces.getDenumireProces(), proces.getUnitateDeMasura(), cantitate, pret);
            tableItems.add(item);

            item.getCantitateTextField().textProperty().addListener((observable, oldValue, newValue) -> {
                double newCantitate;
                try {
                    newCantitate = Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    item.getPretLabel().setText("Invalid");
                    return;
                }
                proces.setMinutePrelucrare(newCantitate);
                item.getPretLabel().setText(String.format("%.2f", proces.calculPretProces()));
                tableView.refresh();
            });

            checkBox.setSelected(false);
        }
    }

    @FXML
    public void deleteSelectedItem() {
        TableViewItem selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            tableItems.remove(selectedItem);
        }
    }

    @FXML
    public void adaugaProdusInComanda() {
        String denumireProdus = denumireProdusField.getText();


        for (Comenzi produs : comenzi) {
            if (produs.getDenumireProdus().equals(denumireProdus)) {

                produs.setCantitate(produs.getCantitate() + 1);
                updateTotalLabels();
                return;
            }
        }

        double pretFaraTva = calculateTotalFaraTva();
        double profit = profitField.getText().isEmpty() ? 0 : Double.parseDouble(profitField.getText());
        double pretTotalFaraTva = pretFaraTva + (pretFaraTva * (profit / 100));
        double pretTotalCuTva = pretTotalFaraTva * 1.19;


        Comenzi produsNou = new Comenzi(denumireProdus, pretTotalFaraTva, pretTotalCuTva, profit, pretTotalFaraTva);
        produsNou.setCantitate(1);


        comandaTableView.getItems().add(produsNou);

        updateTotalLabels();


        denumireProdusField.clear();

    }

    @FXML
    public void editareProdus() {
        Comenzi selectedProdus = comandaTableView.getSelectionModel().getSelectedItem();
        if(selectedProdus!= null){

        }

    }



    @FXML
    public void stergeProdus() {
        Comenzi selectedProdus = comandaTableView.getSelectionModel().getSelectedItem();
        if (selectedProdus != null) {
            comandaTableView.getItems().remove(selectedProdus);
            updateTotalLabels();
        }
    }

    private double calculateTotalFaraTva() {
        double total = 0.0;
        for (TableViewItem item : tableItems) {
            total += Double.parseDouble(item.getPretLabel().getText());
        }
        return total;
    }

    private void updateTotalLabels() {
        double totalFaraTva = 0.0;
        double totalCuTva = 0.0;

        for (Comenzi produs : comenzi) {
            totalFaraTva += produs.getPretTotalFaraTva();
            totalCuTva += produs.getPretTotalCuTva();
        }

        totalFaraTvaLabel.setText("Total fără TVA: " + String.format("%.2f", totalFaraTva) + " lei");
        totalCuTvaLabel.setText("Total cu TVA: " + String.format("%.2f", totalCuTva) + " lei");
    }
}
