package cats.connector;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import static cats.constants.Constants.*;
public class DataBaseConnector {
    public  static Connection getDBConnection(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println(CONNECTION_FAILED_ERROR_MESSAGE);
            e.printStackTrace();
            return connection;
        }

        if (connection != null) {
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }
}
