package org.example.contaluz;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField txtNome;
    @FXML private TextField txtConsumo;
    @FXML private ComboBox<String> cbTipo;
    @FXML private Label lblResultado;

    @FXML
    public void initialize() {
        cbTipo.getItems().addAll("Residencial", "Comercial", "Industrial");
    }

    @FXML
    private void calcular() {
        String nome = txtNome.getText();
        String consumoStr = txtConsumo.getText();
        String tipo = cbTipo.getValue();

        if (nome.isEmpty() || consumoStr.isEmpty() || tipo == null) {
            lblResultado.setText("Preencha todos os campos.");
            return;
        }

        double consumo;

        try {
            consumo = Double.parseDouble(consumoStr);
        } catch (NumberFormatException e) {
            lblResultado.setText("Consumo inválido.");
            return;
        }

        double tarifa = 0;

        switch (tipo) {
            case "Residencial":
                tarifa = 0.60;
                break;
            case "Comercial":
                tarifa = 0.48;
                break;
            case "Industrial":
                tarifa = 0.75;
                break;
        }

        double valor = consumo * tarifa;

        lblResultado.setText(String.format(
                "Cliente: %s — Tipo: %s — Consumo: %.0f kWh — Valor: R$ %.2f",
                nome, tipo, consumo, valor
        ));
    }
}
