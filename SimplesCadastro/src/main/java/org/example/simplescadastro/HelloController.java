package org.example.simplescadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private ComboBox<String> cbCurso;

    @FXML private TableView<HelloApplication.Aluno> tabela;
    @FXML private TableColumn<HelloApplication.Aluno, String> colNome;
    @FXML private TableColumn<HelloApplication.Aluno, Integer> colIdade;
    @FXML private TableColumn<HelloApplication.Aluno, String> colCurso;

    private ObservableList<HelloApplication.Aluno> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        cbCurso.getItems().addAll("Informática", "ADS", "Engenharia", "Administração");

        colNome.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getNome()));
        colIdade.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getIdade()).asObject());
        colCurso.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getCurso()));

        tabela.setItems(lista);
    }

    @FXML
    private void adicionar() {

        String nome = txtNome.getText();
        String idadeStr = txtIdade.getText();
        String curso = cbCurso.getValue();

        if (nome.isEmpty() || idadeStr.isEmpty() || curso == null) {
            alert("Preencha todos os campos!");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeStr);
        } catch (NumberFormatException e) {
            alert("Idade inválida!");
            return;
        }

        lista.add(new HelloApplication.Aluno(nome, idade, curso));

        txtNome.clear();
        txtIdade.clear();
        cbCurso.setValue(null);
    }

    @FXML
    private void excluir() {
        HelloApplication.Aluno selecionado = tabela.getSelectionModel().getSelectedItem();

        if (selecionado != null) {
            lista.remove(selecionado);
        } else {
            alert("Selecione um aluno na tabela.");
        }
    }

    private void alert(String msg) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
