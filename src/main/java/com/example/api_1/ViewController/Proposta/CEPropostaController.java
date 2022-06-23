package com.example.api_1.ViewController.Proposta;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.Model.PropostaModel;
import com.example.api_1.Service.PropostaService;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.List;

@Component
public class CEPropostaController implements ControlledScreen {

    //FXML
    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_registrar_proposta;

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

    }

    @FXML
    void onPressedHome(MouseEvent event) {

    }

    @FXML
    void onPressedRegistraProposta(MouseEvent event) {

        controller.loadScreen("RegistrarPropostaCE", "/Proposta/RegistraProposta.fxml", ScreenController.get_ac());
        controller.setScreen("RegistrarPropostaCE");

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
    PropostaService propostaService;

    @Autowired
    BarController barController;

    private void popular_lista(){

        List<PropostaModel> propostas = propostaService.recebe_proposta_by_id_contratante(ScreenController.cod_pessoa_atual);

        ObservableList<String> items = FXCollections.observableArrayList();

        for(int i = 0; i < propostas.size(); i++){
            items.add(barController.getNameById(propostas.get(i).getId_bar()));
        }

        if(items.isEmpty()){
            items.add("Sem propostas registrados");
        }


        list_view.setItems(items);

    }

    private void gera_modal(){

        String titulo = list_view.getSelectionModel().getSelectedItem();

        Integer bar_analisar = barController.getIdBarByName(titulo);

        PropostaModel proposta = propostaService.recebe_proposta(bar_analisar, ScreenController.cod_pessoa_atual);


        if(!titulo.equals("Sem propostas registrados")){

            int info = proposta.getStatus();

            String info_proposta = "PENDENTE";


            if(info == 1){
                info_proposta = "ACEITA";
            }else if(info == 2){
                info_proposta = "RECUSADA";
            }



            TextArea textArea = new TextArea();
            textArea.setText("Informações da Proposta: \n" +
                    "Descrição: " + proposta.getDescricao() +
                    "\nProposta " + info_proposta);
            textArea.setEditable(false);
            textArea.setWrapText(true);
            textArea.setPrefSize(400, 200);
            textArea.setStyle("-fx-text-fill:#F7A34A");


            Scene scene = new Scene(textArea);
            Stage stage = new Stage();

            if (titulo != null) {
                stage.setTitle(titulo);
            }

            scene.getStylesheets().add("Proposta/StyleProposta.css");
            stage.setScene(scene);
            stage.initModality(Modality.NONE);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();

        }


    }
}
