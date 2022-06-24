package com.example.api_1.ViewController.Proposta;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.EventoController;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.Model.PropostaModel;
import com.example.api_1.Service.FuncionarioService;
import com.example.api_1.Service.PropostaService;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class FUNCPropostaController implements ControlledScreen{

    //FXML
    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Line line_1;

    @FXML
    private ListView<String> list_view;

    @FXML
    void onListViewPressed(MouseEvent event) {
        gera_modal();
    }

    @FXML
    void onPressedEventos(MouseEvent event) {

        controller.loadScreen("telavejaeventosFuncionario", "/Eventos/Funcionarios.fxml", ScreenController.get_ac());
        controller.setScreen("telavejaeventosFuncionario");

    }

    @FXML
    void onPressedHome(MouseEvent event) {
        controller.setScreen("dashboardFuncionario");
    }


    @FXML
    public void initialize(){

        popular_lista();

    }

    //Controller tela

    private ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções

    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    PropostaService propostaService;

    @Autowired
    BarController barController;

    @Autowired
    EventoController eventoController;

    private void popular_lista(){

        List<PropostaModel> propostas = propostaService.recebe_proposta_func(ScreenController.cod_pessoa_atual);

        ObservableList<String> items = FXCollections.observableArrayList();

        for(int i = 0; i < propostas.size(); i++){

            if(propostas.get(i).getStatus() == 2){
                items.add(barController.getNameById(propostas.get(i).getId_bar()));
            }
        }

        if(items.isEmpty()){
            items.add("Sem propostas recebidas");
        }

        list_view.setItems(items);

    }
    private void gera_modal(){

        String titulo = list_view.getSelectionModel().getSelectedItem();

        BarModel bar = barController.getBarByName(titulo);

        List<PropostaModel> propostaModel = propostaService.recebe_proposta_func(ScreenController.cod_pessoa_atual);

        String descricao = "";

        Integer id_proposta = 0;

        for(int i = 0; i < propostaModel.size(); i++){

            if(titulo.equals(bar.getNome())){
                descricao = propostaModel.get(i).getDescricao();
                id_proposta = i;
            }

        }


        if(!titulo.equals("Sem propostas recebidas")){

            Stage stage = (Stage) anchor_pane.getScene().getWindow();

            Alert.AlertType type = Alert.AlertType.CONFIRMATION;

            Alert alert = new Alert(type, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setContentText("Deseja aceitar proposta?");

            alert.getDialogPane().setHeaderText(descricao);

            Optional<ButtonType> result = alert.showAndWait();

            if(result.get() == ButtonType.OK){

                propostaService.update_proposta(propostaModel.get(id_proposta).getId_proposta(), 1);
                funcionarioService.atualiza_func(ScreenController.cod_pessoa_atual, bar.getId_bar());

            }else if(result.get() == ButtonType.CANCEL){

                propostaService.update_proposta(propostaModel.get(id_proposta).getId_proposta(), 2);

            }



        }



    }


}
