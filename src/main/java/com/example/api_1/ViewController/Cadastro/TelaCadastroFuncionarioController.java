package com.example.api_1.ViewController.Cadastro;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Service.BarService;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelaCadastroFuncionarioController implements ControlledScreen {

    @FXML
    private Button button_prosseguir;

    @FXML
    private TextField cnpj_field;

    @FXML
    private TextField email_field;

    @FXML
    private TextField descricao_field;

    @FXML
    private Label label_1;

    @FXML
    private Label label_email_existente;

    @FXML
    private TextField nome_field;

    @FXML
    private Pane pane_1;

    @FXML
    private TextField telefone_field;

    @FXML
    private TextField cep_field;

    ScreenController controller;

    @Autowired
    private BarService barService;

    @Autowired
    private BarController barController;

    @FXML
    void OnButtonProsseguirPressed(MouseEvent event) {

        if(nome_field.getText().length() > 3 && cnpj_field.getText().length() > 8
        && email_field.getText().length() > 5 && telefone_field.getText().length() > 5
        && descricao_field.getText().length() > 10 && cep_field.getText().length() > 5){

            BarModel bar_enviar = new BarModel(nome_field.getText(), telefone_field.getText(),
                    descricao_field.getText(), cep_field.getText(), cnpj_field.getText(),
                    ScreenController.cod_pessoa_atual);

            barController.add_bar(bar_enviar);

            controller.setScreen("telalogin");


        }


    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }
}
