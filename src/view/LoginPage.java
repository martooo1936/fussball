package view;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;

public class LoginPage {

    private static final String ADMIN_USERNAME = "martin";
    private static final String ADMIN_PASSWORD = "strongpassword";



    private boolean isVailid(String username , String password){
        return (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) ;
    }

    @FXML
    private TextField admLogin;
    @FXML
    private PasswordField passField;

   @FXML
    private void btnLogin(){
       String admin = admLogin.getText();
       String pass = passField.getText();
       try{
           if(isVailid(admin,pass)){
               Controller.getInstance().loadAdminView();
           }
           else {
               Alert wrongInput = new Alert(Alert.AlertType.ERROR);
               wrongInput.setTitle("You can not login");
               wrongInput.setHeaderText("Wrong username or password");
               wrongInput.setContentText(null);
               wrongInput.showAndWait();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   @FXML
    private void plLogin(){
        try {
            Controller.getInstance().loadPlayerView();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }

}




