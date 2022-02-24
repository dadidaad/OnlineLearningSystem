/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface ISubjectDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 */
package Dao;

import Bean.SubjectBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the interface class that declares the methods to access the data of the Subject object
 * Abstract method getAllSubject used to retrieve all subjects
 * Abstract method getSubjectNames used to retrieve all Name of subject with corresponding ID
 * 
 * @author Doan Tu
 */

public interface ISubjectDAO {
    /**
     * getAllSubject method implement from ISubjectDAO
     * 
     * @return subjects. <code>java.util.ArrayList</code> object  
     * @throws java.sql.SQLException  
     */
    public ArrayList<SubjectBean> getAllSubject() throws SQLException; //Lisst all Subject from database
    
    /**
     * getSubjectNames method implement from ISubjectDAO
     * 
     * @return subjectNames. <code>java.util.Map</code> object
     */
    public Map<Integer, String> getSubjectNames();//Lisst all and hash ID and Name of Subject from database
}
