package view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by bc on 15/05/2017.
 */
public class Controller {
    private static Controller instance ;

    private Controller()
    {

    }
    public static Controller getInstance(){
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }
    private Stage primaryStage;

    public void setStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    void loadLoginPage() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        primaryStage.setScene(new Scene(root,750,700));
    }
    void loadPlayerView()throws IOException{
        Parent playerRoot = FXMLLoader.load(getClass().getResource("/view/PlayerView.fxml"));
        Scene playerView = new Scene(playerRoot,800,800);
        primaryStage.setScene(playerView);
    }
    void loadAdminView()throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/AdminView.fxml"));
        Scene adminView = new Scene(root,800,600);
        primaryStage.setScene(adminView);
    }


   public static void displayError(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
   public static void displayInfo(String title,String header,String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
    }
    boolean displayConfirmation(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


}
