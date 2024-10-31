

package com.example.softofertarefacturare.Procese;

    public class Sudura extends AtributeProces implements Proces {


        private double pretcmSudura;
        private double cmSudura;

        public Sudura() {
            super("cm", "Sudura MIG-MAG", 0.0, 0.63, 0.009925, 0.3, 0.014);
            this.pretcmSudura=0.10325;
            this.cmSudura = 0.0;
        }

        public void setCmSudura(double cmSudura) {
            this.cmSudura = cmSudura;
        }


       public double calculMinutePrelucrare(){
            return cmSudura/4;
       }


        @Override
        public double calculPretAmortizare() {
            return calculMinutePrelucrare() * amortizare;
        }

        @Override
        public double calculPretChirie() {
            return chirie * calculMinutePrelucrare();
        }

        @Override
        public double calculPretCurent() {
            return curent * calculMinutePrelucrare();
        }


        @Override
        public double calculPretMinut() {
            return calculMinutePrelucrare()*costMinut;
        }

        public double calculConsumabile(){
            return pretcmSudura*cmSudura;
        }

        @Override
        public double calculPretProces() {
            return calculPretCurent() + calculPretChirie() + calculPretAmortizare() + calculPretMinut()+calculConsumabile();
        }
    }
