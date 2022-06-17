package com.example.api_1.ViewController.Eventos;

import com.example.api_1.Controller.BarController;
import com.example.api_1.Controller.ContratanteEventoController;
import com.example.api_1.Controller.EventoController;
import com.example.api_1.Controller.FuncionariosController;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.EventoModel;
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

import java.util.List;

@Component
class EventosGeral {

    @Autowired
    EventoController eventoController;

    @Autowired
    FuncionariosController funcionariosController;

    @Autowired
    BarController barController;

    @Autowired
    ContratanteEventoController contratanteEventoController;

    public ObservableList<String> lista_populada(String tipo){

        List<EventoModel> lista_eventos = eventoController.listar_eventos();

        ObservableList<String> items = FXCollections.observableArrayList();

        BarModel bar = null;

        if(tipo.equals("Bar")){
            bar = barController.getBarByDinamicId(ScreenController.cod_pessoa_atual);
        }

        for(int i = 0; i < lista_eventos.size(); i++){

            if (tipo.equals("Funcionario")){

                if(lista_eventos.get(i).getId_bar_evento().equals(funcionariosController.getByDinamicId(ScreenController.cod_pessoa_atual).getCnpj_barEvento())){
                    items.add(lista_eventos.get(i).getNome());
                }
            }

            if(tipo.equals("Bar")){

                if(lista_eventos.get(i).getId_bar_evento().equals(bar.getId_bar())){
                    items.add(lista_eventos.get(i).getNome());
                }

            }

        }

        if(items.isEmpty()){
            items.add("Sem eventos registrados");
        }



        return items;
    }

    public void gera_modal(String titulo) {

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

}
