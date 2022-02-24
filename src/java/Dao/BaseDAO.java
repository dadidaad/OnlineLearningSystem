package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * Get connection to database
 */
public class BaseDAO {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=OnlineLearningSystem;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
