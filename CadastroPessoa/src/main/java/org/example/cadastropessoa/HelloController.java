package org.example.cadastropessoa;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    private ComboBox<String> cbSexo;

    @FXML
    private CheckBox chkEsporte;

    @FXML
    private Label lblResultado;

    @FXML
    private void analisar() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String sexo = cbSexo.getValue();

            String gostaEsportes = chkEsporte.isSelected() ? "gosta de esportes" : "não gosta de esportes";

            String maioridade = idade < 18 ? "Menor de idade." : "Maior de idade.";

            String resultado = String.format("%s, %d anos, do sexo %s, %s. %s",
                    nome, idade, sexo.toLowerCase(), gostaEsportes, maioridade);

            lblResultado.setText(resultado);

        } catch (Exception e) {
            lblResultado.setText("Preencha todos os campos corretamente.");
        }
    }
}
