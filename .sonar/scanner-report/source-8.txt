/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Request Reply Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package Bean;

import java.sql.Date;

/**
 * The class contains information attribute about Request Reply Model
 * All attributes are declare in private requestID, tutorSent, studentGet, createdTimeReply, contentReply and imageLinkReply
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Duc Minh
 */
public class RequestReplyBean {
    private int requestID;
    private String tutorSent;
    private String studentGet;
    private Date createdTimeReply;
    private String contentReply;
    private String imageLinkReply;

    public RequestReplyBean() {
    }

    public RequestReplyBean(String tutorSent, String studentGet, Date createdTimeReply, String contentReply, String imageLinkReply) {
        this.tutorSent = tutorSent;
        this.studentGet = studentGet;
        this.createdTimeReply = createdTimeReply;
        this.contentReply = contentReply;
        this.imageLinkReply = imageLinkReply;
    }

    public RequestReplyBean(int requestID, String tutorSent, String studentGet, String contentReply, String imageLinkReply) {
        this.requestID = requestID;
        this.tutorSent = tutorSent;
        this.studentGet = studentGet;
        this.contentReply = contentReply;
        this.imageLinkReply = imageLinkReply;
    }
    
    public RequestReplyBean(int requestID, String tutorSent, String studentGet, Date createdTimeReply, String contentReply, String imageLinkReply) {
        this.requestID = requestID;
        this.tutorSent = tutorSent;
        this.studentGet = studentGet;
        this.createdTimeReply = createdTimeReply;
        this.contentReply = contentReply;
        this.imageLinkReply = imageLinkReply;
    }

    @Override
    public String toString() {
        return "RequestReplyBean: " + "requestID=" + requestID + ", tutorSent=" + tutorSent + ", studentGet=" + studentGet + ", createdTimeReply=" + createdTimeReply + ", contentReply=" + contentReply + ", imageLinkReply=" + imageLinkReply + '}';
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getTutorSent() {
        return tutorSent;
    }

    public void setTutorSent(String tutorSent) {
        this.tutorSent = tutorSent;
    }

    public String getStudentGet() {
        return studentGet;
    }

    public void setStudentGet(String studentGet) {
        this.studentGet = studentGet;
    }

    public Date getCreatedTimeReply() {
        return createdTimeReply;
    }

    public void setCreatedTimeReply(Date createdTimeReply) {
        this.createdTimeReply = createdTimeReply;
    }

    public String getContentReply() {
        return contentReply;
    }

    public void setContentReply(String contentReply) {
        this.contentReply = contentReply;
    }

    public String getImageLinkReply() {
        return imageLinkReply;
    }

    public void setImageLinkReply(String imageLinkReply) {
        this.imageLinkReply = imageLinkReply;
    }
    
    
}
