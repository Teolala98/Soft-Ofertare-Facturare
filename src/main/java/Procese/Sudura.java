//package Procese;
//
//public class Sudura extends AtributeProces implements Proces{
//    private String cmSudura;
//    private static final Double pretCurentMin = 0.014;
//    private static final Double pretAmortizareMin = 0.009925;
//    private static final Double pretSarma=90.00;
//    private static final Double pretGaz=250.00;
//
//    public Sudura(String cmSudura,String tipMaterial, Double minutePrelucrare, Double costMinut, Double minuteProiectare, Double amortizare, Double chirie, Double marjaCompanie, Double curent) {
//        super(tipMaterial, minutePrelucrare, costMinut, minuteProiectare, amortizare, chirie, marjaCompanie, curent);
//        this.cmSudura=cmSudura;
//    }
//
//
//    @Override
//    public double calculPretAmortizare() {
//        return Proces.super.calculPretAmortizare();
//    }
//
//    @Override
//    public double calculPretChirie() {
//        return Proces.super.calculPretChirie();
//    }
//
//    @Override
//    public double calculPretCurent() {
//        return Proces.super.calculPretCurent();
//    }
//
//    @Override
//    public double calculPretMinut() {
//        return Proces.super.calculPretMinut();
//    }
//}
