//package br.edu.ifba.saj.ads.poo;
//
//import br.edu.ifba.saj.ads.poo.model.Localizacao;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import java.io.IOException;
//
//public class FuncionarioController {
//
//    // 1. Ajustamos os nomes das variáveis para fazer sentido com o projeto
//    @FXML private TextField txNome;
//    @FXML private TableView<Localizacao> tbLocalizacoes;
//    @FXML private TableColumn<Localizacao, Integer> clmId; // Na sua tela estava Duração, vamos usar o ID
//    @FXML private TableColumn<Localizacao, String> clmNome;
//
//    // O JavaFX usa essa "ObservableList" para atualizar a tabela na tela automaticamente
//    private ObservableList<Localizacao> listaObservable;
//
//    // 2. O método initialize roda sozinho assim que a tela abre
//    @FXML
//    public void initialize() {
//        // Ensina a coluna de ID a procurar o método getId() na classe Localizacao
//        clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        // Ensina a coluna de Nome a procurar o método getNome() na classe Localizacao
//        clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//
//        atualizarTabela();
//    }
//
//    // 3. Ação do botão Salvar
//    @FXML
//    void salvar(ActionEvent event) {
//        String textoDigitado = txNome.getText();
//
//        // Só salva se o campo não estiver vazio
//        if (!textoDigitado.trim().isEmpty()) {
//            Localizacao novaLoc = new Localizacao(textoDigitado);
//
//            // Salva no estoque central que está na classe App
//            App.estoque.adicionarLocalizacao(novaLoc);
//
//            txNome.clear(); // Limpa o campo para digitar o próximo
//            atualizarTabela(); // Atualiza a visão da tabela
//        }
//    }
//
//    // 4. Ação do botão Voltar (<==)
//    @FXML
//    void voltar(ActionEvent event) {
//        try {
//            // Usa o método do professor para voltar para a tela inicial
//            App.setRoot("Index");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Método auxiliar para puxar os dados do Estoque e jogar na tela
//    private void atualizarTabela() {
//        // Pega a lista lá do App.estoque
//        listaObservable = FXCollections.observableArrayList(App.estoque.getLocalizacoes());
//        tbLocalizacoes.setItems(listaObservable);
//    }
//}