package com.example.api_1.ViewController.Eventos;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ECEController implements ControlledScreen {

    //FXML

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Button button_registrar_evento;

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
        controller.setScreen("dashboardCE");
    }


    @FXML
    void onPressedRegistraEvento(MouseEvent event) {

        controller.loadScreen("RegistraEvento", "/Evento/RegistraEvento.fxml", ScreenController.get_ac());
        controller.setScreen("RegistraEvento");
    }

    @FXML
    void onPressedPg(MouseEvent event) {
        controller.loadScreen("PagamentoGeral", "/Pagamento/Pagamento.fxml", ScreenController.get_ac());
        controller.setScreen("PagamentoGeral");
    }

    @FXML
    void onPressedProposta(MouseEvent event) {
        controller.loadScreen("PropostaCE", "/Proposta/ContratanteEvento.fxml", ScreenController.get_ac());
        controller.setScreen("PropostaCE");
    }

    @FXML
    public void initialize(){

        popular_lista();

    }


    //Controller telas

    ScreenController controller;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }

    //Funções

    @Autowired
    EventosGeral eventosGeral;

    private void popular_lista(){

        ObservableList<String> items = eventosGeral.lista_populada("CE");

        list_view.setItems(items);

    }

    private void gera_modal(){

        String titulo = list_view.getSelectionModel().getSelectedItem();

        eventosGeral.gera_modal(titulo);

    }

}
