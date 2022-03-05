/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface ISubjectDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Doan Tu    First Implement
 * 2022-02-24   2.0         Doan Tu    Second Implement
 */
package dao;

import bean.SubjectBean;
import java.sql.SQLException;
import java.util.List;
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
     * getAllSubject method
     * This method Get all Subject available from database
     * 
     * @return subjects. <code>java.util.List</code> object  
     * @throws java.sql.SQLException  
     */
    public List<SubjectBean> getAllSubject() throws SQLException; //Lisst all Subject from database
    
    /**
     * getSubjectNames method 
     * 
     * @return subjectNames. <code>java.util.Map</code> object
     */
    public Map<Integer, String> getSubjectNames();//Lisst all and hash ID and Name of Subject from database
    
    /**
     * getNumberOfSubject method. 
     * This method count number of Subject available in database
     * 
     * @return numberOfSubjects. <code>java.lang.Integer</code>
     */
    public int getNumberOfSubject();
    
    /**
     * searchBySubName method.
     * This method check whether A Subject Name has existed in database
     * 
     * @param subName. Name of subject which wanted to check <code>java.lang.Strring</code>
     * @return check. <code>java.lang.Boolean</code>
     */
    public boolean searchBySubName(String subName);
    
    /**
     * createNewSubject method
     * This method will insert new Subject into database
     * 
     * @param subject. Subject which wanted to insert. <code>Bean.SubjectBean</code> object
     * @return numberOfRows. <code>java.lang.Integer</code>
     */
    public int createNewSubject(SubjectBean subject);
    
    /**
     * getSubjectById method
     * This method will get the Subject with corresponding ID
     * 
     * @param subId. Id of Subject want to get
     * @return subject. <code>Bean.SubjectBean</code> object
     */
    public SubjectBean getSubjectById(int subId);
}
