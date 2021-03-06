/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface IChpaterDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 * 2022-02-24   2.0         Doan Tu    Second Implement
 * 2022-03-07   3.0         Doan Tu    Third Implement
 */
package dao;

import bean.ChapterBean;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the interface class that declares the methods to access the data of the Chapter object
 * Abstract method getBySubId used to get chapters with corresponding Subject ID
 * abstract method getChapterById is used to get Chapters with ID passed in
 * 
 * @author Doan Tu
 */
public interface IChapterDAO {
    /**
     * getAllSubject method 
     * This method will get All Chapter with corresponding Subject ID
     * 
     * @param subId ID of Subject which Chapter belongs <code>java.lang.Integer</code> object
     * @return chapters. <code>java.util.ArrayList</code> object
     * @throws java.sql.SQLException
     */
    public ArrayList<ChapterBean> getBySubId(int subId) throws SQLException; //Get All Chapter with coresponding SubjectID
    
    /**
     * getChapterById method
     * This method will get All Chapter with corresponding Chapter ID
     * 
     * @param chapId ID of the Chapter. <code>java.lang.Integer</code> object
     * @return chapter <code>Bean.ChapterBean</code> object
     * @throws java.sql.SQLException
     */
    public ChapterBean getChapterById(int chapId) throws SQLException;//Get all Chapter with coresponding ChapterID
    
    /**
     * getNumberOfChapterById method
     * This method count number of Chapter available in database with corresponding Subject ID
     * 
     * @param subId. Id of Subject. <code>java.lang.Integer</code> object
     * @return numberOfChapter. <code>java.lang.Integer</code> object
     * @throws java.sql.SQLException
     */
    public int getNumberOfChapterById(int subId) throws SQLException;
    
    /**
     * getNumberOfChapter method
     * This method count number of Chapter available in database
     * 
     * @return numberOfChapter. <code>java.lang.Integer</code> object
     * @throws java.sql.SQLException
     */
    public int getNumberOfChapter() throws SQLException;
    
    /**
     * searchByChapNameOfSubject method
     * This method will check whether the ChapterName with corresponding ID has existed in database
     * 
     * @param chapName. Name of Chapter <code>java.lang.String</code> object
     * @param subId. Id of Subject <code>java.lang.Integer</code> object
     * @return check. <code>java.lang.Boolean</code> object
     * @throws java.sql.SQLException
     */
    public boolean searchByChapNameOfSubject(String chapName, int subId) throws SQLException;
    
    /**
     * CreateChapter method
     * This method will insert new Chapter in database
     * 
     * @param chapter. New Chapter which wanted to insert. <code>Bean.ChapterBean</code> object
     * @return numberOfRows. <code>java.lang.Integer</code> object
     * @throws java.sql.SQLException
     */
    public int CreateChapter(ChapterBean chapter) throws SQLException;
    
    /**
     * updateChapter method
     * This method will update Chapter with corresponding chapter iD
     * 
     * @param chapter <code>bean.ChapterBean</code>
     * @return numberOfRowaffected <code>java.lang.Integer</code> object
     * @throws SQLException 
     */
    public int updateChapter(ChapterBean chapter) throws SQLException;
    
    /**
     * searchByChapName method
     * This method will check whether The chapter name has exist in database
     * 
     * @param chapName <code>java.lang.String</code> object
     * @return check. <code>java.lang.Boolean</code> object
     * @throws SQLException 
     */
    public boolean searchByChapName(String chapName) throws SQLException;
    
    /**
     * deleteChapterById method
     * This method will delete Chapter with corresponding chapterID
     * 
     * @param chapId <code>java.lang.Integer</code> object
     * @return numberOfRowaffected <code>java.lang.Integer</code> object
     * @throws SQLException 
     */
    public int deleteChapterById(int chapId) throws SQLException;
}
