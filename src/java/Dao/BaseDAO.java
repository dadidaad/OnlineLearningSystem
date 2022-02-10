package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * Get connection to database
 */
public class BaseDAO {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=OnlineLearningSystem;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa1";
    private static String PASSWORD = "123";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
