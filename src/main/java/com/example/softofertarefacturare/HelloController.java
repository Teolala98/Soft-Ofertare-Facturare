package com.example.softofertarefacturare;

import Procese.IndoitTabla;
import Procese.DebitareFierastrau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private CheckBox AbkantCheckBox;
    @FXML
    private CheckBox DebitareFierastrauCheckBox; // CheckBox pentru Debitare Fierăstrău
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

    private final ObservableList<TableViewItem> tableItems = FXCollections.observableArrayList();

    public void initialize() {
        Denumire.setCellValueFactory(new PropertyValueFactory<>("denumireLabel"));
        UnitateMasura.setCellValueFactory(new PropertyValueFactory<>("unitateDeMasuraLabel"));
        Cantitate.setCellValueFactory(new PropertyValueFactory<>("cantitateTextField"));
        Pret.setCellValueFactory(new PropertyValueFactory<>("pretLabel"));
        tableView.setItems(tableItems);
    }

    @FXML
    public void AbkantSelected() {
        if (AbkantCheckBox.isSelected()) {
            double cantitate = 0.0;

            IndoitTabla indoitTabla = new IndoitTabla();

            double pret = 0.0;
            TableViewItem item = new TableViewItem(indoitTabla.getDenumireProces(), indoitTabla.getUnitateDeMasura(), cantitate, pret);
            tableItems.add(item);

            item.getCantitateTextField().textProperty().addListener((observable, oldValue, newValue) -> {
                double newCantitate;
                try {
                    newCantitate = Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    item.getPretLabel().setText("Invalid");
                    return;
                }
                indoitTabla.setMinutePrelucrare(newCantitate);
                item.getPretLabel().setText(String.format("%.2f", indoitTabla.calculPretProces()));
                tableView.refresh();
            });

            // Resetare câmpuri după adăugare
            AbkantCheckBox.setSelected(false);
        }
    }

    @FXML
    public void DebitareFierastrauSelected() {
        if (DebitareFierastrauCheckBox.isSelected()) {
            double cantitate = 0.0;

            DebitareFierastrau debitareFierastrau = new DebitareFierastrau();
            debitareFierastrau.setPretBandaMin(0.15);

            double pret = 0.0;
            TableViewItem item = new TableViewItem(debitareFierastrau.getDenumireProces(), debitareFierastrau.getUnitateDeMasura(), cantitate, pret);
            tableItems.add(item);

            item.getCantitateTextField().textProperty().addListener((observable, oldValue, newValue) -> {
                double newCantitate;
                try {
                    newCantitate = Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    item.getPretLabel().setText("Invalid");
                    return;
                }
                debitareFierastrau.setMinutePrelucrare(newCantitate);
                item.getPretLabel().setText(String.format("%.2f", debitareFierastrau.calculPretProces()));
                tableView.refresh();
            });

            // Resetare câmpuri după adăugare
            DebitareFierastrauCheckBox.setSelected(false);
        }
    }
}
