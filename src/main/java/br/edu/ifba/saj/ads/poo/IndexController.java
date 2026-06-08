package br.edu.ifba.saj.ads.poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class IndexController {

    
    @FXML
    private BorderPane pane;

    @FXML
    public void abrirCadastarFilme(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Filme.fxml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void abrirCadastarSessao(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Sessao.fxml")));            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void abrirVenderIngresso(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Ingresso.fxml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
