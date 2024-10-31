package com.example.softofertarefacturare.Procese;

public class Polizare extends AtributeProces implements Proces {

    private final double costDisc = 10.0;
    private final double durataDisc = 30.0;

    public Polizare() {
        super("minute", "Polizare", 0.0, 0.63, 0.00661376, 0.0183, 0.0);
    }

    public void setMinutePrelucrare(double minutePrelucrare) {
        this.minutePrelucrare = minutePrelucrare;
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
        return costMinut*minutePrelucrare;
    }

    public double calculPretDisc() {
        return (minutePrelucrare / durataDisc) * costDisc;
    }

    @Override
    public double calculPretProces() {
        return calculPretCurent() + calculPretChirie() + calculPretAmortizare() + calculPretMinut() + calculPretDisc();
    }
}
