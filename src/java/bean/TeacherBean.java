/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System
 * Teacher Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * The class contains information attribute about Teacher Model and Account Model
 * All attributes are declare in private cvImg, subjectId and all the attributes of Account
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Duc Minh
 */
public class TeacherBean extends AccountBean{
    private String cvImg;
    private int subjectId;
    private String statusApply;
    private double reputation;

       
    /**
     * Initialization method
     * 
     * @param cvImg the username of student sent request. <code>java.lang.String</code> object
     * @param subjectId the subjectId of teacher. <code>java.lang.Integer</code> object
     * @param username the username of teacher. <code>java.lang.String</code> object
     * @param createdDate the time when account has create. <code>java.lang.Date</code> object
     * @param dateOfBirth the birthday of teacher. <code>java.lang.Date</code> object
     * @param mail the mail of teacher. <code>java.lang.String</code> object
     * @param avatar the avatar of teacher. <code>java.lang.String</code> object
     * @param displayName the displayName of teacher. <code>java.lang.String</code> object
     * @param sex the sex of teacher. <code>java.lang.Boolean</code> object
     * @param description the description of teacher. <code>java.lang.String</code> object
     * @param cash the cash money of teacher. <code>java.lang.String</code> object
     * @param status the status of Account. <code>java.lang.String</code> object
     * @param role the role of the Account. <code>java.lang.Integer</code> object
     * @param state the state of the Teacher. <code>java.lang.Boolean</code> object
     * @param status the state of the Teacher. <code>java.lang.Boolean</code> object
     * @param statusApply the state of the Teacher. <code>java.lang.String</code> object
     * @param reputation the state of the Teacher. <code>java.lang.Double</code> object
    
     */
    public TeacherBean() {
    }

    public TeacherBean(String cvImg, int subjectId, String statusApply, double reputation) {
        this.cvImg = cvImg;
        this.subjectId = subjectId;
        this.statusApply = statusApply;
        this.reputation = reputation;
    }
    public TeacherBean(String username, String cvImg, int subjectId, String statusApply, double reputation) {
        super.setUsername(username);
        this.cvImg = cvImg;
        this.subjectId = subjectId;
        this.statusApply = statusApply;
        this.reputation = reputation;
    }
    
    /**
     * The method used to print the attribute values of Teacher
     * 
     * @return <code>java.lang.String</code> object
     */
    @Override
    public String toString() {
        return super.toString() + "TeacherBean{" + "cvImg=" + cvImg + ", subjectId=" + subjectId + '}';
    }

    /**
     * CvImg's data retrieval method
     * 
     * @return cvImg. <code>java.lang.String</code> object
     */
    public String getCvImg() {
        return cvImg;
    }

    /**
     * Set value for cvImg
     * 
     * @param cvImg.  <code>java.lang.String</code> object
     */
    public void setCvImg(String cvImg) {
        this.cvImg = cvImg;
    }
    
    /**
     * subjectId's data retrieval method
     * 
     * @return subjectId. <code>java.lang.Integer</code> object
     */
    public int getSubjectId() {
        return subjectId;
    }

     /**
     * Set value for subjectId
     * 
     * @param subjectId.  <code>java.lang.Integer</code> object
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * StatusApply's data retrieval method
     * 
     * @return subjectId. <code>java.lang.String</code> object
     */
    public String getStatusApply() {
        return statusApply;
    }
    
    /**
     * Set value for StatusApply
     * 
     * @param subjectId.  <code>java.lang.String</code> object
     */
    public void setStatusApply(String statusApply) {
        this.statusApply = statusApply;
    }

    /**
     * Reputation's data retrieval method
     * 
     * @return reputation. <code>java.lang.Double</code> object
     */
    public double getReputation() {
        return reputation;
    }
    /**
     * Set value for Reputation
     * 
     * @param reputation.  <code>java.lang.Double</code> object
     */
    public void setReputation(double reputation) {
        this.reputation = reputation;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TeacherBean) {
            TeacherBean another = (TeacherBean) obj;
            if (this.cvImg.equals(another.cvImg) 
                    && this.statusApply.equals(another.statusApply) 
                    && this.getUsername().equals(another.getUsername())
                    && this.subjectId == another.subjectId             
                    && this.reputation==another.reputation){
                    return true;
            }
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }
}
