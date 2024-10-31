package com.example.softofertarefacturare.Procese;

public class DebitareGhilotina extends AtributeProces implements Proces {

    public DebitareGhilotina() {
        super("minute", "Debitare Ghilotina CNC", 0.0, 0.63, 0.2, 0.0, 0.175);
    }

    public DebitareGhilotina(String unitateDeMasura, String denumireProces, Double minutePrelucrare, Double costMinut, Double amortizare, Double chirie, Double curent) {
        super(unitateDeMasura, denumireProces, minutePrelucrare, costMinut, amortizare, chirie, curent);
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

    @Override
    public double calculPretProces() {
        return calculPretCurent() + calculPretChirie() + calculPretAmortizare() + calculPretMinut();
    }
}
