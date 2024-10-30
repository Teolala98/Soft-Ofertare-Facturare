package com.example.softofertarefacturare;

import PDFs.GenerareFactura;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    GenerareFactura factura=new GenerareFactura();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ofertare.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculator Oferte");
        stage.setScene(scene);
        stage.show();

        factura.genereaza_factura();
    }

    public static void main(String[] args) {
        launch();
    }
}