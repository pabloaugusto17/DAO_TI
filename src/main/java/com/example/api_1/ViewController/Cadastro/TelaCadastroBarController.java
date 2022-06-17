package com.example.api_1.ViewController.Cadastro;

import com.example.api_1.Controller.FuncionariosController;
import com.example.api_1.Model.FuncionariosModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelaCadastroBarController implements ControlledScreen {

    @FXML
    private Button button_prosseguir;



    @FXML
    private Label label_1;

    @FXML
    private Label label_email_existente;

    @FXML
    private TextField nome_field;

    @FXML
    private Pane pane_1;

    @FXML
    private TextField senha_field;

    @FXML
    private TextField telefone_field;

    @Autowired
    private FuncionariosController funcionariosController;

    @FXML
    void OnButtonProsseguirPressed(MouseEvent event) {

        FuncionariosModel funcionariosModel = new FuncionariosModel(nome_field.getText(), senha_field.getText(), ScreenController.cod_pessoa_atual);

        funcionariosController.adicionar(funcionariosModel);

        controller.setScreen("telalogin");


    }

    ScreenController controller;
    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }
}
