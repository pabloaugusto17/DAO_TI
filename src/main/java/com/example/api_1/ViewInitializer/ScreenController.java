package com.example.api_1.ViewInitializer;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
@Component
public class ScreenController  extends StackPane {

    //armazenar todas as telas em apenas um hash
    private HashMap<String, Node> screens = new HashMap<>();

    public static ApplicationContext ac_static;
    public static int cod_pessoa_atual =  0;

    public ScreenController(){
        super();
    }
    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }

    //por se tratar de um hash, precisa apenas do nome pois é chave dela
    public Node getScreen(String name){

        return screens.get(name);

    }
    //carrega o .fxml
    public boolean loadScreen(String name, String resource, ApplicationContext ac){

        try{

            URL url = getClass().getResource(resource);
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            fxmlLoader.setControllerFactory(ac::getBean);
            Parent root = fxmlLoader.load();
            ControlledScreen controlledScreen = fxmlLoader.getController();
            controlledScreen.setScreenParent(this);
            addScreen(name, root);

            return true;

        }catch (Exception e){
            return false;
        }

    }

    //mudar tela
    public boolean setScreen(final String name){

        //caso a tela exista
        if(screens.get(name) != null){

            //trancisaso de tela reduzindo a opacidade
            final DoubleProperty opacity = opacityProperty();

            //caso possua mais de uma tela
            if(!getChildren().isEmpty()){

                getChildren().remove(0);
                getChildren().add(0, screens.get(name));

                //criando efeito de fadde
                /*Timeline fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) { //trocando as telas
                            getChildren().remove(0);
                            getChildren().add(0, screens.get(name)); // tela nova
                            Timeline fadeIn = new Timeline( //efeito para sair da tela antiga
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        }
                    }, new KeyValue(opacity, 0.0)));
                    fade.play();*/
            //caso só possua uma tela em screens ela será carregada com o mesmo efeito de antes

            }else{

                //setOpacity(0.0);
                getChildren().add(screens.get(name));
                /*Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity,1.0)));
                fadeIn.play();*/
            }

            return true;

        } else {

            //não conseguiu ler a tela
            return false;

        }

    }

    //remover tela de screens
    public boolean unloadScreen(String name){

        //caso ela não exista
        if(screens.remove(name) == null){

            return false;

        }else{

            //caso exista e seja removida com sucesso
            return true;
        }


    }

    public void reloadScreen(String name) {

        Node screen = this.getScreen(name);

    }

    public static void set_ac(ApplicationContext ac){
        ScreenController.ac_static = ac;
    }

    public static ApplicationContext get_ac(){

        return ScreenController.ac_static;
    }






}
