/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface IKnowledgeDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 * 2022-02-25   2.0         Doan Tu    Second Implement 
 * 2022-03-08   3.0         Doan Tu    Third Implement
 */
package dao;

import bean.KnowledgeBean;
import java.sql.SQLException;
import java.util.ArrayList;

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
     * @return knowledges. <code>java.util.ArrayList</code> object
     * @throws java.sql.SQLException
     */
    public ArrayList<KnowledgeBean> getByChapterId(int chapId) throws SQLException;// Get all Knowledge with coresponding ChapterID
    
    /**
     * getNumberOfKnowledgeByChapterId method
     * This method will count number of all Knowledge with corresponding ChapterID
     * 
     * @param chapId. Id of Chapter which wanted to get Knowledge. <code>java.lang.String</code> object
     * @return numberOfKnowledge. <code>java.lang.Intege</code> Object
     * @throws java.sql.SQLException
     */
    public int getNumberOfKnowledgeByChpaterId(int chapId)throws SQLException;
    
    /**
     * getNumberOfKnowledge method
     * This method will count All Knowledge Available in database
     * 
     * @return numberOfKnowledge. <code>java.lang.Intege</code> Object
     * @throws java.sql.SQLException
     */
    public int getNumbberOfKnowledge() throws SQLException;
    
    /**
     * createKnowledge Method
     * This method will insert new Knowledge into database
     * 
     * @param knowledge. Knowledge which we want to insert into database
     * @return numberOfRow. <code>java.lang.Intege</code> Object
     * @throws java.sql.SQLException
     */
    public int createKnowledge(KnowledgeBean knowledge) throws SQLException;
    
    /**
     * searchByKnowledgeNameOfChap method
     * This method will get Knowledge which has corresponding knowledgeName, and Chapter ID 
     * 
     * @param knowledgeName. Name Of Knowledge we want to search.<code>java.lang.String</code> Object
     * @param chapId. Id of chapter. <code>java.lang.Intege</code> Object
     * @return check. <code>java.lang.Boolean</code> Object
     * @throws java.sql.SQLException
     */
    public boolean searchByKnowledgeNameOfChap(String knowledgeName, int chapId) throws SQLException;
    public KnowledgeBean getKnowledgeById(int knowledgeID) throws SQLException;
    public int updateKnowledge(KnowledgeBean knowledge) throws SQLException;
    public int deleteKnowledgeById(int knowledgeId) throws SQLException;
}
