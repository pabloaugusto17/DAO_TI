package com.example.api_1.ViewController;

import com.example.api_1.Controller.PessoaController;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Service.PessoaService;
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
public class TelaCadastroController implements ControlledScreen {

    @Autowired
    private PessoaController pessoaController;
    ScreenController controller;
    @FXML
    private Button button_prosseguir;

    @FXML
    private Button button_voltar;

    @FXML
    private TextField cpf_field;

    @FXML
    private TextField email_field;

    @FXML
    private TextField endereco_field;

    @FXML
    private Label label_email_existente;

    @FXML
    private Label label_1;

    @FXML
    private TextField nome_field;

    @FXML
    private Pane pane_1;

    @FXML
    private TextField senha_field;

    @FXML
    private TextField telefone_field;


    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    @FXML
    void onButtonVoltarPressed(MouseEvent event) {
        controller.setScreen("telalogin");
    }

    @FXML
    void OnButtonProsseguirPressed(MouseEvent event) {

        String nome = nome_field.getText();
        String cpf = cpf_field.getText();
        String senha = senha_field.getText();
        String telefone = telefone_field.getText();
        String endereco = endereco_field.getText();
        String email = email_field.getText();

        boolean email_existe = pessoaController.verifica_email(email);

        if(nome.length() > 2 && cpf.length() > 9 && senha.length() > 7 && endereco.length() > 10 &&
        telefone.length() > 4 && email.length() > 8){

            if(email_existe == false){

                PessoaModel pessoa_add = new PessoaModel(nome, cpf, senha, endereco, telefone, email);

                pessoaController.adicionar(pessoa_add);

                ScreenController.cod_pessoa_atual = pessoaController.retorna_id_by_email(email);

                controller.setScreen("telacadastro2");

            }else{

                label_email_existente.setText("Email já registrado");

            }

        }else{

            label_email_existente.setText("Preencha todos campos");
        }

    }

}
