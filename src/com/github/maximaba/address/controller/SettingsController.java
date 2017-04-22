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

        //��������� � combo box ������
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
     * ��� ������� OK "�������������" Application � ������ �����������.
     * ��������� ������ ��������.
     */
    @FXML
    private void handleOk() {
        mainApp.start(mainApp.getPrimaryStage());
        dialogStage.close();
    }

    /**
     * ������ Cancel. �������� ���������. ������ ������� Locate
     * ��������� ������ ��������.
     */
    @FXML
    private void handleCancel() {
        ParamApp.save("key.param.language",ParamApp.language);
        dialogStage.close();
    }

    /**
     * ������ Locate �� ���� ������� � ������ ������ ������ � Combo Box.
     */
    @FXML
    private void changeLang() {
        ParamApp.save("key.param.language", LocateUtil.formatLang(comboBox.getValue()));
    }
}