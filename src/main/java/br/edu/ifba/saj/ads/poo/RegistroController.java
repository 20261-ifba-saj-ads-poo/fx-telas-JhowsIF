package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.model.Funcionario;
import br.edu.ifba.saj.ads.poo.model.Registro;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDateTime;

public class RegistroController {

    private ObservableList<Registro> listaObservable;


    @FXML
    private TableColumn<Registro, String> clmAcao;

    @FXML
    private TableColumn<Registro, LocalDateTime> clmDataHora;

    @FXML
    private TableColumn<Registro, String> clmEquipamento;

    @FXML
    private TableColumn<Registro, String> clmFuncionaro;

    @FXML
    private TableView<Registro> tbRegistros;

    @FXML
    public void initialize() {
        clmAcao.setCellValueFactory(new PropertyValueFactory<>("acao"));
        clmDataHora.setCellValueFactory(new PropertyValueFactory<>("dataDaMudanca"));
        clmEquipamento.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEquipamento().getNome()));
        clmFuncionaro.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFuncionario().getNome()));

        atualizarTabela();
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
        listaObservable = FXCollections.observableArrayList(App.estoque.getRegistros());
        tbRegistros.setItems(listaObservable);
    }

}
