package com.github.maximaba.address.view;

import com.github.maximaba.address.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;

    private Stage dialogStage;
    private ResourceBundle resourceBundle;
    private MainApp mainApp;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;

        //добавляем в choice box пункты
        this.choiceBox.setValue(resources.getString("key.locate"));
        this.choiceBox.setItems(FXCollections.observableArrayList("English","Русский"));

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    @FXML
    private void handleOk() {
    }

    @FXML
    private void handleCancel1(){
        dialogStage.close();
    }

}