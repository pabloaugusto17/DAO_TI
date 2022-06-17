package com.example.api_1.ViewController.Admin;

import com.example.api_1.Model.EventoModel;
import com.example.api_1.Repository.EventoRepository;
import com.example.api_1.Repository.PessoaRepository;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

@Component
public class AdminController implements ControlledScreen {


    //FXML

    @FXML
    private Button button_voltar;

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private ListView<String> list_view;

    @FXML
    public void initialize(){

        preencher_lista();


    }

    @FXML
    void onVoltarPressed(MouseEvent event) {
        controller.setScreen("telalogin");
    }

    @FXML
    void onListViewPressed(MouseEvent event) {

        String querry = list_view.getSelectionModel().getSelectedItem();

        mostra_querry(querry);

    }

    //Controller Tela

    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções

    private void preencher_lista(){

        ObservableList<String> items = FXCollections.observableArrayList();

        items.add("Cadastros na semana");
        items.add("Avaliações feitas por semana");
        items.add("Eventos por semana");
        items.add("Pagamentos por semana");

        list_view.setItems(items);



    }

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EventoRepository eventoRepository;

    private void mostra_querry(String querry_selecionada){

        if(querry_selecionada.equals("Cadastros na semana")){

            Integer quant_mes = pessoaRepository.quant_cadastros_mes();
            Integer quant_total = pessoaRepository.quant_cadastros_total();

            double porcentagem = ((double)quant_mes / (double)quant_total) * 100;

            System.out.println(porcentagem + "%");

        }

        if(querry_selecionada.equals("Eventos por semana")){

            Integer quant_mes = eventoRepository.quant_eventos_mes();
            Integer quant_total = eventoRepository.quant_eventos_total();

            double porcentagem = ( (double)quant_mes / (double)quant_total ) * 100;

            System.out.println(porcentagem + "%");

        }


    }

}
