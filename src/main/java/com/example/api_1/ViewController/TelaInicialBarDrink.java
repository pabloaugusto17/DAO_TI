package com.example.api_1.ViewController;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.PessoaController;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.FuncionariosModel;
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

import java.util.Vector;

@Component
public class TelaInicialBarDrink implements ControlledScreen {

    //FXML

    @FXML
    private AnchorPane anchor_pane;

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
    private Label label_5;

    @FXML
    private Label label_avaliacao;

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
        controller.loadScreen("eventosBarDrink", "/Eventos/BarDrink.fxml", ScreenController.get_ac());
        controller.setScreen("eventosBarDrink");
    }

    @FXML
    void onPressedEventos(MouseEvent event) {

        controller.loadScreen("eventosBarDrink", "/Eventos/BarDrink.fxml", ScreenController.get_ac());
        controller.setScreen("eventosBarDrink");
    }

    @FXML
    public void initialize(){
        set_labels();

    }

    //Funções

    @Autowired
    BarController barController;

    @Autowired
    PessoaController pessoaController;

    private BarModel bar;

    private void set_labels(){

        bar = barController.getBarByDinamicId(ScreenController.cod_pessoa_atual);
        String nome_bar = bar.getNome();
        Integer id_bar = bar.getId_bar();
        int quant_eventos = barController.getQuantEventos(id_bar);
        double avaliacao_bar = bar.getAvaliacao();

        label_1.setText("Olá, " + nome_bar);
        label_nome.setText(nome_bar);
        label_eventos.setText(label_eventos.getText() + " " + quant_eventos);
        label_avaliacao.setText(label_avaliacao.getText() + " " + avaliacao_bar);

    }

    //Controller de tela

    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller  = screenPage;
    }

}
