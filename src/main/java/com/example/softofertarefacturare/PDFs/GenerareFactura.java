package com.example.softofertarefacturare.PDFs;


import java.sql.SQLException;

public class GenerareFactura {


    public void genereaza_factura() throws SQLException {

        Factura factura = new Factura();
        factura.creare_factura();

    }



}
