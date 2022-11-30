package ca.georgiancollege.comp1008.comp1008Fall2022tuesdays8amgui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginModel {

    //do we need instance variables?
    //if so, how many?

    private String username, password;
    private final String expectedUsername="admin", expectedPassword="pass";

    public LoginModel(){}


    public void processRequest(String username, String password) {
        this.username = username;
        this.password = password;

        isValidCredentials();
    }
    public boolean validateData(){
        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }

    //method to find if the username and password exists

    public void isValidCredentials(){

        Path rootPath = Path.of("src/main/resources/ca/georgiancollege/comp1008/comp1008fall2022tuesdays8amgui");
        Path dataPath = rootPath.resolve("data");
        Path attemptToFindUser= dataPath.resolve(username + ".txt");

        try{
            String content = Files.readString(attemptToFindUser);

            if(!content.equals(password)){
                throw new IllegalArgumentException("Password for " + username + " is incorrect");
            }
        }
        catch (IOException e){
            throw new IllegalArgumentException("Username "+ username + " is not found");
        }

    }
}
