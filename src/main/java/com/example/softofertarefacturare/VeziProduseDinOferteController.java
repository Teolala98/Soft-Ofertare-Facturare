package com.example.softofertarefacturare;

import com.example.softofertarefacturare.BD.BazaDate;
import com.example.softofertarefacturare.PDFs.GenerareFactura;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;



    public class VeziProduseDinOferteController {



        @FXML

        private Label nrOfertaLabel;

        @FXML

        private Label denProdLabel;

        @FXML

        private Label cantitateLabel;

        @FXML

        private Label pretLabel;

        @FXML

        private TextField introduLabel;

        @FXML

        private Button afiseazaButton;

        GenerareFactura factura= new GenerareFactura();


        @FXML
        public void initialize() {

            if (introduLabel == null) {
                System.out.println("introduLabel este null");
            } else {
                System.out.println("introduLabel este initializat");
            }
        }






        public String VeziNrOferta() throws SQLException {
            if (introduLabel == null) { throw new NullPointerException("introduLabel este null"); }
            System.out.println("pisici");
            String ofertaaa = introduLabel.getText();
            String query = "SELECT id_oferta FROM oferte.produse_oferta WHERE id_oferta = ?";
            StringBuilder valoriOferte = new StringBuilder();

            try (Connection conn = BazaDate.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, ofertaaa);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String valoare = rs.getString("id_oferta");
                        valoriOferte.append(valoare).append("\n");
                    }
                    nrOfertaLabel.setText(valoriOferte.toString());

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return valoriOferte.toString();
        }





        public String VeziDenProd() throws SQLException {
            if (introduLabel == null) { throw new NullPointerException("introduLabel este null"); }
            String ofertaaa = introduLabel.getText();
            String query = "SELECT denumire_produs FROM oferte.produse_oferta WHERE id_oferta = ?";
            StringBuilder valoriOferte = new StringBuilder();

            try (Connection conn = BazaDate.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, ofertaaa);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String valoare = rs.getString("denumire_produs");
                        valoriOferte.append(valoare).append("\n");
                    }
                    denProdLabel.setText(valoriOferte.toString());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return valoriOferte.toString();
        }




        public String VeziCantitate() throws SQLException {
            if (introduLabel == null) { throw new NullPointerException("introduLabel este null"); }
            String ofertaaa = introduLabel.getText();
            String query = "SELECT cantitate FROM oferte.produse_oferta WHERE id_oferta = ?";
            StringBuilder valoriOferte = new StringBuilder();

            try (Connection conn = BazaDate.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, ofertaaa);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String valoare = rs.getString("cantitate");
                        valoriOferte.append(valoare).append("\n");
                    }
                    cantitateLabel.setText(valoriOferte.toString());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return valoriOferte.toString();

        }





        public String VeziPret() throws SQLException {
            if (introduLabel == null) { throw new NullPointerException("introduLabel este null"); }
            String ofertaaa = introduLabel.getText();
            String query = "SELECT pret FROM oferte.produse_oferta WHERE id_oferta = ?";
            StringBuilder valoriOferte = new StringBuilder();

            try (Connection conn = BazaDate.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, ofertaaa);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String valoare = rs.getString("pret");
                        valoriOferte.append(valoare).append("\n");
                    }
                    pretLabel.setText(valoriOferte.toString());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Valori oferte: \n" + valoriOferte.toString());
            return valoriOferte.toString();
        }


        public void switchToDecPanou(ActionEvent event) throws IOException, SQLException {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/softofertarefacturare/lista_oferte.fxml")));


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();



        }


        public void genereaza_factura() throws SQLException {

            factura.genereaza_factura();

        }
        public void Final() throws SQLException {
            System.out.println("Apelare metoda Final");
            if (introduLabel == null) {
                System.out.println("introduLabel este null");
            } else {
                System.out.println("introduLabel este: " + introduLabel.getText());
            }
            VeziPret();
            VeziNrOferta();
            VeziDenProd();
            VeziCantitate();
        }


    }


