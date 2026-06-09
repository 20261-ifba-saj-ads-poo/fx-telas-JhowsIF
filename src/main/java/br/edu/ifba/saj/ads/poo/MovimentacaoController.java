package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.model.Equipamento;
import br.edu.ifba.saj.ads.poo.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
            System.out.println("Por favor, preencha todos os campos para realizar a movimentação!");
            return;
        }

        // Direciona para o método correto dentro do Estoque
        switch (acaoSelecionada) {
            case "Emprestar":
                App.estoque.emprestarEquipamento(equipamentoSelecionado, funcionarioSelecionado);
                System.out.println("Equipamento emprestado com sucesso!");
                break;
            case "Devolver":
                App.estoque.devolverEquipamento(equipamentoSelecionado, funcionarioSelecionado);
                System.out.println("Equipamento devolvido com sucesso!");
                break;
            case "Consertar":
                App.estoque.consertarEquipamento(equipamentoSelecionado, funcionarioSelecionado);
                System.out.println("Equipamento enviado para conserto!");
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