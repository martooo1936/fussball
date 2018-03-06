package view;

import db.CRUDplayer;
import domain.Player;
import domain.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;




import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;
import java.util.ResourceBundle;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class AdminView implements Initializable {

    Player player = new Player();

    @FXML
    private TextField first_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField email;
    @FXML
    private DatePicker date_of_birth;
    @FXML
    private Button savePlayerBtn;




    public void saveData(ActionEvent actionEvent){
        System.out.println("loading");

        if(first_name.getText().isEmpty()|| last_name.getText().isEmpty()|| email.getText().isEmpty()){
            Controller.displayError("ERROR",null,"PLEASE FILL THE REQUIRED FIELDS");
            return;
        }
        if (date_of_birth.getValue().compareTo(LocalDate.now()) >= 0){
            Controller.displayError("ERROR",null,"PLEASE ENTER A VALID DATE");
            return;
        }
        else {
            player.savePlayer(first_name.getText(),last_name.getText(),date_of_birth.getValue(),email.getText());
            Controller.displayError("SUCCESS",null,"DATA HAS BEEN INSERTED !!!");
            first_name.clear();
            last_name.clear();
            email.clear();
            date_of_birth.setValue(null);


        }




    }
    @FXML
    private TableColumn<Player,String> fnameColumn;
    @FXML
    private TableColumn<Player,String> lnameColumn;
    @FXML
    private TableColumn<Player,String> emailColumn;
    @FXML
    private TableColumn<Player,String> birthColumn;
    @FXML
     private TableView<Player> playerTableView;
    @FXML
    private void goBack()
    {
        try {
            Controller.getInstance().loadLoginPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
            public void initialize(URL location,ResourceBundle resources)
    {
        fnameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        ObservableList<Player> players = FXCollections.observableArrayList();
        players.addAll(CRUDplayer.getPlayersFromDB());
        playerTableView.setItems(players);
}

private Player selectedPlayer;
    @FXML
    private void selectPlayer(){
        selectedPlayer = playerTableView.getSelectionModel().getSelectedItem();
        if (selectedPlayer!=null){
            String firstNameTab = selectedPlayer.getFirst_name();
            String lastNameTab = selectedPlayer.getLast_name();
            String emailTab = selectedPlayer.getEmail();
            LocalDate dobTab = selectedPlayer.getDate_of_birth();
            first_name.setText(firstNameTab);
            last_name.setText(lastNameTab);
            email.setText(emailTab);
            date_of_birth.setValue(dobTab);

        }
    }
    @FXML
    private void deletePlayer(){
        System.out.println("smth");
        if (selectedPlayer != null){
            if (Controller.getInstance().displayConfirmation("Attention","YOU are about to delete a player"+ selectedPlayer.getFirst_name(),null))
            {
                int id = selectedPlayer.getPlayerId();
                Storage.getInstance().deletePlayer(selectedPlayer);
                first_name.setText("");
                last_name.setText("");
                email.setText("");
                date_of_birth.setValue(null);
                selectedPlayer = null;
            }
            else
            {
            Controller.displayError("ERROR","You are supposed to select a player","Please select a player");
            }
        }
    }


}
