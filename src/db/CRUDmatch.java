package db;



import domain.Match;
import domain.Team;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDmatch {

    public Map<String, Match> showAllGames(Map<String, Team> teamsMap){
        Map<String, Match> gamesMap = new HashMap<>();
        try {
            Connection con = DBCon.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM match";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String game_name = rs.getString(1);
                String teamOne = rs.getString(2);
                String teamTwo = rs.getString(3);
                int teamOneGoals = rs.getInt(4);
                int teamTwoGoals = rs.getInt(5);
                LocalDate gameDay = rs.getDate(6).toLocalDate();


                Team team1 = teamsMap.get(teamOne);
                Team team2 = teamsMap.get(teamTwo);

                Match match = new Match(game_name,team1,team2,teamOneGoals,teamTwoGoals);
                match.setGameDay(gameDay);
                gamesMap.put(game_name,match);
            }
            con.close();
        }
        catch (SQLException e ){
            e.printStackTrace();
        }
        return gamesMap;
    }
    public void storeMatch (List<Match> matchList){
        for (Match match: matchList) {
            Team teamOne = match.getTeam_one();
            Team teamTwo = match.getTeam_two();
        }
        try {
            Connection con = DBCon.getConnection();
            Statement stmt = con.createStatement();
            String sql =  "INSERT INTO match VALUES('"  ;

        }
        catch (SQLException e ){
            e.printStackTrace();
        }
    }
    public  List<Match> getNextMatches(Map<String, Team> teamMap){

        Map<String,Match> matchMap = showAllGames(teamMap);
        List<Match> matches = new ArrayList<>();
        try {
            Connection con = DBCon.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT game_name FROM match WHERE date =?";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String gameName = rs.getString(1);
                Match match = matchMap.get(gameName);
                matches.add(match);
            }
            con.close();
            return matches;
        }
        catch (SQLException e){
            e.printStackTrace();
            return matches;
        }

    }

  /*  public List<Match> getMatchesResults(Map<String, Team> teamMap) {
        Map<String, Match> matchesMap = showAllGames(teamMap);
        List<Match> matches = new ArrayList<>(); //
        try {
            Connection con = DBCon.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT game_name FROM matches WHERE match_played = 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String gameName = rs.getString(1);

                Match match = matchesMap.get(gameName);

                matches.add(match);
            }
            con.close();
            return matches;
        } catch (SQLException e) {
            e.printStackTrace();
            return matches;
        }
    }*/


    public boolean deleteGame(Match match) {
        try {
            Connection con = DBCon.getConnection();
            String sql = "DELETE FROM matches WHERE game_name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, match.getGameName());
            pstmt.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editGameDate(Match match) {
        try {
            Connection con = DBCon.getConnection();
            String sql = "UPDATE matches SET match_date = ? WHERE match_name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf(match.getGameDay()));
            pstmt.setString(2, match.getGameName());
            pstmt.executeUpdate();
            con.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




}