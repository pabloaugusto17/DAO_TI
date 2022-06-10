/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package com.example.api_1.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.api_1.ViewInitializer.ControlledScreen;
import com.example.api_1.ViewInitializer.ScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

/**
 *
 * @author Victor Hugo
 */

@Component
public class TelaInicialBarDrinkController implements ControlledScreen {

    ScreenController controller;

    @FXML
    private Button enviop;

    @FXML
    private Button eventos;

    @FXML
    private Button home;

    @FXML
    private Button veja_eventos;

    @FXML
    private Button enviox;

    @Override
    public void setScreenParent(ScreenController screenPage) {
        controller = screenPage;
    }
}
