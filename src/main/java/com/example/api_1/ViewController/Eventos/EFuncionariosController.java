package com.example.api_1.ViewController.Eventos;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.ContratanteEventoController;
import com.example.api_1.Controller.EventoController;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.scene.control.Button;
import java.util.List;

@Component
public class EFuncionariosController implements ControlledScreen {

    //FXML
    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Line line_1;

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private ListView<String> list_view;

    @FXML
    void onPressedEventos(MouseEvent event) {

    }

    @FXML
    void onPressedHome(MouseEvent event) {

        controller.setScreen("dashboardFuncionario");

    }

    @FXML
    public void initialize(){

        //Popular lista
        popular_lista();

    }

    @FXML
    void onListViewPressed(MouseEvent event) {

        //mostral modal com eventos
        gera_modal();


    }

    //Controller tela

    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções
    @Autowired
    private EventosGeral eventosGeral;

    private void popular_lista(){

        ObservableList<String> items = eventosGeral.lista_populada("Funcionario");

        list_view.setItems(items);

        final int row_height = 24;

        list_view.setPrefHeight(items.size()  * row_height + 2);

    }

    private void gera_modal(){

        String titulo = list_view.getSelectionModel().getSelectedItem();

        eventosGeral.gera_modal(titulo);

    }


}
