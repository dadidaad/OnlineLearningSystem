/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface IKnowledgeDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 * 2022-02-25   2.0         Doan Tu    Second Implement 
 */
package dao;

import bean.KnowledgeBean;
import java.util.List;

/**
 * This is the interface class that declares the methods to access the data of the Knowledge object
 * Abstract method getByChapterId used to get knowledges with corresponding Chapter ID
 * 
 * @author Doan Tu
 */
public interface IKnowledgeDAO {
    /**
     * getByChapterId method 
     * This method will get all Knowledge with corresponding ChapterId 
     * 
     * @param chapId ID of Chapter which Knowledge belongs. <code>java.lang.Intege</code>
     * @return knowledges. <code>java.util.List</code> object
     */
    public List<KnowledgeBean> getByChapterId(int chapId);// Get all Knowledge with coresponding ChapterID
    
    /**
     * getNumberOfKnowledgeByChapterId method
     * This method will count number of all Knowledge with corresponding ChapterID
     * 
     * @param chapId. Id of Chapter which wanted to get Knowledge. <code>java.lang.String</code> object
     * @return numberOfKnowledge. <code>java.lang.Intege</code> Object
     */
    public int getNumberOfKnowledgeByChpaterId(int chapId);
    
    /**
     * getNumberOfKnowledge method
     * This method will count All Knowledge Available in database
     * 
     * @return numberOfKnowledge. <code>java.lang.Intege</code> Object
     */
    public int getNumbberOfKnowledge();
    
    /**
     * createKnowledge Method
     * This method will insert new Knowledge into database
     * 
     * @param knowledge. Knowledge which we want to insert into database
     * @return numberOfRow. <code>java.lang.Intege</code> Object
     */
    public int createKnowledge(KnowledgeBean knowledge);
    
    /**
     * searchByKnowledgeNameOfChap method
     * This method will get Knowledge which has corresponding knowledgeName, and Chapter ID 
     * 
     * @param knowledgeName. Name Of Knowledge we want to search.<code>java.lang.String</code> Object
     * @param chapId. Id of chapter. <code>java.lang.Intege</code> Object
     * @return check. <code>java.lang.Boolean</code> Object
     */
    public boolean searchByKnowledgeNameOfChap(String knowledgeName, int chapId);
}
