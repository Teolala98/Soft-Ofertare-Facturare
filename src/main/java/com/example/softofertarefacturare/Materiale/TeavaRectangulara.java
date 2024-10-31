package com.example.softofertarefacturare.Materiale;


import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TeavaRectangulara extends Material implements CalculMaterial {
    private double latura1;
    private double latura2;
    private double grosime;
    private double lungime;
    public double pretML;

    public TeavaRectangulara() {}

    @Override
    public double calcPret() {
        return lungime/1000 * this.pretML;
    }

    public TeavaRectangulara(double latura1, double latura2, double grosime, double lungime, double pretML) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.grosime = grosime;
        this.lungime = lungime;
        this.pretML = pretML;
    }

    public void introducereDateFromUI(TextField latura1Field, TextField latura2Field, TextField grosimeField, TextField lungimeField, TextField pretMLField) {
        try {
            this.latura1 = Double.parseDouble(latura1Field.getText());
            this.latura2 = Double.parseDouble(latura2Field.getText());
            this.grosime = Double.parseDouble(grosimeField.getText());
            this.lungime = Double.parseDouble(lungimeField.getText())*1000;
            this.pretML = Double.parseDouble(pretMLField.getText());

            if (latura1 <= 0 || latura2 <= 0 || grosime <= 0 || lungime <= 0 || pretML <= 0) {
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
        return (latura1 + latura2) * 2 * lungime / 1000000;
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
        return String.format("%.0f", getLatura1()) + "x" +
                String.format("%.0f", getLatura2()) + "x" +
                String.format("%.0f", getGrosime()) + " mm";
    }

    @Override
    public String toString(){
        return "Greutatea: " + calcGreutate() + "kg\n" +
                "Suprafata: " + calcSuprafata() + "mp\n" +
                "Pret: " + calcPret() + "lei";
    }


    public double getLatura1() { return latura1; }
    public void setLatura1(double latura1) { this.latura1 = latura1; }

    public double getLatura2() { return latura2; }
    public void setLatura2(double latura2) { this.latura2 = latura2; }

    public double getGrosime() { return grosime; }
    public void setGrosime(double grosime) { this.grosime = grosime; }

    public double getLungime() { return lungime; }
    public void setLungime(double lungime) { this.lungime = lungime; }

    public double getPretML() { return pretML; }
    public void setPretML(double pretML) { this.pretML = pretML; }
}
