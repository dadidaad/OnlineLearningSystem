/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Subject Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Doan Tu    First Implement
 */

package Bean;

/**
 * The class contains information attribute about Subject Model
 * All attributes are declare in private subjectID, subjectName, description and subjectImage
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Doan Tu
 */
public class SubjectBean {
    private int subjectID;
    private String subjectName;
    private String description;
    private String subjectImage;

    public SubjectBean() {
    }

    /**
     * Initialization method
     * 
     * @param subjectID the ID of subject. <code>java.lang.Integer</code> object
     * @param subjectName the Name of subject. <code>java.lang.String</code> object
     * @param description the description of subject. <code>java.lang.String</code> object
     * @param subjectImage the image for illustrate the subject. <code>java.lang.String</code> object
     */
    public SubjectBean(int subjectID, String subjectName, String description, String subjectImage) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.description = description;
        this.subjectImage = subjectImage;
    }
 
    /**
     * Get subjectImage's data retrieval method
     * 
     * @return subjectImage. <code>java.lang.String</code> object 
     */
    public String getSubjectImage() {
        return subjectImage;
    }

    /**
     * Set value for subjectImage
     * 
     * @param subjectImage. <code>java.lang.String</code> object 
     */
    public void setSubjectImage(String subjectImage) {
        this.subjectImage = subjectImage;
    }

    /**
     * Get subjectID's data retrieval method
     * 
     * @return subjectID. <code>java.lang.Integer</code> object 
     */
    public int getSubjectID() {
        return subjectID;
    }

    /**
     * Set value for subjectID
     * 
     * @param subjectID . <code>java.lang.Integer</code> object 
     */
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    /**
     * Get subjectName's data retrieval method
     * 
     * @return subjectName. <code>java.lang.String</code> object 
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Set value for subjectName
     * 
     * @param subjectName . <code>java.lang.String</code> object 
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Get description's data retrieval method
     * 
     * @return description. <code>java.lang.String</code> object 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value for description
     * 
     * @param description . <code>java.lang.String</code> object 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The method used to print the attribute values of Subject
     * 
     * @return <code>java.lang.String</code> object
     */
    @Override
    public String toString() {
        return "SubjectBean{" + "subjectID=" + subjectID + ", subjectName=" + subjectName + ", description=" + description + ", subjectImage=" + subjectImage + '}';
    }



    
}
