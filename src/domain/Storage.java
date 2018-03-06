package domain;

import db.CRUDmatch;
import db.CRUDplayer;
import db.CRUDteam;

import java.util.List;

/**
 * Created by bc on 16/05/2017.
 */
public class Storage {
    private final CRUDplayer playersData = new CRUDplayer();
    private final CRUDteam teamsData  = new CRUDteam();
    private final CRUDmatch matchData = new CRUDmatch();


    private static Storage instance;
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

   /* public boolean registerPlayer (Player player){
        return playersData.registerPlayer(player);
    }*/
    public List<Player> getPlayersFomDB(){
        return playersData.getPlayersFromDB();
    }

    public void  deletePlayer(Player player)
    {
        playersData.deletePlayer(player);
    }

}
