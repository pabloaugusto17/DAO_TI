package com.example.api_1.ViewController.TelaInicial;

import com.example.api_1.Controller.PessoaController;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Repository.ContratanteEventoRepository;
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

        controller.loadScreen("EventosCE", "/Eventos/ContratanteEvento.fxml", ScreenController.get_ac());
        controller.setScreen("EventosCE");
    }
    @FXML
    void onPressedEventos(MouseEvent event) {

        controller.loadScreen("EventosCE", "/Eventos/ContratanteEvento.fxml", ScreenController.get_ac());
        controller.setScreen("EventosCE");
    }

    @FXML
    void onPressedRegistrarEvento(MouseEvent event) {

        controller.loadScreen("RegistraEvento", "/Eventos/RegistraEvento.fxml", ScreenController.get_ac());
        controller.setScreen("RegistraEvento");
    }

    @FXML
    void onPressedProposta(MouseEvent event) {

        controller.loadScreen("PropostaCE", "/Proposta/ContratanteEvento.fxml", ScreenController.get_ac());
        controller.setScreen("PropostaCE");

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

    @Autowired
    private ContratanteEventoRepository contratanteEventoRepository;

    private void set_labels(){

        PessoaModel pessoa_atual = pessoaController.getPessoaByIdDynamic(ScreenController.cod_pessoa_atual);
        String nome_pessoa = pessoa_atual.getNome();
        Integer quant_eventos = contratanteEventoRepository.quant_eventos_CE(ScreenController.cod_pessoa_atual);

        label_nome.setText(nome_pessoa);
        label_1.setText("Olá, " + nome_pessoa);
        label_eventos.setText(label_eventos.getText() + " " + quant_eventos);

    }

}
