package com.example.api_1.ViewController.Proposta;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.EventoController;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.Model.PropostaModel;
import com.example.api_1.Service.PropostaService;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import java.util.List;

@Component
public class RegistraPropostaController implements ControlledScreen {

    //FXML

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_registrar_proposta;

    @FXML
    private TextField descricao_field;

    @FXML
    private ListView<String> list_view;

    @FXML
    private ListView<String> list_view_1;

    @FXML
    private TextField nome_evento_field;

    @FXML
    private TextField nome_field;

    @FXML
    private Pane pane_1;

    @FXML
    private Label label_obs;


    @FXML
    private Button button_sair;

    @FXML
    void onSairPressed(MouseEvent event) {
        controller.setScreen("dashboardCE");
    }
    @FXML
    void onRegistrarPressed(MouseEvent event) {
        verifica_proposta(nome_field.getText(), descricao_field.getText(), nome_evento_field.getText());
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
    private BarController barController;

    @Autowired
    private PropostaService propostaService;

    @Autowired
    private EventoController eventoController;

    private void popular_lista(){

        List<BarModel> bares = barController.listar_ce();

        List<EventoModel> eventos = eventoController.listar_eventos();

        ObservableList<String> items = FXCollections.observableArrayList();

        ObservableList<String> items_1 = FXCollections.observableArrayList();

        for(int i = 0; i < bares.size(); i++){

            items.add(bares.get(i).getNome());

        }

        for(int i = 0; i < eventos.size(); i++){

            if(eventos.get(i).getId_contratante_evento().equals(ScreenController.cod_pessoa_atual)
            && eventos.get(i).getId_bar_evento() == null){
                items_1.add(eventos.get(i).getNome());
            }

        }

        if(items.isEmpty()){
            items.add("Sem bares registrados");
        }

        if(items_1.isEmpty()){
            items.add("Sem eventos registrados");
        }

        list_view.setItems(items);

        list_view_1.setItems(items_1);


    }

    private void verifica_proposta(String nome_bar, String descricao, String nome_evento){

        if(nome_bar != null && descricao != null && nome_evento != null){

            if(barController.getIdBarByName(nome_bar) != null){

                if(eventoController.getEventoByName(nome_evento) != null){

                    PropostaModel proposta = new PropostaModel(
                            ScreenController.cod_pessoa_atual,
                            barController.getIdBarByName(nome_bar),
                            descricao,
                            eventoController.getEventoByName(nome_evento).getId_evento(),
                            "CE"
                    );

                    propostaService.enviar_proposta(proposta);

                    controller.setScreen("dashboardCE");

                }else{

                    label_obs.setText("EVENTO NÃO EXISTE");

                }



            }else{

                label_obs.setText("NOME DO BAR NÃO EXISTE");


            }




        }


    }
}
