package com.example.softofertarefacturare;


import Materiale.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    // Fields Tabla
    @FXML
    private ComboBox<String> mabComBoxT;
    @FXML
    private TextField lungimeT;
    @FXML
    private TextField latimeT;
    @FXML
    private TextField grosimeT;
    @FXML
    private TextField pretKgT;
    @FXML
    private Label rezultateT;

    // Fields Teava Rectangulara
    @FXML
    private ComboBox<String> matComBoxTR;
    @FXML
    private TextField lungimeTxtTR;
    @FXML
    private TextField latura1Txt;
    @FXML
    private TextField latura2Txt;
    @FXML
    private TextField grosimeTxtTR;
    @FXML
    private TextField pretMLTR;
    @FXML
    private Label rezultateTR;

    // Fields Teava Patrată
    @FXML
    private ComboBox<String> matComBoxTP;
    @FXML
    private TextField laturaTxtTP;
    @FXML
    private TextField grosimeTxtTP;
    @FXML
    private TextField lungimeTxtTP;
    @FXML
    private TextField pretMLTP;
    @FXML
    private Label rezultateTP;

    // Fields Platbanda
    @FXML
    private ComboBox<String> matComBoxP;
    @FXML
    private TextField lungimeTxtP;
    @FXML
    private TextField laturaTxtP;
    @FXML
    private TextField grosimeTxtP;
    @FXML
    private TextField pretMLP;
    @FXML
    private Label rezultateP;

    // Fields Teava Rotunda
    @FXML
    private ComboBox<String> matComBoxFi;
    @FXML
    private TextField lungimeTxtFi;
    @FXML
    private TextField diametruTxtFi;
    @FXML
    private TextField grosimieTxtFi;
    @FXML
    private TextField pretMlFi;
    @FXML
    private Label rezultateFi;

    @FXML
    private Label necesarLabel;
    @FXML
    private Label totalPreturiLabel;

    private Tabla tabla;
    private TeavaRectangulara teavaRectangulara;
    private TeavaPatrata teavaPatrata;
    private Platbanda platbanda;
    private TeavaRotunda teavaRotunda;
    private Necesar materialeNecesare;



    @FXML
    public void initialize() {
        tabla = new Tabla();
        teavaRectangulara = new TeavaRectangulara();
        teavaPatrata = new TeavaPatrata();
        platbanda = new Platbanda();
        teavaRotunda = new TeavaRotunda();
        materialeNecesare = new Necesar();
    }

    private void actualizeazaNecesar() {
        necesarLabel.setText(materialeNecesare.afisare());
    }

    // Metode pentru Tabla
    @FXML
    public void CalculeazaT() {
        String material = mabComBoxT.getValue();
        if (material == null) {
            showAlert("Eroare", "Selectați un material!", Alert.AlertType.ERROR);
            return;
        }
        tabla = new Tabla();
        tabla.setMaterial(material);
        if (validateFields(lungimeT, latimeT, grosimeT, pretKgT)) {
            tabla.introducereDateFromUI(lungimeT, latimeT, grosimeT, pretKgT);
            rezultateT.setText(tabla.toString());
        } else {
            showAlert("Eroare", "Valori invalide introduse! Calculul nu a fost realizat.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void AdaugaT() {
        if (validateFields(lungimeT, latimeT, grosimeT, pretKgT)) {
            Tabla nouaTabla = new Tabla();
            nouaTabla.setMaterial(tabla.getMaterial());
            nouaTabla.introducereDateFromUI(lungimeT, latimeT, grosimeT, pretKgT);
            double pret = nouaTabla.calcPret();
            nouaTabla.setPretFoaie(pret);
            materialeNecesare.adaugaMaterial(nouaTabla);
            resetFields(lungimeT, latimeT, grosimeT, pretKgT);
            actualizeazaNecesar();
            actualizeazaTotalPreturi();
        } else {
            showAlert("Eroare", "Valori invalide introduse! Materialul nu a fost adăugat.", Alert.AlertType.ERROR);
        }
    }


    @FXML
    public void CalculeazaTR() {
        String material = matComBoxTR.getValue();
        if (material == null) {
            showAlert("Eroare", "Selectați un material!", Alert.AlertType.ERROR);
            return;
        }
        teavaRectangulara = new TeavaRectangulara();
        teavaRectangulara.setMaterial(material);
        if (validateFields(latura1Txt, latura2Txt, grosimeTxtTR, lungimeTxtTR, pretMLTR)) {
            teavaRectangulara.introducereDateFromUI(latura1Txt, latura2Txt, grosimeTxtTR, lungimeTxtTR, pretMLTR);
            rezultateTR.setText(teavaRectangulara.toString());
        } else {
            showAlert("Eroare", "Valori invalide introduse! Calculul nu a fost realizat.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void AdaugaTR() {
        if (validateFields(latura1Txt, latura2Txt, grosimeTxtTR, lungimeTxtTR, pretMLTR)) {
            TeavaRectangulara nouaTeavaRectangulara = new TeavaRectangulara();
            nouaTeavaRectangulara.setMaterial(teavaRectangulara.getMaterial());
            nouaTeavaRectangulara.introducereDateFromUI(latura1Txt, latura2Txt, grosimeTxtTR, lungimeTxtTR, pretMLTR);
            materialeNecesare.adaugaMaterial(nouaTeavaRectangulara);
            resetFields(latura1Txt, latura2Txt, grosimeTxtTR, lungimeTxtTR, pretMLTR);
            actualizeazaNecesar();
            actualizeazaTotalPreturi();
        } else {
            showAlert("Eroare", "Valori invalide introduse! Materialul nu a fost adăugat.", Alert.AlertType.ERROR);
        }
    }

    // Metode pentru Teava Patrată
    @FXML
    public void CalculeazaTP() {
        String material = matComBoxTP.getValue();
        if (material == null) {
            showAlert("Eroare", "Selectați un material!", Alert.AlertType.ERROR);
            return;
        }
        teavaPatrata = new TeavaPatrata();
        teavaPatrata.setMaterial(material);
        if (validateFields(laturaTxtTP, grosimeTxtTP, lungimeTxtTP, pretMLTP)) {
            teavaPatrata.introducereDateFromUI(laturaTxtTP, grosimeTxtTP, lungimeTxtTP, pretMLTP);
            rezultateTP.setText(teavaPatrata.toString());
        } else {
            showAlert("Eroare", "Valori invalide introduse! Calculul nu a fost realizat.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void AdaugaTP() {
        if (validateFields(laturaTxtTP, grosimeTxtTP, lungimeTxtTP, pretMLTP)) {
            TeavaPatrata nouaTeavaPatrata = new TeavaPatrata();
            nouaTeavaPatrata.setMaterial(teavaPatrata.getMaterial());
            nouaTeavaPatrata.introducereDateFromUI(laturaTxtTP, grosimeTxtTP, lungimeTxtTP, pretMLTP);
            materialeNecesare.adaugaMaterial(nouaTeavaPatrata);
            resetFields(laturaTxtTP, grosimeTxtTP, lungimeTxtTP, pretMLTP);
            actualizeazaNecesar();
            actualizeazaTotalPreturi();
        } else {
            showAlert("Eroare", "Valori invalide introduse! Materialul nu a fost adăugat.", Alert.AlertType.ERROR);
        }
    }

    // Metode pentru Platbanda
    @FXML
    public void CalculeazaPB() {
        String material = matComBoxP.getValue();
        if (material == null) {
            showAlert("Eroare", "Selectați un material!", Alert.AlertType.ERROR);
            return;
        }
        platbanda = new Platbanda();
        platbanda.setMaterial(material);
        if (validateFields(lungimeTxtP, laturaTxtP, grosimeTxtP, pretMLP)) {
            platbanda.introducereDateFromUI(lungimeTxtP, laturaTxtP, grosimeTxtP, pretMLP);
            rezultateP.setText(platbanda.toString());
        } else {
            showAlert("Eroare", "Valori invalide introduse! Calculul nu a fost realizat.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void AdaugaPB() {
        if (validateFields(lungimeTxtP, laturaTxtP, grosimeTxtP, pretMLP)) {
            Platbanda nouaPlatbanda = new Platbanda();
            nouaPlatbanda.setMaterial(platbanda.getMaterial());
            nouaPlatbanda.introducereDateFromUI(lungimeTxtP, laturaTxtP, grosimeTxtP, pretMLP);
            materialeNecesare.adaugaMaterial(nouaPlatbanda);
            resetFields(lungimeTxtP, laturaTxtP, grosimeTxtP, pretMLP);
            actualizeazaNecesar();
            actualizeazaTotalPreturi();
        } else {
            showAlert("Eroare", "Valori invalide introduse! Materialul nu a fost adăugat.", Alert.AlertType.ERROR);
        }
    }

    // Metode pentru Teava Rotunda
    @FXML
    public void CalculeazaFi() {
        String material = matComBoxFi.getValue();
        if (material == null) {
            showAlert("Eroare", "Selectați un material!", Alert.AlertType.ERROR);
            return;
        }
        teavaRotunda = new TeavaRotunda();
        teavaRotunda.setMaterial(material);
        if (validateFields(diametruTxtFi, grosimieTxtFi, lungimeTxtFi, pretMlFi)) {
            teavaRotunda.introducereDateFromUI(diametruTxtFi, grosimieTxtFi, lungimeTxtFi,pretMlFi);
            rezultateFi.setText(teavaRotunda.toString());
        } else {
            showAlert("Eroare", "Valori invalide introduse! Calculul nu a fost realizat.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void AdaugaFi() {
        if (validateFields(diametruTxtFi, grosimieTxtFi, lungimeTxtFi, pretMlFi)) {
            TeavaRotunda nouaTeavaRotunda = new TeavaRotunda();
            nouaTeavaRotunda.setMaterial(teavaRotunda.getMaterial());
            nouaTeavaRotunda.introducereDateFromUI(diametruTxtFi,  grosimieTxtFi,lungimeTxtFi, pretMlFi);
            materialeNecesare.adaugaMaterial(nouaTeavaRotunda);
            resetFields(diametruTxtFi, grosimieTxtFi, lungimeTxtFi, pretMlFi);
            actualizeazaNecesar();
            actualizeazaTotalPreturi();
        } else {
            showAlert("Eroare", "Valori invalide introduse! Materialul nu a fost adăugat.", Alert.AlertType.ERROR);
        }
    }


    private boolean validateFields(TextField... fields) {
        for (TextField field : fields) {
            try {
                double value = Double.parseDouble(field.getText());
                if (value <= 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }


    private void resetFields(TextField... fields) {
        for (TextField field : fields) {
            field.setText("");
        }
    }

    private void actualizeazaTotalPreturi() {
        double total = materialeNecesare.totalPreturi();
        totalPreturiLabel.setText("Total preturi: " + String.format("%.1f", total) + " lei");
    }

    private void showAlert(String titlu, String mesaj, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titlu);
        alert.setHeaderText(null);
        alert.setContentText(mesaj);
        alert.showAndWait();
    }
}
