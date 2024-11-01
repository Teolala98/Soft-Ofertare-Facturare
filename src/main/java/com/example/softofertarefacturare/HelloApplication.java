package com.example.softofertarefacturare;

import com.example.softofertarefacturare.PDFs.GenerareFactura;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    GenerareFactura factura=new GenerareFactura();

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ofertare.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculator Oferte");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}