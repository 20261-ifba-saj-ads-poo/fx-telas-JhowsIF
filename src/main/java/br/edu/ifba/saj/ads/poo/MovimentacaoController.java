package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.model.Equipamento;
import br.edu.ifba.saj.ads.poo.model.Funcionario;
import br.edu.ifba.saj.ads.poo.model.Status;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

import java.io.IOException;

public class MovimentacaoController {

    // Alinhado com o Label "Equipamentro" no seu FXML
    @FXML
    private ChoiceBox<Equipamento> slFilme11;

    // Alinhado com o Label "Acao" no seu FXML
    @FXML
    private ChoiceBox<String> slFilme1;

    // Alinhado com o Label "Funcionario" no seu FXML
    @FXML
    private ChoiceBox<Funcionario> slFilme;

    @FXML
    public void initialize() {

        // 1. Carrega as listas do Estoque Central
        slFilme11.getItems().addAll(App.estoque.getEquipamentos());
        slFilme.getItems().addAll(App.estoque.getFuncionarios());

        // 2. Carrega as opções de ação
        slFilme1.getItems().addAll("Pegar Emprestado", "Devolver", "Consertar");

        // 3. Configura o conversor de Equipamento para mostrar o NOME na lista
        slFilme11.setConverter(new StringConverter<Equipamento>() {
            @Override
            public String toString(Equipamento equipamento) {
                return equipamento == null ? "" : equipamento.getNome() + " (Série: " + equipamento.getNumeroDeSerie() + ")";
            }

            @Override
            public Equipamento fromString(String string) {
                return null;
            }
        });

        // 4. Configura o conversor de Funcionario para mostrar o NOME na lista
        slFilme.setConverter(new StringConverter<Funcionario>() {
            @Override
            public String toString(Funcionario funcionario) {
                return funcionario == null ? "" : funcionario.getNome();
            }

            @Override
            public Funcionario fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    void salvar(ActionEvent event) {

        // Pega os itens selecionados de acordo com as IDs do FXML
        Equipamento equipamentoSelecionado = slFilme11.getValue();
        String acaoSelecionada = slFilme1.getValue();
        Funcionario funcionarioSelecionado = slFilme.getValue();

        // Verifica se tudo foi preenchido
        if (equipamentoSelecionado == null || funcionarioSelecionado == null || acaoSelecionada == null) {
            new Alert(Alert.AlertType.WARNING,String.format("Por favor, preencha todos os campos para realizar a movimentação!")).showAndWait();
            return;
        }

        // Direciona para o método correto dentro do Estoque
        switch (acaoSelecionada) {
            case "Pegar Emprestado":
                if(equipamentoSelecionado.getStatus() == Status.EM_USO){
                    new Alert(Alert.AlertType.WARNING,String.format("O equipamento %s ja esta em uso!",equipamentoSelecionado.getNome())).showAndWait();
                    break;
                } else if (equipamentoSelecionado.getStatus() == Status.MANUTENCAO) {
                    new Alert(Alert.AlertType.WARNING, String.format("O equipamento %s esta em manutencao!",equipamentoSelecionado.getNome())).showAndWait();
                    break;
                }
                App.estoque.emprestarEquipamento(equipamentoSelecionado, funcionarioSelecionado);
                new Alert(Alert.AlertType.INFORMATION,String.format("Equipamento emprestado com sucesso!",equipamentoSelecionado.getNome())).showAndWait();
                break;
            case "Devolver":
                if(equipamentoSelecionado.getStatus()== Status.DISPONIVEL){
                    new Alert(Alert.AlertType.WARNING,String.format("O equipamento %s nao esta em uso!",equipamentoSelecionado.getNome())).showAndWait();
                    break;
                } else if (equipamentoSelecionado.getStatus() == Status.MANUTENCAO) {
                    new Alert(Alert.AlertType.WARNING, String.format("O equipamento %s ja esta em manutencao!",equipamentoSelecionado.getNome())).showAndWait();
                    break;
                }
                App.estoque.devolverEquipamento(equipamentoSelecionado, funcionarioSelecionado);
                new Alert(Alert.AlertType.INFORMATION,String.format("Equipamento devolvido com sucesso!",equipamentoSelecionado.getNome())).showAndWait();
                break;
            case "Consertar":
                if(equipamentoSelecionado.getStatus()== Status.EM_USO){
                    new Alert(Alert.AlertType.WARNING,String.format("O equipamento %s esta em uso!",equipamentoSelecionado.getNome())).showAndWait();
                    break;
                } else if (equipamentoSelecionado.getStatus() == Status.MANUTENCAO) {
                    new Alert(Alert.AlertType.WARNING, String.format("O equipamento %s ja esta em manutencao!",equipamentoSelecionado.getNome())).showAndWait();
                    break;
                }
                App.estoque.consertarEquipamento(equipamentoSelecionado, funcionarioSelecionado);
                new Alert(Alert.AlertType.INFORMATION,String.format("Equipamento enviado para conserto!")).showAndWait();
                break;
        }

        // Limpa os campos após salvar
        slFilme11.getSelectionModel().clearSelection();
        slFilme1.getSelectionModel().clearSelection();
        slFilme.getSelectionModel().clearSelection();
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