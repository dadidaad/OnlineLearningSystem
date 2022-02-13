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
    public ArrayList<SubjectBean> getAllSubject(); //Lisst all Subject from database
    public Map<Integer, String> getSubjectNames();//Lisst all and hash ID and Name of Subject from database
}
