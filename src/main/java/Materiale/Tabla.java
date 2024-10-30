package Materiale;

import com.example.proiect2.CalculMaterial;
import com.example.proiect2.DensitateMateriale;
import com.example.proiect2.Material;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Tabla extends Material implements CalculMaterial {
    private double latime;
    private double lungime;
    private double greutate;
    public double pretKG;
    private double grosime;
    private double suprafata;
    private double pretFoaie;

    public Tabla(double latime, double lungime, double grosime, double pretKG) {
        this.latime = latime;
        this.lungime = lungime;
        this.grosime = grosime;
        this.pretKG = pretKG;
    }

    public Tabla() {}

    public void introducereDateFromUI(TextField lungimeField, TextField latimeField,
                                      TextField grosimeField, TextField pretKGField) {
        try {
            this.lungime = Double.parseDouble(lungimeField.getText());
            this.latime = Double.parseDouble(latimeField.getText());
            this.grosime = Double.parseDouble(grosimeField.getText());
            this.pretKG = Double.parseDouble(pretKGField.getText());
            if (lungime <= 0 || latime <= 0 || grosime <= 0 || pretKG <= 0) {
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
        return this.suprafata = this.latime * this.lungime * 2 / 1000000;
    }

    @Override
    public double calcGreutate() {
        if ("Otel".equalsIgnoreCase(this.material)) {
            return this.greutate = DensitateMateriale.densitateOtel * (this.lungime * this.latime * this.grosime) / 1000000;
        } else if ("Inox".equalsIgnoreCase(material)) {
            return this.greutate = DensitateMateriale.densitateInox * (this.lungime * this.latime * this.grosime) / 1000000;
        }
        return 0;
    }


    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Eroare");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @Override
    public double calcPret() {
        this.pretFoaie = calcGreutate() * this.pretKG;
        return this.pretFoaie;
    }

    public double getLatime() {
        return latime;
    }

    public double getLungime() {
        return lungime;
    }

    public double getGrosime() {
        return grosime;
    }

    public double getPretFoaie() {
        return pretFoaie;
    }


    public void setPretFoaie(double pretFoaie) {
        this.pretFoaie = pretFoaie;
    }


    @Override
    public String toString() {
        return "Greutatea: " + calcGreutate() + "kg\n" +
                "Suprafata: " + calcSuprafata() + "mp\n" +
                "Pret: " + calcPret() + "lei";
    }
    @Override
    public String getDetalii() {
        return String.format("%.0f", getGrosime()) + "x" +
                String.format("%.0f", getLatime()) + "x" +
                String.format("%.0f", getLungime()) + " mm";
    }
}
