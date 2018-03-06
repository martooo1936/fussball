package domain;


public class Team {

    private String teamName;
    private Player player1;
    private Player player2;

    public Team(String teamName, Player player1, Player player2) {
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void registerPlayer(Player player) {
        if (player1 == null) {
            player1 = player;
            return;
        }
        if (player2 == null) {
            player2 = player;
        } else {
            throw new IllegalStateException("No space for more players");
        }

    }
    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                '}';
    }
}
