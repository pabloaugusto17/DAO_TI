package com.example.api_1.ViewController;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.ContratanteEventoController;
import com.example.api_1.Controller.EventoController;
import com.example.api_1.Controller.FuncionariosController;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.scene.control.Button;
import java.util.List;

@Component
public class TelaVejaEventosFuncionariosController implements ControlledScreen {

    ScreenController controller;

    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Line line_1;

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private ListView<String> list_view;

    @FXML
    private Button button_voltar;

    @Autowired
    private FuncionariosController funcionariosController;

    @Autowired
    private EventoController eventoController;

    @Autowired
    private BarController barController;

    @Autowired
    private ContratanteEventoController contratanteEventoController;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    @FXML
    void onPressedEventos(MouseEvent event) {

    }

    @FXML
    void onPressedHome(MouseEvent event) {

        controller.setScreen("dashboardFuncionario");

    }

    @FXML
    public void initialize(){

        //Popular lista
        popular_lista();

    }

    @FXML
    void onListViewPressed(MouseEvent event) {

        //mostral modal com eventos
        gera_modal();


    }

    private void gera_modal(){

        String titulo = list_view.getSelectionModel().getSelectedItem();

        if(!titulo.equals("Sem eventos registrados")){

            EventoModel eventoModel = eventoController.getEventoByName(titulo);

            TextArea textArea = new TextArea();
            textArea.setText("Informações do evento: " +
                    "\n\t-Nome: " + eventoModel.getNome() +
                    "\n\t-Endereço: " + eventoModel.getEndereco() +
                    "\n\t-Duração: " + eventoModel.getDuracao() +
                    "\n\t-Quantidade de participantes: " + eventoModel.getQuantidade_participantes() +
                    "\n\t-Contratante do evento: " + contratanteEventoController.getNameById(eventoModel.getId_contratante_evento()) +
                    "\n\t-Bar realizador: " + barController.getNameById(eventoModel.getId_bar_evento()));

            textArea.setEditable(false);
            textArea.setWrapText(true);
            textArea.setPrefSize(400, 200);
            textArea.setStyle("-fx-text-fill:#F7A34A");


            Scene scene = new Scene(textArea);
            Stage stage = new Stage();

            if (titulo != null) {
                stage.setTitle(titulo);
            }

            scene.getStylesheets().add("Eventos/StyleEventos.css");
            stage.setScene(scene);
            stage.initModality(Modality.NONE);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();


        }




    }

    private void popular_lista(){

        List<EventoModel> lista_eventos = eventoController.listar_eventos();

        ObservableList<String> items = FXCollections.observableArrayList();

        for(int i = 0; i < lista_eventos.size(); i++){

            if(lista_eventos.get(i).getId_bar_evento().equals(funcionariosController.getByDinamicId(ScreenController.cod_pessoa_atual).getCnpj_barEvento())){
                items.add(lista_eventos.get(i).getNome());
            }
        }

        if(items.isEmpty()){
            items.add("Sem eventos registrados");
        }

        list_view.setItems(items);

        final int row_height = 24;

        list_view.setPrefHeight(items.size()  * row_height + 2);


    }



}
