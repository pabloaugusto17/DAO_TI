package com.example.api_1.ViewController.TelaInicial;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.FuncionariosController;
import com.example.api_1.Controller.PessoaController;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.image.ImageView;


@Component
public class TIFuncionarioController implements ControlledScreen{

    @FXML
    private ImageView image_ex;

    @FXML
    private Label label_4;

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_vejaEventos;

    @FXML
    private Label label_1;

    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_5;

    @FXML
    private Label label_nome;

    @FXML
    private Label label_preco_hora;

    @FXML
    private Line line_1;

    @FXML
    private Pane pane_1;

    @Autowired
    private FuncionariosController funcionariosController;
    @Autowired
    private PessoaController pessoaController;

    @Autowired
    private BarController barController;
    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;

    }

    @FXML
    void onButtonVejaEventosPressed(MouseEvent event) {

        controller.loadScreen("telavejaeventosFuncionario", "/Eventos/Funcionarios.fxml", ScreenController.get_ac());
        controller.setScreen("telavejaeventosFuncionario");

    }

    @FXML
    public void initialize() {

       set_text_labels();

    }

    private void set_text_labels(){

        label_1.setText("Olá, " + pessoaController.getPessoaByIdDynamic(ScreenController.cod_pessoa_atual).getNome());
        label_nome.setText(pessoaController.getPessoaByIdDynamic(ScreenController.cod_pessoa_atual).getNome());
        //label_eventos.setText(label_eventos.getText() + " " + funcionariosController.get_quantidade_eventos(ScreenController.cod_pessoa_atual));
        //label_avaliacao.setText(label_avaliacao.getText() + " " + funcionariosController.getByDinamicId(ScreenController.cod_pessoa_atual).getAvaliacao());
        label_preco_hora.setText(label_preco_hora.getText() + " " + funcionariosController.getByDinamicId(ScreenController.cod_pessoa_atual).getPreco_hora());

        String name = barController.getNameById(funcionariosController.getByDinamicId(ScreenController.cod_pessoa_atual).getCnpj_barEvento());

        if(name != null){
            label_4.setText(label_4.getText() + " " + name);
        }else{
            label_4.setText("N/A Bar");
        }

    }

    @FXML
    void onPressedEventos(MouseEvent event) {
        controller.loadScreen("telavejaeventosFuncionario", "/Eventos/Funcionarios.fxml", ScreenController.get_ac());
        controller.setScreen("telavejaeventosFuncionario");
    }

    @FXML
    void onPropostaPressed(MouseEvent event) {
        controller.loadScreen("propostaFUNC", "/Proposta/Funcionario.fxml", ScreenController.get_ac());
        controller.setScreen("propostaFUNC");
    }


}
