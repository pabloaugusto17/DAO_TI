package com.example.api_1.ViewController.TelaInicial;

import com.example.api_1.Controller.PessoaController;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

@Component
public class TICEController implements ControlledScreen {

    //FXML

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_registrar;

    @FXML
    private Button button_vejaEventos;

    @FXML
    private ImageView image_ex;

    @FXML
    private Label label_1;

    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Label label_5;

    @FXML
    private Label label_eventos;

    @FXML
    private Label label_nome;

    @FXML
    private Line line_1;

    @FXML
    private Pane pane_1;

    @FXML
    private Pane pane_2;

    @FXML
    void onButtonVejaEventosPressed(MouseEvent event) {

    }

    @FXML
    void onPressedEventos(MouseEvent event) {

    }
    @FXML
    public void initialize(){
        set_labels();
    }

    //Controller da tela
    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções

    @Autowired
    private PessoaController pessoaController;

    private void set_labels(){

        PessoaModel pessoa_atual = pessoaController.getPessoaByIdDynamic(ScreenController.cod_pessoa_atual);
        String nome_pessoa = pessoa_atual.getNome();

        label_nome.setText(nome_pessoa);
        label_1.setText("Olá, " + nome_pessoa);

    }

}
