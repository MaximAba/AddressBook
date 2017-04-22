package com.github.maximaba.address.controller;

import com.github.maximaba.address.MainApp;
import com.github.maximaba.address.util.LocateUtil;
import com.github.maximaba.address.util.ParamApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    private Stage dialogStage;
    private ResourceBundle resourceBundle;
    private MainApp mainApp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;

        //добавляем в combo box элементы
        this.comboBox.setItems(FXCollections.observableArrayList(LocateUtil.RU.getName(), LocateUtil.EN.getName()));
        this.comboBox.setValue(resourceBundle.getString("key.locate"));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * При нажатии OK "перезапускаем" Application с новыми параметрами.
     */
    @FXML
    private void handleOk() {
        mainApp.start(mainApp.getPrimaryStage());
        dialogStage.close();
    }

    /**
     * Обнуляет все изменения.
     */
    @FXML
    private void handleCancel() {
        ParamApp.save("key.param.language",ParamApp.language);
        dialogStage.close();
    }

    /**
     * Изменяет параметр. Привязан к comboBox
     */
    @FXML
    private void changeLang() {
        ParamApp.save("key.param.language", LocateUtil.formatLang(comboBox.getValue()));
    }
}