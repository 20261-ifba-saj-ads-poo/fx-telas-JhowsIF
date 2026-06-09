package br.edu.ifba.saj.ads.poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class IndexController {

    @FXML
    public void abrirLocalizacao(ActionEvent event) {
        try {
            App.setRoot("Localizacao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirCadastrarFuncionario(ActionEvent event) {
        try {
            App.setRoot("Funcionario");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirCadastrarEquipamento(ActionEvent event) {
        try {
            App.setRoot("Equipamento");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirMovimentacao(ActionEvent event) {
        try {
            // Você ainda vai criar o Movimentacao.fxml
            App.setRoot("Movimentacao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirRegistro(ActionEvent event) {
        try {
            // Você ainda vai criar o Movimentacao.fxml
            App.setRoot("Registros");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}