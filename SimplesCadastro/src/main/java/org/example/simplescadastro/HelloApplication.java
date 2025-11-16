package org.example.simplescadastro;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static class Aluno {
        private final StringProperty nome = new SimpleStringProperty(this, "nome", "");
        private final IntegerProperty idade = new SimpleIntegerProperty(this, "idade", 0);
        private final StringProperty curso = new SimpleStringProperty(this, "curso", "");

        public Aluno() {}

        public Aluno(String nome, int idade, String curso) {
            this.nome.set(nome);
            this.idade.set(idade);
            this.curso.set(curso);
        }

        // propriedades
        public StringProperty nomeProperty() { return nome; }
        public IntegerProperty idadeProperty() { return idade; }
        public StringProperty cursoProperty() { return curso; }

        // getters convencionais (usados por PropertyValueFactory também)
        public String getNome() { return nome.get(); }
        public int getIdade() { return idade.get(); }
        public String getCurso() { return curso.get(); }

        // setters
        public void setNome(String nome) { this.nome.set(nome); }
        public void setIdade(int idade) { this.idade.set(idade); }
        public void setCurso(String curso) { this.curso.set(curso); }
    }
}
