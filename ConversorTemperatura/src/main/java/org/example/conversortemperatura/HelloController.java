package org.example.conversortemperatura;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtValor;

    @FXML
    private Label lblResultado;

    private double getValor() {
        return Double.parseDouble(txtValor.getText());
    }

    @FXML
    private void converterF() {
        double c = getValor();
        double f = (c * 9/5) + 32;
        lblResultado.setText(String.format("Resultado: %.1f°F", f));
    }

    @FXML
    private void converterC() {
        double f = getValor();
        double c = (f - 32) * 5/9;
        lblResultado.setText(String.format("Resultado: %.1f°C", c));
    }
}
