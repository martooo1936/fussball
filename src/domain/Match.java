package domain;


import java.time.LocalDate;

public class Match {

    private LocalDate gameDay;
    private String gameName;
    private Team team_one;
    private Team team_two;
   // private String result;
    private int team_one_goals;
    private int team_two_goals;
    //private String winner;

    public Match(String gameName,Team team_one, Team team_two) {
        this.gameName = gameName;
        this.team_one = team_one;
        this.team_two = team_two;
    }




    public Match(String game_name, Team team_one, Team team_two, int team_one_goals, int team_two_goals) {
        this.gameName = gameName;

        this.team_one = team_one;
        this.team_two = team_two;
     //   this.result = result;
        this.team_one_goals = team_one_goals;
        this.team_two_goals = team_two_goals;
       // this.winner = winner;
    }

    //defining winner of the game
    /*public void setWinner(){
        if (team_one_goals == team_two_goals){
            this.winner = "equal";
        }
        if (team_one_goals > team_two_goals){
            this.winner = "win for" + team_one;
        }
        if (team_one_goals < team_two_goals){
            this.winner = "win for" + team_two;
        }
    }*/

    public String getGameName() {
        return gameName;
    }



    public LocalDate getGameDay() {
        return gameDay;
    }

    public void setGameDay(LocalDate gameDay) {
        this.gameDay = gameDay;
    }

    public Team getTeam_one() {
        return team_one;
    }

    public void setTeam_one(Team team_one) {
        this.team_one = team_one;
    }

    public Team getTeam_two() {
        return team_two;
    }

    public void setTeam_two(Team team_two) {
        this.team_two = team_two;
    }
    /*public String getResult() {
        return result;
    }*/

    /*public void setResult(String result) {
        this.result = result;
    }*/

    public int getTeam_one_goals() {
        return team_one_goals;
    }

    public void setTeam_one_goals(int team_one_goals) {
        this.team_one_goals = team_one_goals;
    }

    public int getTeam_two_goals() {
        return team_two_goals;
    }

    public void setTeam_two_goals(int team_two_goals) {
        this.team_two_goals = team_two_goals;
    }

   /* public String getWinner() {
        return winner;
    }*/

}
