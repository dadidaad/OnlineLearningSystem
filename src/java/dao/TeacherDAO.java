/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * TeacherDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Duc Minh    First Implement
 */
package dao;

import bean.TeacherBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find Teacher information from database Extend
 * BaseDAO class to call getConnection() method Implement ITeacherDAO Interface
 *
 * @author Duc Minh
 */
public class TeacherDAO extends BaseDAO implements ITeacherDAO {

    /**
     * getAllTeacher method implement from ITeacherDAO
     *
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getAllTeacher(int pageindex, int pagesize) {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Account.*, t.*\n"
                    + "from Account, (select Tutor.*, ROW_NUMBER() OVER (ORDER BY Tutor.Reputation desc) as r from Tutor where Tutor.[Status]='Approved') as t\n"
                    + "where Account.Username = t.Username and Account.[Role] = 'Teacher' and t.[Status] = 'Approved' and r between ? and ?";
            statement = conn.prepareStatement(sql);

            statement.setInt(1, (pageindex - 1) * pagesize);
            statement.setInt(2, pagesize*pageindex-1);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));

                teachers.add(teacher);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    /**
     * getAllTeacher method implement from ITeacherDAO
     *
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getAllOnlineTeacher(int pageindex, int pagesize) {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Account.*, t.*\n"
                    + "from Account, (select Tutor.*, ROW_NUMBER() OVER (ORDER BY Tutor.Reputation desc) as r from Tutor) as t\n"
                    + "where Account.Username = t.Username and Account.[Role] = 'Teacher' and t.[Status] = 'Approved' and Account.[State] = 1 and r between ? and ?";
            statement = conn.prepareStatement(sql);

            statement.setInt(1, (pageindex - 1) * pagesize);
            statement.setInt(2, pagesize);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));

                teachers.add(teacher);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    /**
     * getTeacherByUsername method implement from ITeacherDAO
     * @param  username <code>java.lang.String</code>
     * @return teacher <code>Bean.TeacherBean</code> object 
     */
    @Override
    public TeacherBean getTeacherByUsername(String username) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Account.*,Tutor.*\n"
                    + "from Account, Tutor\n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.[Username] = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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

                return teacher;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return null;
    }

    /**
     * checkTeacherStatus method implement from ITeacherDAO
     *
     * @param username <code>java.lang.String</code>
     * @return teacher <code>Bean.TeacherBean</code> object 
     */
    @Override
    public boolean getTeacherStatus(String username) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Tutor.*\n"
                    + "from Tutor\n"
                    + "where Tutor.[Username] = ? and Tutor.[Status] = 'Waiting'";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return false;
    }

    /**
     * getTeacherCV method implement from ITeacherDAO
     *
     * @param username <code>java.lang.String</code>
     * @return teacher <code>Bean.TeacherBean</code> object 
     */
    @Override
    public TeacherBean getTeacherCV(String username) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Tutor.*\n"
                    + "from Tutor\n"
                    + "where Tutor.[Username] = ? and Tutor.[Status] = 'Waiting'";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                TeacherBean teacher = new TeacherBean();

                teacher.setUsername(rs.getString("Username"));
                teacher.setStatus(rs.getString("Status"));
                teacher.setCvImg(rs.getString("CV"));
                teacher.setSubjectId(rs.getInt("SubjectID"));
                teacher.setReputation(rs.getDouble("Reputation"));
                return teacher;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return null;
    }

    /**
     * getSubjectId method implement from ITeacherDAO get the id subject of
     * teacher from database
     *
     * @param usernameTeacher <code>java.lang.String</code>
     * @return subjectId. <code>java.lang.Integer</code>
     */
    @Override
    public int getSubjectId(String usernameTeacher) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int subjectId = 0;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select *\n"
                    + "from Tutor\n"
                    + "where Username = ? ";
            statement = conn.prepareStatement(sql);

            statement.setString(1, usernameTeacher);
            /*Excuse Query*/
            rs = statement.executeQuery();

            while (rs.next()) {
                subjectId = rs.getInt("SubjectID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return subjectId;
    }

    /**
     * getTeacherBySearching method implement from ITeacherDAO
     * @param searchString <code>java.lang.String</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getTeacherBySearching(String searchString) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select top 10 Account.*,Tutor.*, Subject.SubjectName\n"
                    + "from Account, Tutor, Subject \n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status = 'Approved' and \n"
                    + "Tutor.SubjectID = Subject.SubjectID and (DisplayName like ? or Subject.SubjectName like ? ) order by Tutor.Reputation desc ";
            statement = conn.prepareStatement(sql);

            statement.setString(1, "%" + searchString + "%");
            statement.setString(2, "%" + searchString + "%");

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    /**
     * insertNewTeacher method implement from ITeacherDAO
     *
     * @param teacher <code>Bean.TeacherBean</code> object 
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public boolean insertNewTeacher(TeacherBean teacher) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        TeacherBean getTeacherFromDb = getTeacherByUsername(teacher.getUsername()); // check if exists in db, if yes return false
        if (getTeacherFromDb != null) {
            return false;
        }
        try {
            String sql = "Insert into Tutor (Username, CV, SubjectID) values (?, ?, ?)"; //sql query
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, teacher.getUsername());
            statement.setString(2, teacher.getCvImg());
            statement.setInt(3, teacher.getSubjectId());
            int result = statement.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return false;
    }

    /**
     * updateNewTeacher method implement from ITeacherDAO
     *
     * @param teacher <code>Bean.TeacherBean</code> object 
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public boolean UpdateNewTeacher(TeacherBean teacher) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE [dbo].[Tutor]\n"
                    + "   SET [CV] = ?\n"
                    + "      ,[SubjectID] = ?\n"
                    + " WHERE [Username] = ?"; //sql query
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, teacher.getCvImg());
            statement.setInt(2, teacher.getSubjectId());
            statement.setString(3, teacher.getUsername());
            int result = statement.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return false;
    }

    /**
     * getAllTeacherApply method implement from ITeacherDAO
     *
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getAllTeacherApply(int pageindex, int pagesize) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select a.*, Tutor.*\n"
                    + "from (select Account.*, ROW_NUMBER() OVER (ORDER BY CreatedDate) as e from Account) as a, Tutor\n"
                    + "where a.Username = Tutor.Username and  a.[Role] ='Teacher' and Tutor.[Status] != 'Waiting' and e between ? and ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, (pageindex - 1) * pagesize);
            statement.setInt(2, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setStatusApply(rs.getString(17));
                teachers.add(teacher);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    /**
     * getAllTeacherApply method implement from ITeacherDAO
     *
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getAllTeacherApply(String status, int pageindex, int pagesize) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select a.*, Tutor.*\n"
                    + "from (select Account.*, ROW_NUMBER() OVER (ORDER BY CreatedDate) as e from Account) as a, Tutor\n"
                    + "where a.Username = Tutor.Username and  a.[Role] ='Teacher' and Tutor.[Status] = ? and e between ? and ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, (pageindex - 1) * pagesize);
            statement.setInt(3, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setStatusApply(rs.getString(17));
                teachers.add(teacher);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    /**
     * getTotalTeacherApply method implement from IAccountDAO
     *
     * @return total <code>java.lang.Integer</code>.
     */
    @Override
    public int getTotalTeacherApply() {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select COUNT(Account.Username) AS NumberOfAccount  \n"
                    + "from Account, Tutor\n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status != 'Waiting' \n";

            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * getTotalTeacherApply method implement from IAccountDAO
     *
     * @return total <code>java.lang.Integer</code>.
     */
    @Override
    public int getTotalTeacherApply(String status) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select COUNT(Account.Username) AS NumberOfAccount  \n"
                    + "from Account, Tutor\n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status = ? \n";

            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * handleTeacherApply method implement from ITeacherDAO accept and change
     * status apply of teacher from database
     *
     * @return number of row has affected. <code>Integer</code> object
     */
    @Override
    public int handleTeacherApply(String username, String status) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int numberOfRow = 0;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "Update Tutor set Status = ? "
                    + "Where Username = ? ";

            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setString(2, username);


            /*Insert New Subject into Database*/
            numberOfRow = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return numberOfRow;
    }

    /**
     * getTotalTeacher method implement from IAccountDAO
     *
     * @return total <code>java.lang.Integer</code>
     */
    @Override
    public int getTotalTeacher() {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select count(Account.Username) as NumberOfAccount \n"
                    + "from Account, Tutor\n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.[Status] = 'Approved'";

            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }

            /*Close all the connection */
           
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * getTotalOnlineTeacher method implement from IAccountDAO
     *
     * @return total <code>java.lang.Integer</code>
     */
    @Override
    public int getTotalOnlineTeacher() {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select count(Account.Username) as NumberOfAccount \n"
                    + "from Account, Tutor\n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.[Status] = 'Approved' and Account.State = 1";

            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }
            
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * totalTeacherSearch method implement from ITeacherDAO
     *
     * @param searchString <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object
     */
    @Override
    public int getTotalTeacherSearch(String searchString) {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select count(Account.Username) as NumberOfAccount \n"
                    + "from Account, Tutor, Subject \n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status = 'Approved' and \n"
                    + "Tutor.SubjectID = Subject.SubjectID and (DisplayName like ? or Subject.SubjectName like ? )";
            statement = conn.prepareStatement(sql);

            statement.setString(1, "%" + searchString + "%");
            statement.setString(2, "%" + searchString + "%");

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * getAllTeacherBySearch method implement from ITeacherDAO
     *
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getTeacherBySearching(String searchString, int pageindex, int pagesize) {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Account.*, t.*, [Subject].SubjectName\n"
                    + "from Account, (select Tutor.*, ROW_NUMBER() OVER (ORDER BY Tutor.Reputation desc) as r from Tutor) as t,[Subject]\n"
                    + "where Account.Username = t.Username and Account.[Role] = 'Teacher' and t.[Status] = 'Approved' and t.SubjectID = [Subject].SubjectID and (Account.DisplayName like ? or [Subject].SubjectName like ? or Account.Mail like ?) and r between ? and ?";
            statement = conn.prepareStatement(sql);

            statement.setString(1, "%" + searchString + "%");
            statement.setString(2, "%" + searchString + "%");
            statement.setString(3, "%" + searchString + "%");
            statement.setInt(4, (pageindex - 1) * pagesize);
            statement.setInt(5, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));

                teachers.add(teacher);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    @Override
    public ArrayList<TeacherBean> getTeacherBySearching(String searchString, int subjectId) {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select top 10 Account.*,Tutor.*, Subject.SubjectName\n"
                    + "from Account, Tutor, Subject \n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status = 'Approved' and \n"
                    + "Tutor.SubjectID = Subject.SubjectID and (DisplayName like ? or Subject.SubjectName like ? or Account.Mail like ?) and Tutor.SubjectID = ? \n"
                    + "order by Tutor.Reputation desc";
            statement = conn.prepareStatement(sql);

            statement.setString(1, "%" + searchString + "%");
            statement.setString(2, "%" + searchString + "%");
            statement.setString(3, "%" + searchString + "%");
            statement.setInt(4, subjectId);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));

                teachers.add(teacher);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    @Override
    public ArrayList<TeacherBean> getTopTeacher() {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select top 10 Account.*,Tutor.*, Subject.SubjectName\n"
                    + "from Account, Tutor, Subject \n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status = 'Approved' and \n"
                    + "Tutor.SubjectID = Subject.SubjectID  \n"
                    + "order by Tutor.Reputation desc";
            statement = conn.prepareStatement(sql);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));

                teachers.add(teacher);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    @Override
    public ArrayList<TeacherBean> getTop3Teacher() {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select top 3 Account.*,Tutor.*, Subject.SubjectName\n"
                    + "from Account, Tutor, Subject \n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status = 'Approved' and \n"
                    + "Tutor.SubjectID = Subject.SubjectID  \n"
                    + "order by Tutor.Reputation desc";
            statement = conn.prepareStatement(sql);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));

                teachers.add(teacher);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    @Override
    public int getTotalTeacherApplySearch(String searchString) {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select count(Account.Username) as NumberOfAccount \n"
                    + "from Account, Tutor,Subject \n"
                    + "where Account.Username = Tutor.Username and Tutor.SubjectID = Subject.SubjectID and Account.[Role] ='Teacher' and Tutor.Status != 'Waiting' \n"
                    + "and (DisplayName like ? or Subject.SubjectName like ? or Account.Mail like ?)";
            statement = conn.prepareStatement(sql);

            statement.setString(1, "%" + searchString + "%");
            statement.setString(2, "%" + searchString + "%");
            statement.setString(3, "%" + searchString + "%");

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    @Override
    public int getTotalTeacherApplySearch(String status, String searchString) {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select count(Account.Username) as NumberOfAccount \n"
                    + "from Account, Tutor,Subject \n"
                    + "where Account.Username = Tutor.Username and Tutor.SubjectID = Subject.SubjectID and Account.[Role] ='Teacher' and Tutor.Status = ? \n"
                    + "and (Account.DisplayName like ? or Subject.SubjectName like ? or Account.Mail like ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setString(2, "%" + searchString + "%");
            statement.setString(3, "%" + searchString + "%");
            statement.setString(4, "%" + searchString + "%");

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * getAllTeacherApply method implement from ITeacherDAO
     *
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getTeacherApplyBySearching(String status, String searchString, int pageindex, int pagesize) {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select a.*, Tutor.*\n"
                    + "from (select Account.*, ROW_NUMBER() OVER (ORDER BY CreatedDate) as e from Account) as a, Tutor, Subject \n"
                    + "where a.Username = Tutor.Username and  a.[Role] ='Teacher' and Tutor.[Status] = ?\n"
                    + "and Tutor.SubjectID = [Subject].SubjectID and (a.DisplayName like ? or [Subject].SubjectName like ? or a.Mail like ?)\n"
                    + "and e between ? and ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setString(2, "%" + searchString + "%");
            statement.setString(3, "%" + searchString + "%");
            statement.setString(4, "%" + searchString + "%");
            statement.setInt(5, (pageindex - 1) * pagesize);
            statement.setInt(6, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));
                teacher.setStatusApply("Waiting");
                teachers.add(teacher);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }

    /**
     * getAllTeacherApply method implement from ITeacherDAO
     *
     * @return teachers. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<TeacherBean> getTeacherApplyBySearching(String searchString, int pageindex, int pagesize) {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select a.*, Tutor.*\n"
                    + "from (select Account.*, ROW_NUMBER() OVER (ORDER BY CreatedDate) as e from Account) as a, Tutor, Subject \n"
                    + "where a.Username = Tutor.Username and  a.[Role] ='Teacher' and Tutor.[Status] != 'Waiting'\n"
                    + "and Tutor.SubjectID = [Subject].SubjectID and (a.DisplayName like ? or [Subject].SubjectName like ? or a.Mail like ?)\n"
                    + "and e between ? and ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchString + "%");
            statement.setString(2, "%" + searchString + "%");
            statement.setString(3, "%" + searchString + "%");
            statement.setInt(4, (pageindex - 1) * pagesize);
            statement.setInt(5, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
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
                teacher.setReputation(rs.getDouble("Reputation"));
                teacher.setStatusApply("Waiting");
                teachers.add(teacher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return teachers;
    }
  
}
