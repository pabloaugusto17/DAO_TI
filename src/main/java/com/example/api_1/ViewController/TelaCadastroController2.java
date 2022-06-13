package com.example.api_1.ViewController;

import com.example.api_1.Controller.ContratanteEventoController;
import com.example.api_1.Model.ContratanteEventoModel;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

@Component
public class TelaCadastroController2 implements ControlledScreen {

    @Autowired
    private ContratanteEventoController contratanteEventoController;

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_bar_drink;

    @FXML
    private Button button_contratante_evento;

    @FXML
    private Button button_funcionario;

    @FXML
    private Label label_1;

    @FXML
    private Pane pane_1;

    ScreenController controller;
    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    @FXML
    void OnButtonBarDrinklPressed(MouseEvent event) {

        //abrir tela de registro de bar de drink
        controller.setScreen("telacadastro3");

    }

    @FXML
    void OnButtonContratanteEventolPressed(MouseEvent event) {

        //ir para tela login pós informar pessoa x como contratante de evento
        ContratanteEventoModel ce = new ContratanteEventoModel(ScreenController.cod_pessoa_atual);
        contratanteEventoController.add_ce(ce);

        ScreenController.cod_pessoa_atual = -1;

        controller.setScreen("telalogin");

    }

    @FXML
    void OnButtonFuncionarioPressed(MouseEvent event) {

        //ir para registro de funcionário
        controller.setScreen("telacadastro4");

    }
}
