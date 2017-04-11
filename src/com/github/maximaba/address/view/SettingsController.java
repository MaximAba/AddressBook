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

        //добавляем в combo box пункты
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
     * Метод записи изменений в файл настроек Settings.property
     * @param key ключ в Settings.property
     * @param value значение в Settings.property
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
     * При нажатии OK "перезапускаем" Application с новыми параметрами.
     * Закрываем диалог настроек.
     */
    @FXML
    private void handleOk() {
        mainApp.start(mainApp.getPrimaryStage());
        dialogStage.close();
    }

    /**
     * Кнопка Cancel. Обнуляет изменения. Задает текущий Locate
     * Закрываем диалог настроек.
     */
    @FXML
    private void handleCancel(){
        setProperty("key.property.language", resourceBundle.getString("key.locate"));
        dialogStage.close();
    }

    /**
     * Меняем Locate на язык который в данный момент выбран в Combo Box.
     */
    @FXML
    private void changeLang(){
        setProperty("key.property.language", LocateUtil.formatLang(comboBox.getValue()));
    }
}