package ca.georgiancollege.comp1008.comp1008Fall2022tuesdays8amgui;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class RegisterModel {


    private String username, password, confirmPassword;

    public RegisterModel(){}

//    public RegisterModel(String username, String password, String confirmPassword){

    static final String tooShort = " is too short. 5 characters min";
    static final int minLength = 5;

    public void setUsername(String username) {
        if(username.length() < minLength)
            throw new IllegalArgumentException("Username" + tooShort);
        this.username = username;
    }

    public void setPassword(String password) {
        if(password.length() < minLength)
            throw new IllegalArgumentException("Password"+tooShort);
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        if(confirmPassword.length() < minLength)
            throw new IllegalArgumentException("Confirm password" + tooShort);
        if(!password.equals(confirmPassword))
            throw new IllegalArgumentException("Passwords do not match");

        this.confirmPassword = confirmPassword;
    }

    public void processRequest(String username, String password, String confirmPassword) throws Exception{
        /*
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
         */
        setUsername(username);
        setPassword(password);
        setConfirmPassword(confirmPassword);

        createUser();
    }

    /**
     * Validate all instance variables and ensure that they are all at least 5 characters long
     * @return
     */
    public boolean validateData(){
        return username.length() >= 5
                && password.length() >= 5
                && confirmPassword.length() >=5
                && password.equals(confirmPassword);


    }
    //if data is good, CREATE a new file: filename=username.txt. file content = password
    public boolean createUser() throws Exception{

        //file manipulation
        Path rootPath = Path.of("src/main/resources/ca/georgiancollege/comp1008/comp1008fall2022tuesdays8amgui");
        Path dataPath = rootPath.resolve("data");
        if(!dataPath.toFile().exists()){
            Files.createDirectory(dataPath);
        }
        Path userPath = dataPath.resolve(username + ".txt");
        Files.writeString(userPath, password);

        return true;
    }


}
