/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.ConstantBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Vu
 */
public class ConstantDAO extends BaseDAO implements IConstantDAO {

    @Override
    public ArrayList<ConstantBean> getAllConstant() {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Constant";
            PreparedStatement statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return constants;
    }

    @Override
    public ArrayList<ConstantBean> getByConstantName(String constantName) {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Constant where ConstantName like N'%" + constantName + "%'";
            PreparedStatement statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return constants;
    }

    @Override
    public ArrayList<ConstantBean> getBySignOrConvention(String sign) {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Constant where [Sign] like N'%" + sign + "%' or ReadingConvention like N'%" +sign + "%'";
            PreparedStatement statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return constants;
    }

    

    @Override
    public ArrayList<ConstantBean> getByNameAndSign(String name, String sign) {
        ArrayList<ConstantBean> constants = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Constant where "
                    + "ConstantName like N'%" + name + "%' "
                    + "and ([Sign] like N'%" +sign + "%'"
                    + "or ReadingConvention like N'%" + sign + "%')";
            PreparedStatement statement = conn.prepareStatement(sql);

            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConstantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return constants;
    }
    
    public static void main(String[] args) {
        ConstantDAO dao = new ConstantDAO();
        ArrayList<ConstantBean> c = dao.getByNameAndSign("chAn KhONg", "ePsi");
        System.out.println(c);
    }
}
