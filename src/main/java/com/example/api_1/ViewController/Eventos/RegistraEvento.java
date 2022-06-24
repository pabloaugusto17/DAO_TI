package com.example.api_1.ViewController.Eventos;

import com.example.api_1.Controller.EventoController;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

@Component
public class RegistraEvento implements ControlledScreen {

    //FXML
    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_registrar_evento;

    @FXML
    private TextField data_evento_field;

    @FXML
    private TextField duracao_field;

    @FXML
    private TextField endereco_field;

    @FXML
    private TextField hora_inicio_field;

    @FXML
    private Label label_obs;

    @FXML
    private TextField nome_field;

    @FXML
    private Pane pane_1;

    @FXML
    private TextField quant_participantes_field;

    @FXML
    public void initialize(){

    }

    @FXML
    void onRegistrarPressed(MouseEvent event) {

        String nome = nome_field.getText();
        String endereco = endereco_field.getText();
        String hora_inicio = hora_inicio_field.getText();
        String quantidade_participantes = quant_participantes_field.getText();
        String duracao = duracao_field.getText();
        String data_evento = data_evento_field.getText();

        if(nome != null && endereco != null && hora_inicio != null && quantidade_participantes != null
        && duracao != null && data_evento != null){

            Integer id_ce = ScreenController.cod_pessoa_atual;

            if(Integer.parseInt(hora_inicio) > 0 && Integer.parseInt(hora_inicio) < 24){

                if(Integer.parseInt(quantidade_participantes) > 0){

                    if(Double.parseDouble(duracao) > 0.0){

                        EventoModel evento_registrar = new EventoModel
                                (id_ce, nome, endereco, hora_inicio,
                                Integer.parseInt(quantidade_participantes), Double.parseDouble(duracao),
                                        data_evento);

                        eventoController.add_ce(evento_registrar);

                        controller.setScreen("dashboardCE");

                    }


                }


            }

        }

    }

    //Controller tela
    private ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções

    @Autowired
    EventoController eventoController;

}
