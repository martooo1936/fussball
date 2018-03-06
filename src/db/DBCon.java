package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

    private final static String URL = "jdbc:mysql://54.202.29.22:3306/";
    private final static String DB_NAME = "krastevdb";
    private final static String USER = "martin";
    private final static String PASS = "martin";


    public static Connection getConnection (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    URL + DB_NAME,
                    USER,
                    PASS);
                    return con;

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;


    }
}
