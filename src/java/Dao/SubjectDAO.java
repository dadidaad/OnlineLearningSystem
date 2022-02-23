/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Doan Tu    First Implement
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
 * This class contain method to find Subject information from database
 * Extend BaseDAO class to call getConnection() method
 * Implement ISubjectDAO Interface
 * 
 * @author Doan Tu
 */
public class SubjectDAO extends BaseDAO implements ISubjectDAO{

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
            while(rs.next())
            {
                SubjectBean subject = new SubjectBean();
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setDescription(rs.getString("Description"));
                subject.setSubjectImage(rs.getString("SubjectImage"));
                subjects.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
            while(rs.next())
            {
                subjectNames.put(rs.getInt("SubjectID"), rs.getString("SubjectName"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectNames;
    }
    
}
