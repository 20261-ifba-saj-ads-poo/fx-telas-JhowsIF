package br.edu.ifba.saj.ads.poo;

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

public class LocalizacaoController {

    @FXML private TextField txLocalizacao;
    @FXML private TableView<Localizacao> tbLocalizacoes;
    @FXML private TableColumn<Localizacao, Integer> clmId;
    @FXML private TableColumn<Localizacao, String> clmLocalizacao; // Alinhado com o FXML

    private ObservableList<Localizacao> listaObservable;

    @FXML
    public void initialize() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmLocalizacao.setCellValueFactory(new PropertyValueFactory<>("nome"));

        atualizarTabela();
    }

    @FXML
    void salvar(ActionEvent event) {
        String textoDigitado = txLocalizacao.getText();

        if (!textoDigitado.trim().isEmpty()) {
            Localizacao novaLoc = new Localizacao(textoDigitado);
            App.estoque.adicionarLocalizacao(novaLoc);
            txLocalizacao.clear();
            atualizarTabela();
            new Alert(Alert.AlertType.INFORMATION,String.format("Localizacao Registrada com sucesso!")).showAndWait();
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
        listaObservable = FXCollections.observableArrayList(App.estoque.getLocalizacoes());
        tbLocalizacoes.setItems(listaObservable);
    }
}