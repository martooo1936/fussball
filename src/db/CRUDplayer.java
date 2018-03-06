package db;


import com.mysql.jdbc.*;
import domain.Player;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CRUDplayer {

    private Connection conn = null;
    private static final String TABLE = "`krastevdb`.`players`";
    private static  CRUDplayer cruDplayer;


    public static synchronized CRUDplayer getInstance(){
        if (cruDplayer == null){
            cruDplayer = new CRUDplayer();
        }
        return cruDplayer;
    }





    public  int savePlayerToDB(Player player){

        conn = DBCon.getConnection();
        int playerId = -1;
        String sql =  "INSERT INTO " + TABLE + " (" +
                "`first_name`, `last_name`, `date_of_birth`, `email`" +
                ") VALUES (" +
                "?, ?, ?, ?" +
                ") ;";
            try {
                PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,player.getFirst_name());
                ps.setString(2,player.getLast_name());
                ps.setDate(3, Date.valueOf(player.getDate_of_birth()));
                ps.setString(4,player.getEmail());

                ps.execute();

                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    playerId = rs.getInt(1);
                }
                ps.close();
            }

            catch (SQLException e) {
                e.printStackTrace();
            }

          return playerId;
    }
  /*  public boolean registerPlayer(Player pl){
        try {
            String sql = "INSERT INTO players VALUES(NULL, '" + pl.getFirst_name() + "" + pl.getLast_name()+ "',";
            if(pl.getEmail() == null){
                sql += " NULL,  '" + pl.getDate_of_birth() + "')";
            }
            else {
                sql += " '" + pl.getEmail() + "', '" + pl.getDate_of_birth() + "')";
            }
            Connection con = DBCon.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.close();
            return true;
        }
        catch (SQLException e ){
            e.printStackTrace();
            return false;
        }
    }*/
  // Getting players who are registered in the DB
    public static  ArrayList<Player> getPlayersFromDB(){
        ArrayList<Player> playerList = new ArrayList<>();
        try {
            Connection con = DBCon.getConnection();

            String sql = "SELECT * FROM `players`";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()){

                Player player = new Player(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                         rs.getString("email"));
                 playerList.add(player);
            }

            ps.close();

        }
        catch (SQLException e ){
            e.printStackTrace();

        }
        return playerList;
    }
    public void deletePlayer(Player pl){
        try {
            Connection con = DBCon.getConnection();
            String sql = "DELETE FROM * `players` WHERE id= ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,pl.getPlayerId());
            pstmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void updatePlayer (Player pl){
       try {
           Connection con = DBCon.getConnection();

        String sql = "UPDATE players SET `first_name` = ?, `last_name` = ? , date_of_birth = ? , email = ? , WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,pl.getFirst_name());
        pstmt.setString(2,pl.getLast_name());
        pstmt.setDate(3,Date.valueOf(pl.getDate_of_birth()));
        pstmt.setString(4,pl.getEmail());
        pstmt.setInt(5,pl.getPlayerId());
        pstmt.executeUpdate();

        con.close();
       }
       catch (SQLException e ){
           e.printStackTrace();
       }
    }



}
