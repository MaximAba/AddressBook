package com.github.maximaba.address.view;

import com.github.maximaba.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;


public class RootLayoutController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleNew(){
        //todo create new file(XML)
    }

    @FXML
    private void handleOpen(){
        //todo open file
    }

    @FXML
    private void handleSave(){
        //todo save
    }

    @FXML
    private void handleSaveAs(){
        //todo save as
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Address Book");
        alert.setHeaderText("About");
        alert.setContentText("Привет дорогой друг!:)");

        alert.showAndWait();
    }



}
