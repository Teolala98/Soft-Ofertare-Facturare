package com.example.softofertarefacturare;

import com.example.softofertarefacturare.BD.BazaDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ListaOferteController {



    @FXML

    private Label labelNumar;

    @FXML

    private Label labelPretTVA;

    @FXML

    private Label labelPretFara;

    @FXML

    private Label labelData;

    @FXML

    private Button veziProdButton;




    public  void initialize() throws SQLException {

        VeziOferte();
        VeziData();
        VeziPretCuTVA();
        VeziPretFara();

    }

    public void VeziOferte() throws SQLException {
        String query = "SELECT idoferte FROM oferte.oferta";
        StringBuilder valoriOferte = new StringBuilder();

        try (Connection conn = BazaDate.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String valoare = rs.getString("idoferte");
                valoriOferte.append(valoare).append("\n");
            }

            labelNumar.setText(valoriOferte.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Valori oferte: \n" + valoriOferte.toString());
    }


    public void VeziPretCuTVA() throws SQLException {
        String query = "SELECT pret_tva FROM oferte.oferta";
        StringBuilder valoriOferte = new StringBuilder();

        try (Connection conn = BazaDate.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String valoare = rs.getString("pret_tva");
                valoriOferte.append(valoare).append("\n");
            }

            labelPretTVA.setText(valoriOferte.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Valori oferte: \n" + valoriOferte.toString());
    }


    public void VeziPretFara() throws SQLException {
        String query = "SELECT pret_total FROM oferte.oferta";
        StringBuilder valoriOferte = new StringBuilder();

        try (Connection conn = BazaDate.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String valoare = rs.getString("pret_total");
                valoriOferte.append(valoare).append("\n");
            }

            labelPretFara.setText(valoriOferte.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Valori oferte: \n" + valoriOferte.toString());
    }


    public String VeziData() throws SQLException {
        String query = "SELECT data FROM oferte.oferta";
        StringBuilder valoriOferte = new StringBuilder();

        try (Connection conn = BazaDate.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String valoare = rs.getString("data");
                valoriOferte.append(valoare).append("\n");
            }

            labelData.setText(valoriOferte.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Valori oferte: \n" + valoriOferte.toString());

        return valoriOferte.toString();
    }

    public void switchToDecPanou(ActionEvent event) throws IOException, SQLException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/softofertarefacturare/viewProduseleDinOferta.fxml")));


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

}
