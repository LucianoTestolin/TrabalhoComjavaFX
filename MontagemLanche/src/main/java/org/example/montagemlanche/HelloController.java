package org.example.montagemlanche;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField txtNome;

    @FXML
    private ComboBox<String> cbPao;

    @FXML
    private RadioButton rbBovina;

    @FXML
    private RadioButton rbFrango;

    @FXML
    private RadioButton rbSoja;

    @FXML
    private CheckBox chkQueijo;

    @FXML
    private CheckBox chkBacon;

    @FXML
    private CheckBox chkSalada;

    @FXML
    private CheckBox chkMolho;

    @FXML
    private Label lblResultado;

    @FXML
    private void gerarPedido() {
        try {
            String nome = txtNome.getText();
            String pao = cbPao.getValue();

            if (nome.isEmpty() || pao == null || (!rbBovina.isSelected() && !rbFrango.isSelected() && !rbSoja.isSelected())) {
                lblResultado.setText("Preencha o nome, o tipo de pão e escolha a carne.");
                return;
            }

            // Carne
            String carne = "";
            if (rbBovina.isSelected()) carne = "bovina";
            else if (rbFrango.isSelected()) carne = "frango";
            else carne = "soja";

            // Adicionais
            StringBuilder adicionais = new StringBuilder();

            if (chkQueijo.isSelected()) adicionais.append("queijo, ");
            if (chkBacon.isSelected()) adicionais.append("bacon, ");
            if (chkSalada.isSelected()) adicionais.append("salada, ");
            if (chkMolho.isSelected()) adicionais.append("molho, ");

            String textoAdicionais;

            if (adicionais.length() > 0) {
                textoAdicionais = "com " + adicionais.substring(0, adicionais.length() - 2);
            } else {
                textoAdicionais = "sem adicionais";
            }

            String resultado = String.format(
                    "Pedido de %s: pão %s com carne %s, %s.",
                    nome, pao.toLowerCase(), carne, textoAdicionais
            );

            lblResultado.setText(resultado);

        } catch (Exception e) {
            lblResultado.setText("Erro ao gerar pedido.");
        }
    }
}
