package com.example.softofertarefacturare;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TableViewItem {
    private Label denumireLabel;
    private Label unitateDeMasuraLabel;
    private TextField cantitateTextField;
    private Label pretLabel;

    public TableViewItem(String denumire, String unitateDeMasura, Double cantitate, Double pret) {
        this.denumireLabel = new Label(denumire);
        this.unitateDeMasuraLabel = new Label(unitateDeMasura);
        this.cantitateTextField = new TextField(cantitate.toString());
        this.pretLabel = new Label(String.format("%.2f", pret));
    }

    public Label getDenumireLabel() { return denumireLabel; }
    public void setDenumireLabel(Label denumireLabel) { this.denumireLabel = denumireLabel; }
    public Label getUnitateDeMasuraLabel() { return unitateDeMasuraLabel; }
    public void setUnitateDeMasuraLabel(Label unitateDeMasuraLabel) { this.unitateDeMasuraLabel = unitateDeMasuraLabel; }
    public TextField getCantitateTextField() { return cantitateTextField; }
    public void setCantitateTextField(TextField cantitateTextField) { this.cantitateTextField = cantitateTextField; }
    public Label getPretLabel() { return pretLabel; }
    public void setPretLabel(Label pretLabel) { this.pretLabel = pretLabel; }
    public double getCantitate() {
        try {
            return Double.parseDouble(cantitateTextField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
