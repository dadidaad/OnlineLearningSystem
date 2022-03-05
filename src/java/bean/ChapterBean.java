/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Chapter Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Doan Tu    First Implement
 */

package bean;

/**
 * The class contains information attribute about Chapter Model
 * All attributes are declare in private chapterID, chapterName, semester, chapterContent subjectID
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Doan Tu
 */
public class ChapterBean {
    private int chapterID;
    private String chapterName;
    private int semester;
    private String chapterContent;
    private int subjectID;

    public ChapterBean() {
    }

    /**
     * Initialization method
     * 
     * @param chapterID the ID of Chapter. <code>java.lang.Integer</code> object
     * @param chapterName the Name of Chapter. <code>java.lang.String</code> object
     * @param semester the semester of Chapter. <code>java.lang.Integer</code> object
     * @param chapterContent the Content of Chapter. <code>java.lang.String</code> object
     * @param subjectID the subject id which chapter belongs. <code>java.lang.Integer</code> object
     */
    public ChapterBean(int chapterID, String chapterName, int semester, String chapterContent, int subjectID) {
        this.chapterID = chapterID;
        this.chapterName = chapterName;
        this.semester = semester;
        this.chapterContent = chapterContent;
        this.subjectID = subjectID;
    }
    
    /**
     * ChapterID's data retrieval method
     * 
     * @return chapterID. <code>java.lang.Integer</code> object
     */
    public int getChapterID() {
        return chapterID;
    }

    /**
     * Set value for chapterID
     * 
     * @param chapterID.  <code>java.lang.Integer</code> object
     */
    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }

    /**
     * ChapterName's data retrieval method
     * 
     * @return chapterName. <code>java.lang.String</code> object
     */
    public String getChapterName() {
        return chapterName;
    }

    /**
     * Set value for chapterName
     * 
     * @param chapterName .  <code>java.lang.String</code> object
     */
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    /**
     * semester's data retrieval method
     * 
     * @return semester. <code>java.lang.Integer</code> object
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Set value for semester
     * 
     * @param semester.  <code>java.lang.Integer</code> object
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * ChapterContent's data retrieval method
     * 
     * @return chapterContent. <code>java.lang.String</code> object
     */
    public String getChapterContent() {
        return chapterContent;
    }

    /**
     * Set value for chapterContent
     * 
     * @param chapterContent .  <code>java.lang.String</code> object
     */
    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    /**
     * SubjectID's data retrieval method
     * 
     * @return subjectID. <code>java.lang.Integer</code> object
     */
    public int getSubjectID() {
        return subjectID;
    }

    /**
     * Set value for subjectID
     * 
     * @param subjectID .  <code>java.lang.Integer</code> object
     */
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    /**
     * The method used to print the attribute values of Chapter
     * 
     * @return <code>java.lang.String</code> object
     */
    @Override
    public String toString() {
        return "ChapterBean{" + "chapterID=" + chapterID + ", chapterName=" + chapterName + ", semester=" + semester + ", chapterContent=" + chapterContent + ", subjectID=" + subjectID + '}';
    }
    
    
}
