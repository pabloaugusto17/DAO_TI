package com.example.api_1.ViewController;

import com.example.api_1.Controller.PessoaController;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


import java.net.URL;
import java.util.ResourceBundle;

@Component
public class TelaInicialFuncionarioController implements ControlledScreen{

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_vejaEventos;

    @FXML
    private Label label_1;

    @FXML
    private Line line_1;

    @FXML
    private Pane pane_1;

    @Autowired
    private PessoaController pessoaController;
    ScreenController controller;


    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;

    }

    @FXML
    void onButtonVejaEventosPressed(MouseEvent event) {



    }

    @FXML
    public void initialize() {

       label_1.setText("Olá, " + pessoaController.getPessoaByIdDynamic(ScreenController.cod_pessoa_atual).getNome());


    }


}
