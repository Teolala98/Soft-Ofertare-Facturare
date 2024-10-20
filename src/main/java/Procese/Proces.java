package Procese;

public interface Proces {
    default double calculPretAmortizare(){
        return 0;
    };
    default double calculPretChirie(){
        return 0;
    };
    default double calculPretCurent(){
        return 0;
    };
    default double calculPretMinut(){
        return 0;
    }
}
