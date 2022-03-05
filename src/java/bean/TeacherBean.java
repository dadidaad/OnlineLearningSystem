/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System
 * Teacher Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package bean;

/**
 * The class contains information attribute about Teacher Model and Account
 * Model All attributes are declare in private cvImg, subjectId and all the
 * attributes of Account Get set methods used to retrieve data The toString
 * method is overridden to print the data
 *
 * @author Duc Minh
 */
public class TeacherBean extends AccountBean {

    private String cvImg;
    private int subjectId;
    private String statusApply;

    public TeacherBean() {
    }

    public TeacherBean(String cvImg, int subjectId, String statusApply) {
        this.cvImg = cvImg;
        this.subjectId = subjectId;
        this.statusApply = statusApply;
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

}
