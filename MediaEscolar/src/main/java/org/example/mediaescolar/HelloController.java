package org.example.mediaescolar;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;

    @FXML
    private Label lblResultado;

    @FXML
    private void calcularMedia() {
        try {
            String nome = txtNome.getText();
            double n1 = Double.parseDouble(txtNota1.getText());
            double n2 = Double.parseDouble(txtNota2.getText());
            double n3 = Double.parseDouble(txtNota3.getText());

            double media = (n1 + n2 + n3) / 3.0;

            String situacao;
            if (media >= 7) {
                situacao = "Aprovado";
            } else if (media >= 4) {
                situacao = "Recuperação";
            } else {
                situacao = "Reprovado";
            }

            lblResultado.setText(
                    String.format("Aluno %s — média: %.1f — %s.", nome, media, situacao)
            );

        } catch (Exception e) {
            lblResultado.setText("Preencha os campos corretamente.");
        }
    }
}
