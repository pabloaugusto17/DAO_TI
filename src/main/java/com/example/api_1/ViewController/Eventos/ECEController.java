package com.example.api_1.ViewController.Eventos;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import org.springframework.stereotype.Component;

@Component
public class ECEController implements ControlledScreen {

    //FXML

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_registrar_evento;

    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Line line_1;

    @FXML
    private ListView<?> list_view;

    @FXML
    void onListViewPressed(MouseEvent event) {

    }

    @FXML
    void onPressedEventos(MouseEvent event) {

    }

    @FXML
    void onPressedHome(MouseEvent event) {

    }

    @FXML
    public void initialize(){

    }


    //Controller telas

    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções


}
