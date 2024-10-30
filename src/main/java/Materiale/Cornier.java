//package Materiale;
//
//import com.example.proiect2.CalculMaterial;
//import com.example.proiect2.DensitateMateriale;
//import com.example.Material;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TextField;
//
//public class Cornier extends Material implements CalculMaterial {
//    private double latura;
//    private double grosime;
//    private double lungime;
//    public double pretML;
//
//    public Cornier() {}
//
//    @Override
//    public double calcPret() {
//        return lungime/1000 * this.pretML;
//    }
//
//    public Cornier(double latura, double grosime, double lungime, double pretML) {
//        this.latura = latura;
//        this.grosime = grosime;
//        this.lungime = lungime;
//        this.pretML = pretML;
//    }
//
//    public void introducereDateFromUI(TextField laturaField, TextField grosimeField, TextField lungimeField, TextField pretMLField) {
//        try {
//            this.latura = Double.parseDouble(laturaField.getText());
//            this.grosime = Double.parseDouble(grosimeField.getText());
//            this.lungime = Double.parseDouble(lungimeField.getText());
//            this.pretML = Double.parseDouble(pretMLField.getText());
//
//            if (latura <= 0 || grosime <= 0 || lungime <= 0 || pretML <= 0) {
//                throw new IllegalArgumentException("Valorile introduse trebuie sa fie mai mari decat 0");
//            }
//        } catch (NumberFormatException e) {
//            showAlert("Introduceti doar numere valide.");
//        } catch (IllegalArgumentException e) {
//            showAlert(e.getMessage());
//        }
//    }
//
//    @Override
//    public double calcSuprafata() {
//        return 2 * latura * grosime * lungime / 1000000;
//    }
//
//    @Override
//    public double calcGreutate() {
//        double densitate = "Otel".equalsIgnoreCase(this.getMaterial()) ? DensitateMateriale.densitateOtel :
//                "Inox".equalsIgnoreCase(this.getMaterial()) ? DensitateMateriale.densitateInox : 0;
//        return densitate * calcSuprafata();
//    }
//
//
//    private void showAlert(String message) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Eroare");
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
//    @Override
//    public String getDetalii() {
//        return String.format("%.0f", getLatura()) + "x" +
//                String.format("%.0f", getLatura()) + "x" +
//                String.format("%.0f", getGrosime()) + " mm";
//    }
//
//    public double getLatura() { return latura; }
//    public void setLatura(double latura) { this.latura = latura; }
//
//    public double getGrosime() { return grosime; }
//    public void setGrosime(double grosime) { this.grosime = grosime; }
//
//    public double getLungime() { return lungime; }
//    public void setLungime(double lungime) { this.lungime = lungime; }
//
//    public double getPretML() { return pretML; }
//    public void setPretML(double pretML) { this.pretML = pretML; }
//}
