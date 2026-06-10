package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.model.Equipamento; // Importando Equipamento
import br.edu.ifba.saj.ads.poo.model.Localizacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class EquipamentoController {

    @FXML
    private ChoiceBox<Localizacao> slLocalizacao;

    @FXML
    private TextField txSerie;

    @FXML
    private TextField txNome;

    // Variável que vai guardar a localização escolhida pelo usuário
    private Localizacao localizacaoSelecionada;

    @FXML
    private void initialize() {

        // 1. Carrega as localizações que estão na sua classe Estoque central (App.estoque)
        slLocalizacao.getItems().addAll(App.estoque.getLocalizacoes());

        // Listener: quando uma localização for selecionada na lista, guarda na variável
        slLocalizacao.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                localizacaoSelecionada = newValue;
            }
        });

        // Converter: Define qual a informação da localização vai ser exibida na tela (o Nome)
        slLocalizacao.setConverter(new StringConverter<Localizacao>() {
            @Override
            public String toString(Localizacao localizacao) {
                return localizacao == null ? "" : localizacao.getNome();
            }

            @Override
            public Localizacao fromString(String string) {
                return null;
            }
        });

        // 2. Filtro para garantir que o usuário só digite números no campo Número de Série
        UnaryOperator<TextFormatter.Change> filtroInteiro = change -> {
            String novoTexto = change.getControlNewText();
            if (novoTexto.matches("\\d*")) { // Aceita apenas dígitos (0 a 9)
                return change;
            }
            return null;
        };
        txSerie.setTextFormatter(new TextFormatter<>(filtroInteiro));
    }

    @FXML
    void salvar(ActionEvent event) {
        String nomeDigitado = txNome.getText().trim();
        String serieDigitada = txSerie.getText().trim();

        // 3. Verifica se o usuário realmente selecionou uma localização
        if (localizacaoSelecionada == null) {
            new Alert(Alert.AlertType.WARNING,String.format("Por favor, selecione uma localização!")).showAndWait();
            return;
        }

        // Verifica se os campos não estão vazios
        if (!nomeDigitado.isEmpty() && !serieDigitada.isEmpty()) {

            // Converte a série (String) para número (int) para bater com o construtor
            int numeroDeSerie = Integer.parseInt(serieDigitada);

            // 4. Cria o equipamento passando as informações corretas na ordem do construtor
            Equipamento novoEquipamento = new Equipamento(nomeDigitado, numeroDeSerie, localizacaoSelecionada);

            // 5. Salva o equipamento no estoque central
            App.estoque.adicionarEquipamento(novoEquipamento);

            new Alert(Alert.AlertType.INFORMATION,String.format("Equipamento Registrado com sucesso!")).showAndWait();

            // 6. Limpa os campos após salvar com sucesso
            txNome.clear();
            txSerie.clear();
            slLocalizacao.getSelectionModel().clearSelection();

        } else {
            new Alert(Alert.AlertType.WARNING,String.format("Por favor, preencha o Nome e a Série do Equipamento!")).showAndWait();
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
}