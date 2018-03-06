package domain;


import db.CRUDplayer;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class Player {

    private int playerId;
    private String first_name;
    private String last_name;
    private LocalDate date_of_birth;
    private String email;
    //private int rank;
    //private int gamesPlayed;


    // Create a new player

    public Player(String first_name, String last_name, LocalDate date_of_birth,String email ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        //this.rank = rank;
    }



    public Player(int playerId, String first_name, String last_name, LocalDate date_of_birth, String email) {
        this.playerId = playerId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email = email;

       // this.rank = rank;
    }

    public Player() {

    }
   public void storePlayer() {
       CRUDplayer cruDplayer = CRUDplayer.getInstance();
       cruDplayer.savePlayerToDB(this);
   }



    public  void savePlayer(String first_namefd,String last_namefd,LocalDate date_of_birthfd,String emailfd){
        Player player = new Player(first_namefd,last_namefd,date_of_birthfd,emailfd);
        player.storePlayer();


    }

    





   /* public void setGamesPlayed (int gamesPlayed){
        if(gamesPlayed >= 0){
            this.gamesPlayed = gamesPlayed;
        }
        else {
            throw new IllegalArgumentException("This can not be a negative number");
        }
    }
    // Insert games played by the player
    public void addGamesPlayed(int gamesPlayed){
        if (gamesPlayed >= 0){
            this.gamesPlayed += gamesPlayed;
        }
        else {
            throw new IllegalArgumentException("This can not be a negative number");
        }
    }
    // set a rank for the player based on his experience
    // 1 == newbie , 2 == mediocre , 3 == pro
    public void setPlayerRank(int rank){
        if(gamesPlayed >= 1 && gamesPlayed<5){
            this.rank = 1;
        }
        if (gamesPlayed>=5 && gamesPlayed<10){
            this.rank = 2;
        }
        if (gamesPlayed>10){
            this.rank = 3;
        }
    }*/


    public int getPlayerId() {
        return playerId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* public int getRank() {
        return rank;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }*/

    @Override
    public String toString() {
        return this.first_name;
        /*"Player{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", email='" + email + '\'' +
                '}';*/
    }
}
