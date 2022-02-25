/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System
 * Request Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */

package Bean;
import java.sql.Date;

/**
 * The class contains information attribute about Request Model
 * All attributes are declare in private requestID, studentSent, tutorGet, createdTime, status, cost, content, imageLink, subjectID, level, title
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Duc Minh
 */

public class RequestBean {
    private int requestID;
    private String studentSent;
    private String tutorGet;
    private Date createdTime;
    private String status;
    private int cost;
    private String content;
    private String imageLink;
    private int subjectID;
    private int level;
    private String title;

    public RequestBean() {
    }

    /**
     * Initialization method
     * 
     * @param requestID the username of student sent request. <code>java.lang.String</code> object
     * @param studentSent the username of student sent request. <code>java.lang.String</code> object
     * @param tutorGet the teacher has recommend in Request. <code>java.lang.String</code> object
     * @param createdTime the time when request has create. <code>java.lang.Date</code> object
     * @param status the status of Request. <code>java.lang.String</code> object
     * @param cost the price of the Request. <code>java.lang.Integer</code> object
     *  @param content the content of the Request. <code>java.lang.String</code> object
     *  @param imageLink the image's link of the Request. <code>java.lang.Integer</code> object
     *  @param subjectID the subject id of the Request. <code>java.lang.Integer</code> object
     *  @param level the grade of the Request. <code>java.lang.Integer</code> object
     *  @param title the title of the Request. <code>java.lang.Integer</code> object
     */
    public RequestBean(int requestID, String studentSent, String tutorGet, Date createdTime, String status, int cost,
            String content, String imageLink, int subjectID, int level, String title) {
        this.requestID = requestID;
        this.studentSent = studentSent;
        this.tutorGet = tutorGet;
        this.createdTime = createdTime;
        this.status = status;
        this.cost = cost;
        this.content = content;
        this.imageLink = imageLink;
        this.subjectID = subjectID;
        this.level = level;
        this.title = title;
    }

    
    /**
     * The method used to print the attribute values of Request
     * 
     * @return <code>java.lang.String</code> object
     */
    @Override
    public String toString() {
        return "RequestBean{" + "requestID=" + requestID + ", studentSent=" + studentSent + ", tutorGet=" + tutorGet + ", createdTime=" + createdTime + ", status=" + status + ", cost=" + cost + ", content=" + content + ", imageLink=" + imageLink + ", subjectID=" + subjectID + ", level=" + level + ", title=" + title + '}';
    }

  
     /**
     * RequestID's data retrieval method
     * 
     * @return requestID. <code>java.lang.Integer</code> object
     */
    public int getRequestID() {
        return requestID;
    }

    /**
     * Set value for requestID
     * 
     * @param requestID.  <code>java.lang.Integer</code> object
     */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    /**
     * studentSent's data retrieval method
     * 
     * @return studentSent. <code>java.lang.String</code> object
     */
    public String getStudentSent() {
        return studentSent;
    }

    /**
     * Set value for studentSent
     * 
     * @param studentSent.  <code>java.lang.String</code> object
     */
    public void setStudentSent(String studentSent) {
        this.studentSent = studentSent;
    }

    /**
     * tutorGet's data retrieval method
     * 
     * @return tutorGet. <code>java.lang.String</code> object
     */
    public String getTutorGet() {
        return tutorGet;
    }

    /**
     * Set value for tutorGet
     * 
     * @param tutorGet.  <code>java.lang.String</code> object
     */
    public void setTutorGet(String tutorGet) {
        this.tutorGet = tutorGet;
    }

    /**
     * createdTime's data retrieval method
     * 
     * @return createdTime. <code>java.lang.Date</code> object
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * Set value for createdTime
     * 
     * @param createdTime.  <code>java.lang.Date</code> object
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Status's data retrieval method
     * 
     * @return status. <code>java.lang.String</code> object
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set value for status
     * 
     * @param status.  <code>java.lang.String</code> object
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Cost's data retrieval method
     * 
     * @return cost. <code>java.lang.Integer</code> object
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * Set value for cost
     * 
     * @param cost.  <code>java.lang.Integer</code> object
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Content's data retrieval method
     * 
     * @return content. <code>java.lang.String</code> object
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value for content
     * 
     * @param content.  <code>java.lang.String</code> object
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * imageLink's data retrieval method
     * 
     * @return imageLink. <code>java.lang.String</code> object
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     * Set value for imageLink
     * 
     * @param imageLink.  <code>java.lang.String</code> object
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    /**
     * subjectID's data retrieval method
     * 
     * @return content. <code>java.lang.String</code> object
     */
    public int getSubjectID() {
        return subjectID;
    }
    
    /**
     * Set value for subjectID
     * 
     * @param subjectID.  <code>java.lang.Integer</code> object
     */
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    /**
     * Title's data retrieval method
     * 
     * @return title. <code>java.lang.String</code> object
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Set value for title
     * 
     * @param title.  <code>java.lang.String</code> object
     */
    public void setTitle(String title) {
        this.title = title;
    }

  
    /**
     * Level's data retrieval method
     * 
     * @return level. <code>java.lang.Integer</code> object
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * Set value for level
     * 
     * @param level.  <code>java.lang.Integer</code> object
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
