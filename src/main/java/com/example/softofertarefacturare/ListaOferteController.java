package com.example.softofertarefacturare;

import com.example.softofertarefacturare.BD.BazaDate;
import com.example.softofertarefacturare.Job.Oferta;
import com.example.softofertarefacturare.Procese.Comenzi;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class ListaOferteController {

    @FXML
    private ListView<Oferta> oferteListView;
    @FXML
    private TableView<Comenzi> produseTableView;
    @FXML
    private TableColumn<Comenzi, String> denumireProdusColumn;
    @FXML
    private TableColumn<Comenzi, Integer> cantitateColumn;
    @FXML
    private TableColumn<Comenzi, Double> pretTotalColumn;

    private ObservableList<Oferta> oferteList = FXCollections.observableArrayList();
    private ObservableList<Comenzi> produseList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        loadOferte();
        setupTableColumns();

        oferteListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadProduseForOferta(newValue);
            }
        });
    }

    private void loadOferte() {
        try {
            Connection conn = BazaDate.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idoferte, data FROM oferta");

            while (rs.next()) {
                int idOferte = rs.getInt("idoferte");
                LocalDate data = rs.getDate("data").toLocalDate();

                oferteList.add(new Oferta(idOferte, data));
            }

            oferteListView.setItems(oferteList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onOfertaSelected() {
        Oferta selectedOferta = oferteListView.getSelectionModel().getSelectedItem();
        if (selectedOferta != null) {
            loadProduseForOferta(selectedOferta); // Încarcă produsele pentru oferta selectată
        }
    }

    private void setupTableColumns() {
        denumireProdusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDenumireProdus()));
        cantitateColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCantitate()).asObject());
        pretTotalColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPretTotal()).asObject());
    }

    private void loadProduseForOferta(Oferta oferta) {
        produseList.clear();

        try {
            Connection conn = BazaDate.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT denumire_produs, cantitate, pret FROM produse_oferta WHERE id_oferta = " + oferta.getIdOferte();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String denumireProdus = rs.getString("denumire_produs");
                int cantitate = rs.getInt("cantitate");
                double pret = rs.getDouble("pret");
                produseList.add(new Comenzi(denumireProdus, pret, pret * 1.19, 0, pret));
            }

            produseTableView.setItems(produseList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
