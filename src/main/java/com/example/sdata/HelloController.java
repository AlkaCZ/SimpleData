package com.example.sdata;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Button KontrolaButtonClick;
    @FXML

    private TextArea Vystup;
    public void AddButtonClick(ActionEvent actionEvent) {
        Vystup.setText("ADD");
    }

    public void KontrolaButtonClick(ActionEvent actionEvent) {
        Vystup.setText("Kontrola");

    }
}