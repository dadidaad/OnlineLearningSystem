/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Doan Tu    First Implement
 * 2022-02-23   2.0         Doan Tu    Second Implement
 */
package Dao;

import Bean.SubjectBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find Subject information from database Extend
 * BaseDAO class to call getConnection() method Implement ISubjectDAO Interface
 *
 * @author Doan Tu
 */
public class SubjectDAO extends BaseDAO implements ISubjectDAO {

    /**
     * getAllSubject method implement from ISubjectDAO
     *
     * @return subjects. <code>java.util.ArrayList</code> object
     * @throws java.sql.SQLException
     */
    @Override
    public ArrayList<SubjectBean> getAllSubject() throws SQLException {
        ArrayList<SubjectBean> subjects = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Subject";
            statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of SubjectBean*/
            while (rs.next()) {
                SubjectBean subject = new SubjectBean();
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setDescription(rs.getString("Description"));
                subject.setSubjectImage(rs.getString("SubjectImage"));
                subjects.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            statement.close();
            rs.close();
        }
        return subjects;
    }

    /**
     * getSubjectNames method implement from ISubjectDAO
     *
     * @return subjectNames. <code>java.util.Map</code> object
     */
    @Override
    public Map<Integer, String> getSubjectNames() {
        Map<Integer, String> subjectNames = new HashMap<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Subject";
            PreparedStatement statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

            /*Assign data to an arraylist of SubjectBean*/
            while (rs.next()) {
                subjectNames.put(rs.getInt("SubjectID"), rs.getString("SubjectName"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectNames;
    }
    /**
     * getNumberOfSubject method implement from ISubjectDAO 
     * This method count number of Subject available in database
     * 
     * @return numberOfSubjects. <code>java.lang.Integer</code>
     */
    @Override
    public int getNumberOfSubject() {
        int numberOfSubject = 0;
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select COUNT(*) as Number from Subject";
            PreparedStatement statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

            /*Assign data to numberOfSubject Integer Type*/
            while (rs.next()) {
                numberOfSubject = rs.getInt("Number");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfSubject;
    }

    /**
     * searchBySubName method.
     * This method check whether A Subject Name has existed in database
     * 
     * @param subName. Name of subject which wanted to check <code>java.lang.Strring</code>
     * @return check. <code>java.lang.Boolean</code>
     */
    @Override
    public boolean searchBySubName(String subName) {
        boolean check = true;
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Subject where SubjectName=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, subName);
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                check = false;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    /**
     * createNewSubject method
     * This method will insert new Subject into database
     * 
     * @param subject. Subject which wanted to insert. <code>Bean.SubjectBean</code> object
     * @return numberOfRows. <code>java.lang.Integer</code>
     */
    @Override
    public int createNewSubject(SubjectBean subject) {
        int numberOfRow = 0;
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "Insert into Subject(SubjectName, Description, SubjectImage)"
                    + "values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, subject.getSubjectName());
            statement.setString(2, subject.getDescription());
            statement.setString(3, subject.getSubjectImage());

            /*Insert New Subject into Database*/
            numberOfRow = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfRow;
    }

    /**
     * getSubjectById method
     * This method will get the Subject with corresponding ID
     * 
     * @param subId. Id of Subject want to get
     * @return subject. <code>Bean.SubjectBean</code> object
     */
    @Override
    public SubjectBean getSubjectById(int subId) {
        SubjectBean subject = new SubjectBean();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Subject where SubjectID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, subId);
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

            /*Assign data to an arraylist of SubjectBean*/
            while (rs.next()) {
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setDescription(rs.getString("Description"));
                subject.setSubjectImage(rs.getString("SubjectImage"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    }

    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDAO();
        SubjectBean s = new SubjectBean(10, "Modern physics", "Modern physics is a branch of physics that developed \n"
                + "in the early 20th century and onward or branches greatly influenced by early \n"
                + "20th century physics.", "assets/image/ModernPhysics.jpg");

        int number = dao.createNewSubject(s);
        
        SubjectBean subject = dao.getSubjectById(1);
        System.out.println(subject);
    }

}
