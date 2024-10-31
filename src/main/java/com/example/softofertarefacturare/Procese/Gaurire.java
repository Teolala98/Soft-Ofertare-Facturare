package com.example.softofertarefacturare.Procese;

public class Gaurire extends AtributeProces implements Proces {

    public Gaurire() {
        super("minute", "Gaurire CNC", 0.0, 0.63, 0.020441666667, 0.3, 0.00183);
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
        return minutePrelucrare*costMinut;
    }

    @Override
    public double calculPretProces() {
        return calculPretCurent() + calculPretChirie() + calculPretAmortizare() + calculPretMinut();
    }
}
