package com.example.softofertarefacturare.Job;

import java.time.LocalDate;

public class Oferta {


        private int idOferta;
        private LocalDate data;

        public Oferta(int idOferta, LocalDate data) {
            this.idOferta = idOferta;
            this.data = data;
        }

        public int getIdOferta() {
            return idOferta;
        }

        public LocalDate getData() {
            return data;
        }


    public String getIdOferte() {
            return String.valueOf(this.idOferta);
    }
}
