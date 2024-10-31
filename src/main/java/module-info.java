module com.example.softofertarefacturare {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;

    requires io;
    requires kernel;
    requires layout;
    requires java.sql;

    opens com.example.softofertarefacturare to javafx.fxml;
    exports com.example.softofertarefacturare;
    opens com.example.softofertarefacturare.Procese to javafx.base;

}