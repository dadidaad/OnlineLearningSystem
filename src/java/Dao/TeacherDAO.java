/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Duc Minh    First Implement
 */

package Dao;

import Bean.TeacherBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find Teacher information from database
 * Extend BaseDAO class to call getConnection() method
 * Implement ITeacherDAO Interface
 * 
 * @author Duc Minh
 */
public class TeacherDAO extends BaseDAO implements ITeacherDAO{

    /**
     * getAllTeacher method implement from ITeacherDAO
     * 
     * @return teachers. <code>java.util.ArrayList</code> object  
     */
    @Override
    public ArrayList<TeacherBean> getAllTeacher() {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select Account.*,Tutor.*\n" +
                        "from Account, Tutor\n" +
                "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status= 'approved'";
            PreparedStatement statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();
            
            /*Assign data to an arraylist of Request*/
            while(rs.next())
            {
                TeacherBean teacher = new TeacherBean();
                
                teacher.setUsername(rs.getString("Username"));
                teacher.setPassword(rs.getString("Password"));
                teacher.setMail(rs.getString("Mail"));
                teacher.setAvatar(rs.getString("Avatar"));
                teacher.setDisplayName(rs.getString("DisplayName"));
                teacher.setDateOfBirth(rs.getDate("DateOfBirth"));
                teacher.setSex(rs.getBoolean("Sex"));
                teacher.setDescription(rs.getString("Description"));
                teacher.setCash(rs.getBigDecimal("Cash in account"));
                teacher.setCreateDate(rs.getDate("CreatedDate"));
                teacher.setRole(rs.getString("Role"));
                teacher.setStatus(rs.getString("Status"));
                teacher.setState(rs.getBoolean("State"));
                teacher.setCvImg(rs.getString("CV"));
                teacher.setSubjectId(rs.getInt("SubjectID"));
                        
                teachers.add(teacher);
            }
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teachers;
    }
    
    
    /**
     * getSubjectId method implement from ITeacherDAO
     * get the id subject of teacher from database
     * @return subjectId. <code>Integer</code> object  
     */

    @Override
    public int getSubjectId(String usernameTeacher) {
        int subjectId = 0;
        try {
             /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Tutor\n" +
                    "where Username = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, usernameTeacher);
            /*Excuse Query*/
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                subjectId = rs.getInt("SubjectID");
            }
            /*Close all the connection */
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectId;
    }

    /**
     * getTeacherBySearching method implement from ITeacherDAO
     * 
     * @return teachers. <code>java.util.ArrayList</code> object  
     */
    @Override
    public ArrayList<TeacherBean> getTeacherBySearching(String searchString) {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select Account.*,Tutor.*, Subject.SubjectName\n" +
                    "from Account, Tutor, Subject \n" +
                    "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status= 'approved' and \n" +
                    "Tutor.SubjectID = Subject.SubjectID and (DisplayName like ? or Subject.SubjectName like ? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, "%"+searchString + "%");
            statement.setString(2, "%"+searchString + "%");
            
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();
            
            /*Assign data to an arraylist of Request*/
            while(rs.next())
            {
                TeacherBean teacher = new TeacherBean();
                
                teacher.setUsername(rs.getString("Username"));
                teacher.setPassword(rs.getString("Password"));
                teacher.setMail(rs.getString("Mail"));
                teacher.setAvatar(rs.getString("Avatar"));
                teacher.setDisplayName(rs.getString("DisplayName"));
                teacher.setDateOfBirth(rs.getDate("DateOfBirth"));
                teacher.setSex(rs.getBoolean("Sex"));
                teacher.setDescription(rs.getString("Description"));
                teacher.setCash(rs.getBigDecimal("Cash in account"));
                teacher.setCreateDate(rs.getDate("CreatedDate"));
                teacher.setRole(rs.getString("Role"));
                teacher.setStatus(rs.getString("Status"));
                teacher.setState(rs.getBoolean("State"));
                teacher.setCvImg(rs.getString("CV"));
                teacher.setSubjectId(rs.getInt("SubjectID"));
                        
                teachers.add(teacher);
            }
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teachers;
    }
    public static void main(String[] args) {
        TeacherDAO dal = new TeacherDAO();
        ArrayList<TeacherBean> list = dal.getTeacherBySearching("Mat");
        for(TeacherBean t : list){
            System.out.println(t);
        }
    }
}
