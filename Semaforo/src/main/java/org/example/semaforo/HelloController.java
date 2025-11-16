package org.example.semaforo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.*;

public class HelloController {
    @FXML private Circle vermelho;
    @FXML private Circle amarelo;
    @FXML private Circle verde;

    private Timeline timeline;
    private int estado = 0;

    @FXML
    public void initialize() {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> mudarCor())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);

        resetar();
    }

    private void resetar() {
        vermelho.setStyle("-fx-fill: gray;");
        amarelo.setStyle("-fx-fill: gray;");
        verde.setStyle("-fx-fill: gray;");
    }

    private void mudarCor() {
        resetar();

        switch (estado) {
            case 0:
                vermelho.setStyle("-fx-fill: red;");
                break;

            case 1:
                amarelo.setStyle("-fx-fill: yellow;");
                break;

            case 2:
                verde.setStyle("-fx-fill: green;");
                break;
        }

        estado = (estado + 1) % 3;
    }

    @FXML
    private void iniciar() {
        timeline.play();
    }

    @FXML
    private void parar() {
        timeline.stop();
        resetar();
    }
}
