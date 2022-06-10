package com.example.api_1;

import com.example.api_1.ViewInitializer.ScreenController;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class ScreenFramework extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void start(Stage stage) throws Exception {

        this.context.publishEvent(new StageReadyEvent(stage));

    }

    @Override
    public void init() throws Exception {

        ApplicationContextInitializer<GenericApplicationContext> initializer =
                ac -> {


                    ac.registerBean(Application.class, () -> ScreenFramework.this);
                    ac.registerBean(Parameters.class,this::getParameters);
                    ac.registerBean(HostServices.class, this::getHostServices);
                };

        this.context = new SpringApplicationBuilder( )
                .sources(Api1Application.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));


    }

    @Override
    public void stop() throws Exception {
        this.context.close();
        Platform.exit();
    }


}

class StageReadyEvent extends ApplicationEvent {

    private final Stage stage;

    StageReadyEvent(Stage stage) {
        super(stage);
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}

@Component
class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private final String applicationTitle;
    private final ApplicationContext applicationContext;

    StageInitializer(@Value("${spring.application.ui.title}")String applicationTitle,
                     ApplicationContext applicationContext) {
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent stageReadyEvent) {


        ScreenController main = new ScreenController();

        ScreenController.set_ac(this.applicationContext);

        main.loadScreen("telalogin","/TelaLogin.fxml", this.applicationContext);
        main.loadScreen("telaInicialBarDrinks", "/TelaInicialBarDrinks.fxml", this.applicationContext);
        main.loadScreen("telacadastro", "/TelaCadastro.fxml", this.applicationContext);
        main.loadScreen("telacadastro2", "/TelaCadastro2.fxml", this.applicationContext);


        main.setScreen("telalogin");

        Stage stage = stageReadyEvent.getStage();

        Group root = new Group();
        root.getChildren().addAll(main);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(this.applicationTitle);
        stage.show();


    }
}



