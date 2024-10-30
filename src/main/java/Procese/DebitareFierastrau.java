package Procese;

import javafx.scene.control.Alert;

public class DebitareFierastrau extends AtributeProces implements Proces {
    private double pretBandaMin;

    public DebitareFierastrau() {
        super("minute", "Debitare Fierastrau CNC", 0.0, 0.63, 0.01608666667, 0.0, 0.024);
        this.pretBandaMin = 0.15;
    }

    public DebitareFierastrau(String unitateDeMasura, String denumireProces, Double minutePrelucrare, Double costMinut, Double amortizare, Double chirie, Double curent, Double pretBandaMin) {
        super(unitateDeMasura, denumireProces, minutePrelucrare, costMinut, amortizare, chirie, curent);
        this.pretBandaMin = pretBandaMin;
    }

    public void setPretBandaMin(double pretBandaMin) {
        this.pretBandaMin = pretBandaMin;
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

    public double calculPretBandaMin() {
        return pretBandaMin * minutePrelucrare;
    }

    @Override
    public double calculPretMinut() {
        return costMinut*minutePrelucrare;
    }

    public double consumabileFierastrau(){
        return pretBandaMin*minutePrelucrare;
    }
    @Override
    public double calculPretProces() {
        return calculPretCurent() + calculPretChirie() + calculPretAmortizare() + calculPretMinut()+consumabileFierastrau();
    }


}
