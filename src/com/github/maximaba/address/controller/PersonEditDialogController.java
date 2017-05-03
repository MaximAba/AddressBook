package com.github.maximaba.address.controller;

import com.github.maximaba.address.model.Person;
import com.github.maximaba.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Окно для изменения информации об адресате.
 */
public class PersonEditDialogController implements Initializable {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField phoneNumberField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;
    private ResourceBundle resourceBundle;

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage Stage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     *
     * @param person person
     */
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        postalCodeField.setText(Integer.toString(person.getPostalCode()));
        cityField.setText(person.getCity());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
        phoneNumberField.setText(person.getPhoneNumber().replaceAll("[-()]", ""));
    }

    /**
     * @return true, если пользователь кликнул OK, в другом случае false.
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setStreet(streetField.getText());
            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            person.setCity(cityField.getText());

            //см. util.DateUtil
            person.setBirthday(DateUtil.parse(birthdayField.getText()));

            person.setPhoneNumber(phoneNumberField.getText().replaceFirst("(\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})",
                    "$1-($2)-$3-$4-$5"));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().isEmpty()) {
            errorMessage += resourceBundle.getString("key.error.edit.context.firstName") + "\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().isEmpty()) {
            errorMessage += resourceBundle.getString("key.error.edit.context.lastName") + "\n";
        }
        if (streetField.getText() == null || streetField.getText().isEmpty()) {
            errorMessage += resourceBundle.getString("key.error.edit.context.street") + "\n";
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().isEmpty()) {
            errorMessage += resourceBundle.getString("key.error.edit.context.postalCode") + "\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += resourceBundle.getString("key.error.edit.context.postalCodeNFE") + "\n";
            }
        }

        if (cityField.getText() == null || cityField.getText().isEmpty()) {
            errorMessage += resourceBundle.getString("key.error.edit.context.city") + "\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().isEmpty()) {
            errorMessage += resourceBundle.getString("key.error.edit.context.birthday") + "\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += resourceBundle.getString("key.error.edit.context.birthdayNPE") + "\n";
            }
        }

        if (phoneNumberField.getText() == null || phoneNumberField.getText().length() != 11) {
            errorMessage += resourceBundle.getString("key.error.edit.context.phoneLength") + "\n";
        } else {
            try {
                // пытаемся преобразовать почтовый код в long, так как номер 9ти значный.
                Long.parseLong(phoneNumberField.getText());
            } catch (NumberFormatException e) {
                errorMessage += resourceBundle.getString("key.error.edit.context.phoneNFE") + "\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle(resourceBundle.getString("key.error"));
            alert.setHeaderText(resourceBundle.getString("key.error.edit.header"));
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }
}
