package Procese;

import java.security.PublicKey;

public abstract class AtributeProces {
    private String tipMaterial;
    private Double minutePrelucrare;
    private Double costMinut;
    private Double minuteProiectare;
    private Double amortizare;
    private Double chirie;
    private Double marjaCompanie;
    private Double curent;

    public AtributeProces(String tipMaterial, Double minutePrelucrare, Double costMinut, Double minuteProiectare, Double amortizare, Double chirie, Double marjaCompanie, Double curent){
        this.amortizare=amortizare;
        this.chirie=chirie;
        this.costMinut=costMinut;
        this.curent=curent;
        this.marjaCompanie=marjaCompanie;
        this.minutePrelucrare=minutePrelucrare;
        this.minuteProiectare=minuteProiectare;
        this.tipMaterial=tipMaterial;
    }
}
