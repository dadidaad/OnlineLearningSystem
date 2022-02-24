/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface IKnowledgeDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 */
package Dao;

import Bean.KnowledgeBean;
import java.util.ArrayList;

/**
 * This is the interface class that declares the methods to access the data of the Knowledge object
 * Abstract method getByChapterId used to get knowledges with corresponding Chapter ID
 * 
 * @author Doan Tu
 */
public interface IKnowledgeDAO {
    /**
     * getByChapterId method implement from IKnowledgeDAO
     * 
     * @param chapId ID of Chapter which Knowledge belongs. <code>java.lang.Intege</code>
     * @return knowledges. <code>java.util.ArrayList</code> object
     */
    public ArrayList<KnowledgeBean> getByChapterId(int chapId);// Get all Knowledge with coresponding ChapterID
}
