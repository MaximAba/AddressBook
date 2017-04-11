package com.github.maximaba.address.view;

import com.github.maximaba.address.MainApp;
import com.github.maximaba.address.util.LocateUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    private Stage dialogStage;
    private ResourceBundle resourceBundle;
    private MainApp mainApp;
    private Properties properties;

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

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * ����� ������ ��������� � ���� �������� Settings.property
     * @param key ���� � Settings.property
     * @param value �������� � Settings.property
     */
    private void setProperty(String key, String value){
        FileOutputStream fos;
        try{
            properties.setProperty(key, value);
            fos = new FileOutputStream("resource\\Settings.properties");
            properties.store(fos,null);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private void handleCancel(){
        setProperty("key.property.language", resourceBundle.getString("key.locate"));
        dialogStage.close();
    }

    /**
     * ������ Locate �� ���� ������� � ������ ������ ������ � Combo Box.
     */
    @FXML
    private void changeLang(){
        setProperty("key.property.language", LocateUtil.formatLang(comboBox.getValue()));
    }
}