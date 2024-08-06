package persistence.ConnectionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection connection = null;

    public static Connection openConnection (){
        String url = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
        String user = "root";
        String password = "tupassword";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("open Connection");
        }catch(SQLException e){
            throw new RuntimeException("Error of Connection: " + e);
        }
        return connection;
    }

    public static void closeConnection() {
        if(connection != null){
            try {
                connection.close();
                System.out.println("close Connection");
            } catch (SQLException e) {
                throw new RuntimeException("Error of Closing Connection: " + e);
            }
        }
    }

//    public static void main(String[] args) {
//        ConnectionDB.openConnection();
//        ConnectionDB.closeConnection();
//    }
}
