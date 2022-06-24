package com.example.api_1.ViewController.Proposta;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.EventoController;
import com.example.api_1.Controller.FuncionariosController;
import com.example.api_1.Controller.PessoaController;
import com.example.api_1.Model.*;
import com.example.api_1.Service.PropostaService;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistraProposta2Controller implements ControlledScreen {

    //FXML

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_registrar_proposta;

    @FXML
    private Button button_sair;

    @FXML
    private TextField descricao_field;

    @FXML
    private Label label_obs;

    @FXML
    private ListView<String> list_view;

    @FXML
    private TextField nome_evento_field;

    @FXML
    private Pane pane_1;

    @FXML
    void onSairPressed(MouseEvent event) {
        controller.setScreen("dashboardBarDrink");
    }
    @FXML
    void onRegistrarPressed(MouseEvent event) {
        verifica_proposta(descricao_field.getText(), nome_evento_field.getText());
    }

    @FXML
    public void initialize(){
        popular_lista();
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
    private BarController barController;

    @Autowired
    private PropostaService propostaService;

    @Autowired
    private PessoaController pessoaController;

    private void popular_lista(){

        List<FuncionariosModel> funcs = funcionariosController.listar();

        ObservableList<String> items = FXCollections.observableArrayList();

        for(int i = 0; i < funcs.size(); i++){

            PessoaModel pessoa = pessoaController.getPessoaByIdDynamic(funcs.get(i).getId_funcionario());
            items.add(pessoa.getNome());
        }

        if(items.isEmpty()){
            items.add("Sem funcionários registrados");
        }

        list_view.setItems(items);


    }
    private void verifica_proposta(String descricao, String nome_func){

        if(descricao != null && nome_func != null){

            if(pessoaController.getPessoaByName(nome_func) != null){

                Integer id_func = pessoaController.getPessoaByName(nome_func).getId_pessoa();

                PropostaModel proposta = new PropostaModel(
                        id_func,
                        barController.getBarByDinamicId(ScreenController.cod_pessoa_atual).getId_bar(),
                        descricao,
                        null,
                        "FUNC"
                );

                propostaService.enviar_proposta(proposta);

                controller.setScreen("dashboardBarDrink");

            }else{

                label_obs.setText("NOME DO FUNCIONARIO NÃO EXISTE");


            }




        }


    }

}
