package Procese;

import java.security.PublicKey;

public abstract class AtributeProces {

    protected Double minutePrelucrare;
    protected Double costMinut;

    protected Double amortizare;
    protected Double chirie;

    protected Double curent;
    protected String denumireProces;
    protected String unitateDeMasura;

    public AtributeProces(String unitateDeMasura,String denumireProces, Double minutePrelucrare, Double costMinut,  Double amortizare, Double chirie,  Double curent){
        this.amortizare=amortizare;
        this.chirie=chirie;
        this.costMinut=costMinut;
        this.curent=curent;

        this.minutePrelucrare=minutePrelucrare;


        this.unitateDeMasura=unitateDeMasura;
        this.denumireProces=denumireProces;
    }

    public Double getMinutePrelucrare() {
        return minutePrelucrare;
    }

    public void setMinutePrelucrare(Double minutePrelucrare) {
        this.minutePrelucrare = minutePrelucrare;
    }

    public Double getCostMinut() {
        return costMinut;
    }

    public void setCostMinut(Double costMinut) {
        this.costMinut = costMinut;
    }

    public Double getAmortizare() {
        return amortizare;
    }

    public void setAmortizare(Double amortizare) {
        this.amortizare = amortizare;
    }

    public Double getChirie() {
        return chirie;
    }

    public void setChirie(Double chirie) {
        this.chirie = chirie;
    }

    public Double getCurent() {
        return curent;
    }

    public void setCurent(Double curent) {
        this.curent = curent;
    }

    public String getDenumireProces() {
        return denumireProces;
    }

    public void setDenumireProces(String denumireProces) {
        this.denumireProces = denumireProces;
    }

    public String getUnitateDeMasura() {
        return unitateDeMasura;
    }

    public void setUnitateDeMasura(String unitateDeMasura) {
        this.unitateDeMasura = unitateDeMasura;
    }
}
