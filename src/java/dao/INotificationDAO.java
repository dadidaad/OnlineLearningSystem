/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface INotificationDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-8   1.0         Duc Minh    First Implement
 */
package dao;

import bean.NotificationBean;
import java.util.List;

/**
 * This is the interface class that declares the methods to access the data of the Notification object
 * Abstract method getAllSubject used to retrieve all subjects
 * Abstract method getSubjectNames used to retrieve all Name of subject with corresponding ID
 *
 * @author Duc Minh
 */
public interface INotificationDAO {
    
    /**
     * getAllSubject method
     * This method Get all Subject available from database
     * 
     * @return notifications. <code>java.util.List</code> object  
     *  
     */
    public List<NotificationBean> getTopNotification(String username); //get 7 latest Notification from database
    
    /**
     * getAllSubject method
     * This method Get all Subject available from database
     * 
     * @return notifications. <code>java.util.List</code> object  
     *  
     */
    public List<NotificationBean> getNotification(int index, int amount, String username); //get 7 latest Notification from database
    
    /**
     * insertNotification method
     * This method will insert new Notification into database
     * 
     * @param noti  Notification which wanted to insert. <code>Bean.NotificationBean</code> object
     * @return 
     *  
     */
    public int insertNotification(NotificationBean noti); //Insert new Notification to database
    
    /**
     * getTotalNoti method
     * This method will count notification unread from database
     * 
     * @param username <code>java.lang.String</code>
     * @return total <code>java.lang.Integer</code>
     */
    public int getTotalNoti(String username); //get total Notification from database
    
    /**
     * getTotalNotiUnread method
     * This method will count notification unread from database
     * 
     * @param username <code>java.lang.String</code>
     * @return total <code>java.lang.Integer</code>
     */
    public int getTotalNotiUnread(String username); //get total Notification from database
    
    /**
     * UpdateReadedNotification method
     * This method will set state read of Notification into database
     * 
     * @param username <code>java.lang.String</code>
     * @return total <code>java.lang.Integer</code>
     *  
     */
    public int updateReadedNotification(String username); //Insert new Noti to database
    
    /**
     * insertNotification method
     * This method will insert new Notification into database
     * 
     * @param notiId  <code>java.lang.Integer</code> 
     * @return 
     *  
     */
    public int deleteNotification(int notiId); //delete Notification to database
}
