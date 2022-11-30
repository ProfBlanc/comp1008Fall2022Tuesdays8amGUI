package ca.georgiancollege.comp1008.comp1008Fall2022tuesdays8amgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//test
public class LoginController {
    @FXML
    private Label errorMessage;

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    LoginModel model = new LoginModel();

    @FXML
    void onLoginClicked(ActionEvent event) {

        try{
            model.processRequest(loginUsername.getText(), loginPassword.getText());
            Utilities.openScreen("welcome", "Welcome!");
        }
        catch (Exception e){
            errorMessage.setText(e.getMessage());
        }

    }

    @FXML
    void onRegisterClicked(ActionEvent event) {

        System.out.println(loginPassword.getText());
        try {
            Utilities.openScreen("register", "Register");
        }
        catch (Exception e){
            errorMessage.setText(e.getMessage());
        }

    }

    @FXML
    void initialize(){

        errorMessage.setText("");
    }

}
