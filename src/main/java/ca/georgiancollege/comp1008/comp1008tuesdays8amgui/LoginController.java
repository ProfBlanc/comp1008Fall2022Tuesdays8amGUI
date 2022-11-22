package ca.georgiancollege.comp1008.comp1008tuesdays8amgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Label errorMessage;

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    void onLoginClicked(ActionEvent event) {

        //sout
        //System.out.println(loginUsername.getText());
        String receivedUsername = loginUsername.getText();
        String expectedUsername = "admin";

        String receivedPassword = loginPassword.getText();
        String expecedPassword = "pass";
        if(receivedUsername.equals(expectedUsername)
        &&
            receivedPassword.equals(expecedPassword)){

            errorMessage.setText("");

            Utilities.createAlert(Alert.AlertType.CONFIRMATION,
                    "Good Job!",
                    "You may enter").show();

            try{
                Utilities.openScreen("welcome", "Welcome Everyone!");
            }
            catch (Exception e){

                Utilities.createAlert(Alert.AlertType.ERROR,
                        "Cannot open file",
                        "We were unable open the welcome file").show();
            }
        }
        else{
           /*
            Utilities.createAlert(Alert.AlertType.ERROR,
                    "Error! Bad!",
                    "Incorrect Username and/or password").show();

            */
            errorMessage.setText("Incorrect Username and/or password");
        }

    }

    @FXML
    void onRegisterClicked(ActionEvent event) {

        System.out.println(loginPassword.getText());

    }

    @FXML
    void initialize(){

        errorMessage.setText("");
    }

}
