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

    public BaseDAO(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=OnlineLearningSystem;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa1";
    private static String PASSWORD = "123";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
