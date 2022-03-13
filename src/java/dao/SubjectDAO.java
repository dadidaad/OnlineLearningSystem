/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Doan Tu    First Implement
 * 2022-02-23   2.0         Doan Tu    Second Implement
 */
package dao;

import bean.SubjectBean;
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
            throw(ex);
        } finally {
            close(conn, statement, rs);
        }
        return subjects;
    }

    /**
     * getSubjectNames method implement from ISubjectDAO
     *
     * @return subjectNames. <code>java.util.Map</code> object
     * @throws java.sql.SQLException
     */
    @Override
    public Map<Integer, String> getSubjectNames() throws SQLException {
        Map<Integer, String> subjectNames = new HashMap<>();
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Subject";
            statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of SubjectBean*/
            while (rs.next()) {
                subjectNames.put(rs.getInt("SubjectID"), rs.getString("SubjectName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
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
    public int getNumberOfSubject() throws SQLException {
        int numberOfSubject = 0;
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select COUNT(*) as Number from Subject";
            statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to numberOfSubject Integer Type*/
            while (rs.next()) {
                numberOfSubject = rs.getInt("Number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
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
    public boolean searchBySubName(String subName) throws SQLException{
        boolean check = true;
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Subject where SubjectName=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, subName);
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            while (rs.next()) {
                check = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
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
    public int createNewSubject(SubjectBean subject) throws SQLException {
        int numberOfRow = 0;
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "Insert into Subject(SubjectName, Description, SubjectImage)"
                    + "values(?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, subject.getSubjectName());
            statement.setString(2, subject.getDescription());
            statement.setString(3, subject.getSubjectImage());

            /*Insert New Subject into Database*/
            numberOfRow = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
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
    public SubjectBean getSubjectById(int subId) throws SQLException {
        SubjectBean subject = new SubjectBean();
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Subject where SubjectID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, subId);
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of SubjectBean*/
            while (rs.next()) {
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setDescription(rs.getString("Description"));
                subject.setSubjectImage(rs.getString("SubjectImage"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return subject;
    }
    /**
     * updateSubject Method implement from ISubjectDAO
     * this method will Update a subject with the corresponding subjectID
     * 
     * @param subject <code>Bean.SubjectBean</code> object
     * @return numberOfRowAffected. <code>java.lang.Integer</code> object
     * @throws SQLException 
     */
    @Override
    public int updateSubject(SubjectBean subject) throws SQLException {
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        int numberOfRow=0;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "Update Subject\n"
                       + "Set SubjectName=?,\n"
                       + "Description=?,\n"
                       + "SubjectImage=?\n"
                       + "where SubjectID=?\n";
            statement = conn.prepareStatement(sql);
            statement.setString(1, subject.getSubjectName());
            statement.setString(2, subject.getDescription());
            statement.setString(3, subject.getSubjectImage());
            statement.setInt(4, subject.getSubjectID());
            /*Querry and save in ResultSet*/
            numberOfRow = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return numberOfRow;
    }
    
    /**
     * deleteSubject method
     * This method will delete Subject with corresponding SubjectID
     * 
     * @param subId <code>java.lang.Integer</code> object
     * @return numberOfRowAffected. <code>java.lang.Integer</code> object
     * @throws SQLException 
     */
    @Override
    public int deleteSubject(int subId) throws SQLException {
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        int numberOfRow=0;
        
        try{
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "delete from Subject where SubjectID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, subId);
            
            /*Execute SQL and return numberOfRow affect*/
            numberOfRow = statement.executeUpdate();
            
        }catch(SQLException ex){
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return numberOfRow;
    }

}
