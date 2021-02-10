package JDBC_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdateToDBExample {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/practice", "madyar", "mdamdamda");
            st = con.createStatement();
            st.addBatch("INSERT INTO user (name, second_name) VALUES ('Maya', 'Turgenbayeva')");
            st.addBatch("INSERT INTO user (name, second_name) VALUES ('Maya1', 'Turgenbayeva')");
            st.addBatch("INSERT INTO user (name, second_name) VALUES ('Maya2', 'Turgenbayeva')");
            int[] rowsAffected = st.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try{
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
