package Materiale;

import com.example.proiect2.CalculMaterial;
import com.example.proiect2.DensitateMateriale;
import com.example.proiect2.Material;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TeavaRotunda extends Material implements CalculMaterial {
    private double diametru;
    private double grosime;
    private double lungime;
    public double pretML;

    public TeavaRotunda() {}

    @Override
    public double calcPret() {
        return lungime/1000 * this.pretML;
    }

    public TeavaRotunda(double diametru, double grosime, double lungime, double pretML) {
        this.diametru = diametru;
        this.grosime = grosime;
        this.lungime = lungime;
        this.pretML = pretML;
    }

    public void introducereDateFromUI(TextField diametruField, TextField grosimeField, TextField lungimeField, TextField pretMLField) {
        try {
            this.diametru = Double.parseDouble(diametruField.getText());
            this.grosime = Double.parseDouble(grosimeField.getText());
            this.lungime = Double.parseDouble(lungimeField.getText())*1000;
            this.pretML = Double.parseDouble(pretMLField.getText());

            if (diametru <= 0 || grosime <= 0 || lungime <= 0 || pretML <= 0) {
                throw new IllegalArgumentException("Valorile introduse trebuie sa fie mai mari decat 0");
            }
        } catch (NumberFormatException e) {
            showAlert("Introduceti doar numere valide.");
        } catch (IllegalArgumentException e) {
            showAlert(e.getMessage());
        }
    }

    @Override
    public double calcSuprafata() {
        return Math.PI * diametru * lungime / 1000000;
    }

    @Override
    public double calcGreutate() {
        double densitate = "Otel".equalsIgnoreCase(this.getMaterial()) ? DensitateMateriale.densitateOtel :
                "Inox".equalsIgnoreCase(this.getMaterial()) ? DensitateMateriale.densitateInox : 0;
        return densitate * calcSuprafata() * grosime;
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Eroare");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @Override
    public String getDetalii() {
        return String.format("%.0f", getDiametru()) + "x" +
               String.format("%.0f", getGrosime()) + " mm";
    }

    public String toString(){
        return "Greutatea: " + calcGreutate() + "kg\n" +
                "Suprafata: " + calcSuprafata() + "mp\n" +
                "Pret: " + calcPret()+ "lei";
    }


    public double getDiametru() { return diametru; }
    public void setDiametru(double diametru) { this.diametru = diametru; }

    public double getGrosime() { return grosime; }
    public void setGrosime(double grosime) { this.grosime = grosime; }

    public double getLungime() { return lungime; }
    public void setLungime(double lungime) { this.lungime = lungime; }

    public double getPretML() { return pretML; }
    public void setPretML(double pretML) { this.pretML = pretML; }
}
