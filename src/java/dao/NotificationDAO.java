/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * NotificationDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         Duc Minh    First Implement
 */
package dao;

import bean.NotificationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find Notification information from database Extend
 * BaseDAO class to call getConnection() method Implement INotificationDAO Interface
 *
 * @author Duc Minh
 */
public class NotificationDAO extends BaseDAO implements INotificationDAO{

    /**
     * getTopNotification method
     * This method Get all Subject available from database
     * 
     * @param username <code>java.lang.String</code>
     * @return notifications. <code>java.util.List</code> object  
     *  
     */
    @Override
    public List<NotificationBean> getTopNotification(String username) {
        List<NotificationBean> notifications = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select top 7 Notification.*\n"
                    + "from Notification where Username = ? \n"
                    + "ORDER BY Time desc\n";

            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                NotificationBean noti = new NotificationBean();
                noti.setNotificationID(rs.getInt("NotificationID"));
                noti.setTitle(rs.getString("Title"));
                noti.setContent(rs.getString("Content"));
                noti.setTimeCreate(rs.getDate("Time"));
                noti.setRead(rs.getBoolean("Readed"));
                noti.setLinkDirect(rs.getString("Link_direct"));
                notifications.add(noti);
            }
            /*Close all the connection */

        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return notifications;
    }
    
    /**
     * getTopNotification method
     * This method Get all Subject available from database
     * 
     * @param username <code>java.lang.String</code>
     * @return notifications. <code>java.util.List</code> object  
     *  
     */
    @Override
    public List<NotificationBean> getNotification(int index, int amount, String username ) {
        List<NotificationBean> notifications = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Notification.*\n"
                    + "from Notification where Username = ? \n"
                    + "ORDER BY Time desc\n"
                    + "OFFSET ? ROWS \n" 
                    + "FETCH NEXT ? ROWS ONLY;";

            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setInt(2, index);
            statement.setInt(3, amount);
            
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                NotificationBean noti = new NotificationBean();
                noti.setNotificationID(rs.getInt("NotificationID"));
                noti.setTitle(rs.getString("Title"));
                noti.setContent(rs.getString("Content"));
                noti.setTimeCreate(rs.getDate("Time"));
                noti.setRead(rs.getBoolean("Readed"));
                noti.setLinkDirect(rs.getString("Link_direct"));
                notifications.add(noti);
            }
            /*Close all the connection */

        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return notifications;
    }
    
    /**
     * insertNotification method
     * This method will insert new Notification into database
     * 
     * @param noti  Notification which wanted to insert. <code>Bean.NotificationBean</code> object
     * @return affected row <code>java.lang.Integer</code>
     *  
     */
    @Override
    public int insertNotification(NotificationBean noti) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection(); // get connection to database
            String sql = "Insert into Notification([Username], [Title], [Content], [Time], [Readed], [Link_direct]) values (?, ?, ?, GETDATE(), ?, ?)";
            statement = conn.prepareStatement(sql);
            /* set parameter for query*/
            statement.setString(1, noti.getUsername());
            statement.setString(2, noti.getTitle());
            statement.setString(3, noti.getContent());
            statement.setBoolean(4, false);
            statement.setString(5, noti.getLinkDirect());
            
            /*Insert New Notification into Database*/
            totalRow = statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, null);
        }
        return totalRow;
    }
    
    /**
     * getTotalNoti method
     * This method will count notification unread from database
     * 
     * @param username <code>java.lang.String</code>
     * @return total <code>java.lang.Integer</code>
     */
    @Override
    public int getTotalNoti(String username) {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "SELECT COUNT(NotificationID) AS NumberOfNotification FROM Notification WHERE Username = ? ";

            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfNotification");
            }

            /*Close all the connection */
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }
    
    /**
     * getTotalNotiUnread method
     * This method will count notification unread from database
     * 
     * @param username <code>java.lang.String</code>
     * @return total <code>java.lang.Integer</code>
     */
    @Override
    public int getTotalNotiUnread(String username) {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "SELECT COUNT(NotificationID) AS NumberOfNotification FROM Notification WHERE [Readed] = 'false' "
                    + "and Username = ?";

            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfNotification");
            }

            /*Close all the connection */
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }
    
     /**
     * UpdateReadedNotification method
     * This method will set state read of Notification into database
     * 
     * @param username <code>java.lang.String</code>
     * @return total <code>java.lang.Integer</code>
     *  
     */
    @Override
    public int updateReadedNotification(String username) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection(); // get connection to database
            String sql = "Update Notification set [Readed] = ? where Username = ? ";
            statement = conn.prepareStatement(sql);
            /* set parameter for query*/
            statement.setBoolean(1, true);
            statement.setString(2, username);
            
            /*Insert New Notification into Database*/
            totalRow = statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, null);
        }
        return totalRow;
    }

    /**
     * deleteNotification method
     * This method will insert new Notification into database
     * 
     * @param notiId  <code>java.lang.Integer</code> 
     * @return affected row <code>java.lang.Integer</code>
     *  
     */
    @Override
    public int deleteNotification(int notiId) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection(); // get connection to database
            String sql = "Delete from Notification where [NotificationID] = ? ";
            statement = conn.prepareStatement(sql);
            /* set parameter for query*/
            statement.setInt(1, notiId);
            
            /*Insert New Notification into Database*/
            totalRow = statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, null);
        }
        return totalRow;
    }

   

    
}
