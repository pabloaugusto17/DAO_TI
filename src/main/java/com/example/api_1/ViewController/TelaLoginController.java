/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package com.example.api_1.ViewController;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.PessoaController;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


@Component
public class TelaLoginController implements Initializable, ControlledScreen {

    ScreenController controller;

    @Autowired
    private PessoaController pessoaController;

    @FXML
    private Button button_entrar;

    @FXML
    private Label esqueci_senha;

    @FXML
    private Label label_1;

    @FXML
    private PasswordField password_field_1;

    @FXML
    private Label realizar_cadastro;

    @FXML
    private TextField text_field_1;

    @FXML
    private Label label_incorreto;


    @FXML
    void OnMousePressed_ButtonEntrar(MouseEvent event) throws IOException {


        String email_verificar = text_field_1.getText();
        String senha_verificar = password_field_1.getText();

        String verificacao = pessoaController.verifica_login(email_verificar, senha_verificar);


        if(verificacao.equals("SC")){



            ScreenController.cod_pessoa_atual = pessoaController.retorna_id_by_email(email_verificar);
            //Ir para tela inicial
            String derivacao = pessoaController.derivacao_pessoa(ScreenController.cod_pessoa_atual);

            if(derivacao.equals("BAR")){
                //ir tela bar
                controller.loadScreen("dashboardBarDrink", "/TelaInicial/BarDrink.fxml", ScreenController.get_ac());
                controller.setScreen("dashboardBarDrink");
            }

            if(derivacao.equals("CE")){

                controller.loadScreen("dashboardCE", "/TelaInicialContratanteEvento.fxml", ScreenController.get_ac());
                //ir tela contratante evento
                controller.setScreen("dashboardCE");

            }

            if(derivacao.equals("FUN")){
                //ir tela funcionario
                controller.loadScreen("dashboardFuncionario", "/TelaInicial/Funcionario.fxml", ScreenController.get_ac());
                controller.setScreen("dashboardFuncionario");
            }


        }else if(verificacao.equals("NA")){

            label_incorreto.setText("Email incorreto");

        }else if(verificacao.equals("SI")){

            label_incorreto.setText("Senha incorreta");

        }
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onMousePressed_realizarCadastro(MouseEvent event) {
        controller.setScreen("telacadastro");
    }
}
