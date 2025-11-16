package org.example.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

        @FXML
        private TextField txtNum1;

        @FXML
        private TextField txtNum2;

        @FXML
        private Label lblResultado;

        private double getNum1() {
            return Double.parseDouble(txtNum1.getText());
        }

        private double getNum2() {
            return Double.parseDouble(txtNum2.getText());
        }




        @FXML
        private void soma() {
            double r = getNum1() + getNum2();
            lblResultado.setText("Resultado: " + r);
        }

        @FXML
        private void subtrair() {
            double r = getNum1() - getNum2();
            lblResultado.setText("Resultado: " + r);
        }

        @FXML
        private void multiplicar() {
            double r = getNum1() * getNum2();
            lblResultado.setText("Resultado: " + r);
        }

        @FXML
        private void dividir() {
            double n2 = getNum2();
            if (n2 == 0) {
                lblResultado.setText("Erro: divisão por zero");
            } else {
                double r = getNum1() / n2;
                lblResultado.setText("Resultado: " + r);
            }
        }
    }
