package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.model.Funcionario;
import br.edu.ifba.saj.ads.poo.model.Localizacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class FuncionarioController {

    private ObservableList<Funcionario> listaObservable;

    @FXML
    private TableColumn<Funcionario, String> clmDepartamento;

    @FXML
    private TableColumn<Funcionario, Integer> clmId;

    @FXML
    private TableColumn<Funcionario, String> clmNome;

    @FXML
    private TableView<Funcionario> tbFuncionarios;

    @FXML
    private TextField txDepartamento;

    @FXML
    private TextField txNome;

    @FXML
    public void initialize() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clmDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));

        atualizarTabela();
    }

    @FXML
    void salvar(ActionEvent event) {
        String textoDigitado1 = txNome.getText();
        String textoDigitado2 = txDepartamento.getText();

        if (!textoDigitado1.trim().isEmpty() || !textoDigitado2.trim().isEmpty()) {
            Funcionario novoFun = new Funcionario(textoDigitado1, textoDigitado2);
            App.estoque.adicionarFuncionario(novoFun);

            txNome.clear();
            txDepartamento.clear();
            atualizarTabela();
            new Alert(Alert.AlertType.INFORMATION,String.format("Funcionario Registrado com sucesso!")).showAndWait();
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        try {
            App.setRoot("Index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void atualizarTabela() {
        listaObservable = FXCollections.observableArrayList(App.estoque.getFuncionarios());
        tbFuncionarios.setItems(listaObservable);
    }
}
