package ca.georgiancollege.comp1008.comp1008Fall2022tuesdays8amgui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Utilities {

    /*
    Common functionality for our apps
     */
    //create alerts
    //open page

    static Alert createAlert(Alert.AlertType alertType,
                            String title,
                            String content){

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        return alert;
    }

    static void openScreen(String nameOfFile, String title) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(
                nameOfFile + "-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }


    }

