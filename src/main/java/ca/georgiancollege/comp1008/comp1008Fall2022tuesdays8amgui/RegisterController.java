package ca.georgiancollege.comp1008.comp1008Fall2022tuesdays8amgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TextField textUsername;

    @FXML
    private PasswordField textPassword;

    @FXML
    private PasswordField confirmPassword;

    RegisterModel model = new RegisterModel();

    @FXML
    void onClearClick(ActionEvent event) {

        textUsername.setText("");
        textPassword.setText("");
        confirmPassword.clear();

    }

    @FXML
    void onRegisterClick(ActionEvent event) {

        //RegisterModel model = new RegisterModel(textUsername.getText(), textPassword.getText(), confirmPassword.getText());
        //model.processRequest(textUsername.getText(), textPassword.getText(), confirmPassword.getText());
        try {
        //    model.validateData();
           model.processRequest(textUsername.getText(), textPassword.getText(), confirmPassword.getText());

        }
        catch (Exception e){
            System.err.println(e);
            Utilities.createAlert(Alert.AlertType.ERROR, "Error!", e.getMessage()).show();
        }
    }

}
