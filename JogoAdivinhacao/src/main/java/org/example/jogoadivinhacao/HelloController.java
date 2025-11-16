package org.example.jogoadivinhacao;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {
    @FXML private TextField txtNumero;
    @FXML private Label lblResultado;

    private int numeroSorteado;
    private Random random = new Random();

    @FXML
    public void initialize() {
        gerarNovoNumero();
    }

    private void gerarNovoNumero() {
        numeroSorteado = random.nextInt(10) + 1; // 1 a 10
        lblResultado.setText(""); // limpa a tela
    }

    @FXML
    private void verificar() {
        String entrada = txtNumero.getText();

        // validação
        try {
            int numeroDigitado = Integer.parseInt(entrada);

            if (numeroDigitado < 1 || numeroDigitado > 10) {
                lblResultado.setText("Digite um número válido.");
                return;
            }

            // verifica acerto
            if (numeroDigitado == numeroSorteado) {
                lblResultado.setText("Acertou!");
            } else {
                lblResultado.setText("Errou! O número era " + numeroSorteado);
            }

        } catch (NumberFormatException e) {
            lblResultado.setText("Digite um número válido.");
        }
    }

    @FXML
    private void tentarNovamente() {
        gerarNovoNumero();
        txtNumero.clear();
    }
}
