/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System
 * Notification Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-07   1.0         Duc Minh    First Implement
 */
package bean;

import java.sql.Date;

/**
 * The class contains information attribute about Notification Model 
 * All attributes are declare in private NotificationID, Username, Content, Time
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Duc Minh
 */
public class NotificationBean {
    private int notificationID;
    private String username;
    private String title;
    private String content;
    private Date timeCreate;
    private boolean read;
    private String linkDirect;

    public NotificationBean() {
    //default constructor
    }

    /**
     * Initialization method
     * 
     * @param username the username of Notification. <code>java.lang.String</code> object
     * @param title the title of Notification. <code>java.lang.String</code> object
     * @param content the content of Notification. <code>java.lang.String</code> object
     * 
     */
    public NotificationBean(String username, String title, String content) {    
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public NotificationBean(String username, String title, String content, String linkDirect) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.linkDirect = linkDirect;
    }
    

    /**
     * Get notificationID's data retrieval method
     *
     * @return notificationID. <code>java.lang.Integer</code> object 
     */
    public int getNotificationID() {
        return notificationID;
    }

    /**
     * Set value for notificationID
     * 
     * @param notificationID. <code>java.lang.Integer</code> object 
     */
    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    /**
     * Get username's data retrieval method
     * 
     * @return username. <code>java.lang.String</code> object 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set value for notificationID
     * 
     * @param username. <code>java.lang.String</code> object 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get content's data retrieval method
     * 
     * @return content. <code>java.lang.String</code> object 
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value for content
     * 
     * @param content. <code>java.lang.String</code> object 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get TimeCreate's data retrieval method
     * 
     * @return timeCreate. <code>java.sql.Date</code> object 
     */
    public Date getTimeCreate() {
        return timeCreate;
    }

    /**
     * Set value for timecreate
     * 
     * @param timeCreate. <code>java.sql.Date</code> object 
     */
    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }
    
    /**
     * Get title's data retrieval method
     * 
     * @return title. <code>java.lang.String</code> object 
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Set value for title
     * 
     * @param title. <code>java.lang.String</code> object 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get read status of data retrieval method
     * 
     * @return read. <code>java.lang.Boolean</code> object 
     */
    public boolean isRead() {
        return read;
    }
    
    /**
     * Set value for read
     * 
     * @param read. <code>java.lang.Boolean</code> object 
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * Get read linkDirect of data retrieval method
     * 
     * @return linkDirect. <code>java.lang.String</code> object 
     */
    public String getLinkDirect() {
        return linkDirect;
    }

    /**
     * Set value for linkDirect
     * 
     * @param linkDirect. <code>java.lang.String</code> object 
     */
    public void setLinkDirect(String linkDirect) {
        this.linkDirect = linkDirect;
    }
    
    

    @Override
    public String toString() {
        return "NotificationBean{" + "notificationID=" + notificationID + ", username=" + username + ", title=" + title + ", content=" + content + ", timeCreate=" + timeCreate + ", read=" + read + '}';
    }

     
    
}
