package com.example.api_1.ViewController.Pagamento;

import com.example.api_1.Controller.FuncionariosController;
import com.example.api_1.Controller.PagamentoController;
import com.example.api_1.Model.FuncionariosModel;
import com.example.api_1.Model.PagamentoModel;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

@Component
public class PPagamentoController implements ControlledScreen {

    //FXML

    @FXML
    private CheckBox boleto_box;

    @FXML
    private CheckBox cartao_box;

    @FXML
    private TextField destinatario_field;

    @FXML
    private Label label;

    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Line line_1;

    @FXML
    private CheckBox pix_box;

    @FXML
    private TextField valor_field;

    @FXML
    void OnEventosPressed(MouseEvent event) {

    }

    @FXML
    void OnHomePressed(MouseEvent event) {

    }

    @FXML
    void OnPropostaPressed(MouseEvent event) {

    }

    @FXML
    void OnRealizarPagametoPressed(MouseEvent event) {
        realiza_pagamento();
    }

    @FXML
    public void initialize(){

    }


    //Controller tela

    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções

    @Autowired
    private FuncionariosController funcionariosController;

    @Autowired
    private PagamentoController pagamentoController;

    private void realiza_pagamento(){


        String id_func = destinatario_field.getText();

        int id_func_cnv = Integer.parseInt(id_func);

        if(id_func_cnv > 0 && id_func_cnv < 999){

            FuncionariosModel funcionario = funcionariosController.getByDinamicId(id_func_cnv);

            if(funcionario != null){

                double valor = Double.parseDouble(valor_field.getText());

                String tipo = "";

                if(pix_box.isSelected()){
                    tipo = "PIX";
                }else if(boleto_box.isSelected()){
                    tipo = "BOLETO";
                }else if(cartao_box.isSelected()){
                    tipo = "CARTÃO";
                }

                PagamentoModel pagamentoModel = new PagamentoModel(ScreenController.cod_pessoa_atual,
                id_func_cnv, valor, tipo);

                pagamentoController.add_pagamento(pagamentoModel);

            }

        }

    }

}
