package Materiale;



import java.util.ArrayList;

public class Necesar {
    private ArrayList<Material> materiale = new ArrayList<>();

    public void adaugaMaterial(Material material) {
        materiale.add(material);
    }

    public String afisare() {
        StringBuilder sb = new StringBuilder();

        for (Material material : materiale) {
            sb.append(material.getClass().getSimpleName()).append(" ")
                    .append(material.getMaterial()).append("\n");

            sb.append(material.getDetalii()).append("\n");

            sb.append("Pret: ").append(String.format("%.1f", material.calcPret())).append(" lei\n\n");
        }

        return sb.toString();
    }


    public double totalPreturi() {
        double total = 0;

        for (Material material : materiale) {
            total += material.calcPret();
        }

        return total;
    }
}






