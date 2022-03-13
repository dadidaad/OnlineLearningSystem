/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RecommendBean;
import static dao.BaseDAO.close;
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
public class RecommendDAO extends BaseDAO implements IRecommendDAO {

    @Override
    public int createRecommend(RecommendBean recommend) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int numberOfRow = 0;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "Insert into RecommendKnowledge(Username, SubjectID, Action, RecDescription, Status)"
                    + "values(?,?,?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, recommend.getUsername());
            statement.setInt(2, recommend.getSubjectID());
            statement.setBoolean(3, recommend.isAction());
            statement.setString(4, recommend.getDescription());
            statement.setString(5, recommend.getStatus());

            /*Querry and save in ResultSet*/
            numberOfRow = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecommendDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw (ex);
        } finally {
            close(conn, statement, rs);
        }
        return numberOfRow;
    }

    @Override
    public ArrayList<RecommendBean> getByUsername(String username) throws SQLException {
        ArrayList<RecommendBean> recommends = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            /*Set up connection and Sql statement for Querry*/

            String sql = "Select * from RecommendKnowledge where Username=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);

            rs = statement.executeQuery();

            while (rs.next()) {
                RecommendBean recommend = new RecommendBean();
                recommend.setRecommendID(rs.getInt("RecID"));
                recommend.setUsername(rs.getString("Username"));
                recommend.setSubjectID(rs.getInt("SubjectID"));
                recommend.setAction(rs.getBoolean("Action"));
                recommend.setDescription(rs.getString("RecDescription"));
                recommend.setStatus(rs.getString("Status"));

                recommends.add(recommend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecommendDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw (ex);
        } finally {
            close(conn, statement, rs);
        }
        return recommends;
    }

    @Override
    public int numberOfAccept(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int number=0;
        try{
            String sql;
            conn = getConnection();
            sql="select COUNT(*) as Number from RecommendKnowledge where Username=? and Status =?";
            
            statement=conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, "accept");
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                number = rs.getInt("Number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecommendDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw (ex);
        } finally {
            close(conn, statement, rs);
        }
        return number;
    }
    
    @Override
    public int numberOfDecline(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int number=0;
        try{
            conn = getConnection();
            String sql="select COUNT(*) as Number from RecommendKnowledge where Username=? and Status =?";
            statement=conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, "decline");
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                number = rs.getInt("Number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecommendDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw (ex);
        } finally {
            close(conn, statement, rs);
        }
        return number;
    }

    @Override
    public ArrayList<RecommendBean> getByAction(boolean action) throws SQLException {
        ArrayList<RecommendBean> recommends = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            /*Set up connection and Sql statement for Querry*/

            String sql = "Select * from RecommendKnowledge where Action=?";
            statement = conn.prepareStatement(sql);
            statement.setBoolean(1, action);

            rs = statement.executeQuery();

            while (rs.next()) {
                RecommendBean recommend = new RecommendBean();
                recommend.setRecommendID(rs.getInt("RecID"));
                recommend.setUsername(rs.getString("Username"));
                recommend.setSubjectID(rs.getInt("SubjectID"));
                recommend.setAction(rs.getBoolean("Action"));
                recommend.setDescription(rs.getString("RecDescription"));
                recommend.setStatus(rs.getString("Status"));

                recommends.add(recommend);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecommendDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw (ex);
        } finally {
            close(conn, statement, rs);
        }
        return recommends;
    }

    @Override
    public int changeStatus(String status, int RecId) throws SQLException {
        int numberOfRows=0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            conn= getConnection();
            String sql ="Update RecommendKnowledge Set "
                    + "Status = ? "
                    + "Where RecID=? ";
            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, RecId);
            
            numberOfRows = statement.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(RecommendDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw (ex);
        } finally {
            close(conn, statement, rs);
        }
        return numberOfRows;
    }

    public static void main(String[] args) throws SQLException {
        RecommendDAO dao = new RecommendDAO();
        dao.changeStatus("random", 1);
    }
}
