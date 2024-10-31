package com.example.softofertarefacturare.Procese;

public class IndoitTabla extends AtributeProces implements Proces {

    public IndoitTabla() {
        super("minute", "Prelucrare Abkant CNC", 0.0, 0.63, 0.2, 0.3, 0.175);
    }

    public IndoitTabla(String unitateDeMasura, String denumireProces, Double minutePrelucrare, Double costMinut, Double amortizare, Double chirie, Double curent) {
        super(unitateDeMasura, denumireProces, minutePrelucrare, costMinut, amortizare, chirie, curent);
    }

    public void setMinutePrelucrare(double minutePrelucrare) {
        this.minutePrelucrare = minutePrelucrare;
    }

    public void setDenumireProces(String denumireProces) {
        this.denumireProces = denumireProces;
    }

    @Override
    public double calculPretAmortizare() {
        return minutePrelucrare * amortizare;
    }

    @Override
    public double calculPretChirie() {
        return chirie * minutePrelucrare;
    }

    @Override
    public double calculPretCurent() {
        return curent * minutePrelucrare;
    }

    @Override
    public double calculPretMinut() {
        return minutePrelucrare*costMinut;
    }

    @Override
    public double calculPretProces() {
        return calculPretCurent() + calculPretChirie() + calculPretAmortizare() + calculPretMinut();
    }

}
