/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Knowledge Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 */
package bean;

/**
 * The class contains information attribute about Knowledge Model
 * All attributes are declare in private knowledgeID, knowledgeName, knowledgeContent and chapterID
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Doan Tu
 */
public class KnowledgeBean {
    private int knowledgeID;
    private String knowledgeName;
    private String knowledgeContent;
    private int chapterID;

    public KnowledgeBean() {
    }
    
    /**
     * Initialization method
     * 
     * @param knowledgeID the Id of Knowledge. <code>java.lang.Integer</code> object
     * @param knowledgeName the Name of Knowledge. <code>java.lang.String</code> object
     * @param knowledgeContent the Content of Knowledge. <code>java.lang.String</code> object
     * @param chapterID ID of the chapter to which knowledge belongs. <code>java.lang.Integer</code> object
     */
    public KnowledgeBean(int knowledgeID, String knowledgeName, String knowledgeContent, int chapterID) {
        this.knowledgeID = knowledgeID;
        this.knowledgeName = knowledgeName;
        this.knowledgeContent = knowledgeContent;
        this.chapterID = chapterID;
    }
    
    /**
     * knowledgeID's data retrieval method
     * 
     * @return knowledgeID. <code>java.lang.Integer</code> object
     */
    public int getKnowledgeID() {
        return knowledgeID;
    }

    /**
     * Set value for knowledgeID
     * 
     * @param knowledgeID. <code>java.lang.Integer</code> object 
     */
    public void setKnowledgeID(int knowledgeID) {
        this.knowledgeID = knowledgeID;
    }

    /**
     * knowledgeName's data retrieval method
     * 
     * @return knowledgeName. <code>java.lang.String</code> object
     */
    public String getKnowledgeName() {
        return knowledgeName;
    }

    /**
     * Set value for knowledgeName
     * 
     * @param knowledgeName . <code>java.lang.String</code> object 
     */
    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    /**
     * knowledgeContent's data retrieval method
     * 
     * @return knowledgeContent. <code>java.lang.String</code> object
     */
    public String getKnowledgeContent() {
        return knowledgeContent;
    }

    /**
     * Set value for knowledgeContent
     * 
     * @param knowledgeContent . <code>java.lang.String</code> object 
     */
    public void setKnowledgeContent(String knowledgeContent) {
        this.knowledgeContent = knowledgeContent;
    }

    /**
     * ChpaterID's data retrieval method
     * 
     * @return chapterID. <code>java.lang.Integer</code> object
     */
    public int getChapterID() {
        return chapterID;
    }

    /**
     * Set value for ChapterID
     * 
     * @param chapterID . <code>java.lang.Integer</code> object 
     */
    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }

    /**
     * The method used to print the attribute values of Knowledge
     * 
     * @return <code>java.lang.String</code> object
     */
    @Override
    public String toString() {
        return "KnowledgeBean{" + "knowledgeID=" + knowledgeID + ", knowledgeName=" + knowledgeName + ", knowledgeContent=" + knowledgeContent + ", chapterID=" + chapterID + '}';
    }
    
    
}
