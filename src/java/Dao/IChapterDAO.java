/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface IChpaterDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 */
package Dao;

import Bean.ChapterBean;
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
     * getAllSubject method implement from IChapterDAO
     * 
     * @param subId ID of Subject which Chapter belongs <code>java.lang.Integer</code> object
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    public ArrayList<ChapterBean> getBySubId(int subId); //Get All Chapter with coresponding SubjectID
    
    /**
     * getChapterById method implement from IChapterDAO
     * 
     * @param chapId ID of the Chapter. <code>java.lang.Integer</code> object
     * @return chapter <code>Bean.ChapterBean</code> object
     */
    public ChapterBean getChapterById(int chapId);//Get all Chapter with coresponding ChapterID
}
