/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface ISubjectDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Duc Minh    First Implement
 */
package dao;

import bean.TeacherBean;
import java.util.ArrayList;

/**
 * This is the interface class that declares the methods to access the data of
 * the Teacher object Abstract method getAllTeacher used to retrieve all
 * teachers
 *
 *
 * @author Duc Minh
 */
public interface ITeacherDAO {

    /**
     * getAllTeacher method implement from ITeacherDAO
     *
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getAllTeacher(int pageindex, int pagesize);

    /**
     * getAllOnlineTeacher method implement from ITeacherDAO
     *
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getAllOnlineTeacher(int pageindex, int pagesize);

    /**
     * getTeacherByUsername method implement from ITeacherDAO
     *
     * @param username <code>java.lang.String</code>
     * @return teacher <code>Bean.TeacherBean</code> object 
     */
    public TeacherBean getTeacherByUsername(String username);

    /**
     * getTeacherCV method implement from ITeacherDAO
     *
     * @param username <code>java.lang.String</code>
     * @return teacher <code>Bean.TeacherBean</code> object 
     */
    public TeacherBean getTeacherCV(String username);

    /**
     * UpdateNewTeacher method implement from ITeacherDAO
     *
     * @param teacher <code>Bean.TeacherBean</code> object 
     * @return boolean
     */
    public boolean UpdateNewTeacher(TeacherBean teacher);

    /**
     * getTeacherStatus method implement from ITeacherDAO check status cv of
     * teacher in db
     *
     * @param username <code>java.lang.String</code>
     * @return boolean 
     */
    public boolean getTeacherStatus(String username);

    /**
     * getSubjectId method implement from ITeacherDAO get the id subject of
     * teacher from database
     *
     * @param usernameTeacher <code>java.lang.String</code>
     * @return subjectId. <code>java.lang.Integer</code>
     */

    public int getSubjectId(String usernameTeacher);

    /**
     * getTeacherBySearching method implement from ITeacherDAO
     *
     * @param searchString <code>java.lang.String</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getTeacherBySearching(String searchString);

    /**
     * getTeacherBySearching method implement from ITeacherDAO
     *
     * @param searchString <code>java.lang.String</code>
     * @param subjectId <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getTeacherBySearching(String searchString, int subjectId);

    /**
     * insertNewTeacher method implement from ITeacherDAO
     *
     * @param teacher<code>java.util.TeacherBean</code> object
     * @return boolean. <code>java.lang.Boolean</code> object
     */
    public boolean insertNewTeacher(TeacherBean teacher);

    /**
     * getTotalTeacherApply method implement from ITeacherDAO
     *
     * @param status <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code>
     */
    public int getTotalTeacherApply(String status);

    /**
     * getTotalTeacherApply method implement from ITeacherDAO
     *
     * @return total. <code>java.lang.Integer</code>
     */
    public int getTotalTeacherApply();

    /**
     * getAllTeacherApply method implement from ITeacherDAO
     *
     * @param status <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getAllTeacherApply(String status, int pageindex, int pagesize);

    /**
     * getAllTeacherApply method implement from ITeacherDAO
     *
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getAllTeacherApply(int pageindex, int pagesize);

    /**
     * handleTeacherApply method implement from ITeacherDAO
     *
     * @param username <code>java.lang.String</code>
     * @param status <code>java.lang.String</code>
     *
     * @return number of row. <code>java.lang.Integer</code> object
     */
    public int handleTeacherApply(String username, String status);

    /**
     * getTotalTeacher method implement from ITeacherDAO
     *
     * @return total. <code>java.lang.Integer</code> object
     */
    public int getTotalTeacher();

    /**
     * getTotalOnlineTeacher method implement from ITeacherDAO
     *
     * @return total. <code>java.lang.Integer</code> object
     */
    public int getTotalOnlineTeacher();

    /**
     * totalTeacherSearch method implement from ITeacherDAO
     *
     * @param searchString <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object
     */
    public int getTotalTeacherSearch(String searchString);

    /**
     * getAllTeacherBySearch method implement from ITeacherDAO
     *
     * @param searchString <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getTeacherBySearching(String searchString, int pageindex, int pagesize);

    /**
     * getTopTeacher method implement from ITeacherDAO
     *
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getTopTeacher();

    /**
     * getTop3Teacher method implement from ITeacherDAO
     *
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getTop3Teacher();

    /**
     * getTotalTeacherApplySearch method implement from ITeacherDAO
     *
     * @param searchString <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object
     */
    public int getTotalTeacherApplySearch(String searchString);

    /**
     * getTotalTeacherApplySearch method implement from ITeacherDAO
     *
     * @param status <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object
     */
    public int getTotalTeacherApplySearch(String status, String searchString);

    /**
     * getAllTeacherBySearch method implement from ITeacherDAO
     *
     * @param searchString <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getTeacherApplyBySearching(String searchString, int pageindex, int pagesize);

    /**
     * getAllTeacherBySearch method implement from ITeacherDAO
     *
     * @param status <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    public ArrayList<TeacherBean> getTeacherApplyBySearching(String status, String searchString, int pageindex, int pagesize);
}
