package JDBC_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDBExample {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1", "madyar", "mdamdamda");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
