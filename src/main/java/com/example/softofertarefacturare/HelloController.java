package com.example.softofertarefacturare;

import Procese.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

    @FXML private CheckBox SuduraCheckBox;

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
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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


            AbkantCheckBox.setSelected(false);
        }
    }

    @FXML
    public void DebitareFierastrauSelected() {
        if (DebitareFierastrauCheckBox.isSelected()) {
            double cantitate = 0.0;

            DebitareFierastrau debitareFierastrau = new DebitareFierastrau();

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


            DebitareFierastrauCheckBox.setSelected(false);
        }
    }

    @FXML
    public void DebitareGhilotinaSelected() {
        if (DebitareGhilotinaCheckBox.isSelected()) {
            double cantitate = 0.0;

            DebitareGhilotina debitareGhilotina = new DebitareGhilotina();

            double pret = 0.0;
            TableViewItem item = new TableViewItem(debitareGhilotina.getDenumireProces(), debitareGhilotina.getUnitateDeMasura(), cantitate, pret);
            tableItems.add(item);

            item.getCantitateTextField().textProperty().addListener((observable, oldValue, newValue) -> {
                double newCantitate;
                try {
                    newCantitate = Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    item.getPretLabel().setText("Invalid");
                    return;
                }
                debitareGhilotina.setMinutePrelucrare(newCantitate);
                item.getPretLabel().setText(String.format("%.2f", debitareGhilotina.calculPretProces()));
                tableView.refresh();
            });


            DebitareGhilotinaCheckBox.setSelected(false);
        }
    }

    @FXML
    public void GaurireSelected() {
        if (GaurireCheckBox.isSelected()) {
            double cantitate = 0.0;

            Gaurire gaurire = new Gaurire();

            double pret = 0.0;
            TableViewItem item = new TableViewItem(gaurire.getDenumireProces(), gaurire.getUnitateDeMasura(), cantitate, pret);
            tableItems.add(item);

            item.getCantitateTextField().textProperty().addListener((observable, oldValue, newValue) -> {
                double newCantitate;
                try {
                    newCantitate = Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    item.getPretLabel().setText("Invalid");
                    return;
                }
                gaurire.setMinutePrelucrare(newCantitate);
                item.getPretLabel().setText(String.format("%.2f", gaurire.calculPretProces()));
                tableView.refresh();
            });


            GaurireCheckBox.setSelected(false);
        }
    }


        @FXML
        public void SuduraSelected() {
            if (SuduraCheckBox.isSelected()) {
                double cmSudura = 0.0;

                Sudura sudura = new Sudura();

                double pret = 0.0;
                TableViewItem item = new TableViewItem(sudura.getDenumireProces(), sudura.getUnitateDeMasura(), cmSudura, pret);
                tableItems.add(item);

                item.getCantitateTextField().textProperty().addListener((observable, oldValue, newValue) -> {
                    double newCmSudura;
                    try {
                        newCmSudura = Double.parseDouble(newValue);
                    } catch (NumberFormatException e) {
                        item.getPretLabel().setText("Invalid");
                        return;
                    }
                    sudura.setCmSudura(newCmSudura);
                    item.getPretLabel().setText(String.format("%.2f", sudura.calculPretProces()));
                    tableView.refresh();
                });

                SuduraCheckBox.setSelected(false);
            }
        }
    @FXML
    public void deleteSelectedItem() {
        TableViewItem selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem!= null){
            tableItems.remove(selectedItem);
        }
    }
}


