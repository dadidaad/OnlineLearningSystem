/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ConstantDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-22   2.0         Doan Tu    First Implement
 */
package dao;

import bean.ConstantBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find Constant information from database Extend
 * BaseDAO class to call getConnection() method Implement IConstantDAO Interface
 *
 * @author Doan Tu
 */
public class ConstantDAO extends BaseDAO implements IConstantDAO {


    /**
     * getAllConstant() method implement from IConstantDAO
     *
     * @return constants. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<ConstantBean> getAllConstant() {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Constant";
            statement = conn.prepareStatement(sql);
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of ChapterBean*/
            while (rs.next()) {
                ConstantBean c = new ConstantBean();
                c.setConstantID(rs.getInt("ConstantID"));
                c.setConstantName(rs.getString("ConstantName"));
                c.setValue(rs.getString("Value"));
                c.setUnit(rs.getString("Unit"));
                c.setSign(rs.getString("Sign"));
                c.setReadingConvention(rs.getString("ReadingConvention"));
                c.setDescription(rs.getString("Description"));
                constants.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return constants;
    }

    /**
     * getByConstantName method implement from IConstantDAO
     *
     * @param constantName, <code>java.lang.String</code> object
     * @return constants. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<ConstantBean> getByConstantName(String constantName) {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Constant where ConstantName like N'%" + constantName + "%'";
            statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of ChapterBean*/
            while (rs.next()) {
                ConstantBean c = new ConstantBean();
                c.setConstantID(rs.getInt("ConstantID"));
                c.setConstantName(rs.getString("ConstantName"));
                c.setValue(rs.getString("Value"));
                c.setUnit(rs.getString("Unit"));
                c.setSign(rs.getString("Sign"));
                c.setReadingConvention(rs.getString("ReadingConvention"));
                c.setDescription(rs.getString("Description"));
                constants.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return constants;
    }

    /**
     * getBySignOrConvention method implement from IConstantDAO
     *
     * @param sign. <code>java.lang.String</code> object
     * @return <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<ConstantBean> getBySignOrConvention(String sign) {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Constant where [Sign] like N'%" + sign + "%' or ReadingConvention like N'%" + sign + "%'";
            statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of ChapterBean*/
            while (rs.next()) {
                ConstantBean c = new ConstantBean();
                c.setConstantID(rs.getInt("ConstantID"));
                c.setConstantName(rs.getString("ConstantName"));
                c.setValue(rs.getString("Value"));
                c.setUnit(rs.getString("Unit"));
                c.setSign(rs.getString("Sign"));
                c.setReadingConvention(rs.getString("ReadingConvention"));
                c.setDescription(rs.getString("Description"));
                constants.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return constants;
    }

    /**
     * getByNameAndSign method implement from IConstantDAO
     *
     * @param name. <code>java.lang.String</code> object
     * @param sign. <code>java.lang.String</code> object
     * @return <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<ConstantBean> getByNameAndSign(String name, String sign) {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Constant where "
                    + "ConstantName like N'%" + name + "%' "
                    + "and ([Sign] like N'%" + sign + "%'"
                    + "or ReadingConvention like N'%" + sign + "%')";
            statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of ChapterBean*/
            while (rs.next()) {
                ConstantBean c = new ConstantBean();
                c.setConstantID(rs.getInt("ConstantID"));
                c.setConstantName(rs.getString("ConstantName"));
                c.setValue(rs.getString("Value"));
                c.setUnit(rs.getString("Unit"));
                c.setSign(rs.getString("Sign"));
                c.setReadingConvention(rs.getString("ReadingConvention"));
                c.setDescription(rs.getString("Description"));
                constants.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return constants;
    }
    
}
