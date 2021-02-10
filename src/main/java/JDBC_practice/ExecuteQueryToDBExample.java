package JDBC_practice;

import java.sql.*;

public class ExecuteQueryToDBExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("" +
                    "jdbc:mysql://127.0.0.1/practice", "madyar", "mdamdamda");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + resultSet.getString(2) + resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            try{
                if(resultSet != null) {
                    resultSet.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
