/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * KnowledgeDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Doan Tu    First Implement
 * 2022-02-25   2.0         Doan Tu    Second Implement
 */
package dao;

import bean.KnowledgeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class contain method to find Knowledge information from database
 * Extend BaseDAO class to call getConnection() method
 * Implement IKnowledgeDAO Interface
 * 
 * @author Doan Tu
 */
public class KnowledgeDAO extends BaseDAO implements IKnowledgeDAO{

    /**
     * getByChapterId method implement from IKnowledgeDAO
     * 
     * @param chapId ID of Chapter which Knowledge belongs. <code>java.lang.Intege</code>
     * @return knowledges. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<KnowledgeBean> getByChapterId(int chapId) throws SQLException {
        ArrayList<KnowledgeBean> knowledges = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Knowledge where ChapterID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, chapId);
            
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();
            
            /*Assign data to an arraylist of ChapterBean*/
            while(rs.next())
            {
                KnowledgeBean knowledge = new KnowledgeBean();
                knowledge.setKnowledgeID(rs.getInt("KnowledgeID"));
                knowledge.setKnowledgeName(rs.getString("KnowledgeName"));
                knowledge.setKnowledgeContent(rs.getString("Title"));
                knowledge.setChapterID(rs.getInt("ChapterID"));
                
                knowledges.add(knowledge);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return knowledges;
    }

    /**
     * getNumberOfKnowledgeByChapterId method
     * This method will count number of all Knowledge with corresponding ChapterID
     * 
     * @param chapId. Id of Chapter which wanted to get Knowledge. <code>java.lang.String</code> object
     * @return numberOfKnowledge. <code>java.lang.Intege</code> Object
     */
    @Override
    public int getNumberOfKnowledgeByChpaterId(int chapId) throws SQLException {
       int numberOfKnowledge=0;
       Connection conn = null;
       PreparedStatement statement = null;
       ResultSet rs = null;
       try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select COUNT(*) as Number from Knowledge where ChapterID = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, chapId);
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();
            
            /*Assign data to an arraylist of SubjectBean*/
            while(rs.next())
            {
                numberOfKnowledge = rs.getInt("Number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
           close(conn, statement, rs);
       }
        return numberOfKnowledge;
    }

    /**
     * getNumberOfKnowledge method
     * This method will count All Knowledge Available in database
     * 
     * @return numberOfKnowledge. <code>java.lang.Intege</code> Object
     */
    @Override
    public int getNumbberOfKnowledge() throws SQLException {
        int numberOfKnowledge=0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
       try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select COUNT(*) as Number from Knowledge";
            statement = conn.prepareStatement(sql);
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();
            
            /*Assign data to an numberOfKnowledge Integer Type*/
            while(rs.next())
            {
                numberOfKnowledge = rs.getInt("Number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
           close(conn, statement, rs);
       }
        return numberOfKnowledge;
    }
    
    /**
     * createKnowledge Method
     * This method will insert new Knowledge into database
     * 
     * @param knowledge. Knowledge which we want to insert into database
     * @return numberOfRow. <code>java.lang.Intege</code> Object
     */
    @Override
    public int createKnowledge(KnowledgeBean knowledge) throws SQLException {
        int numberOfRow=0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            conn = getConnection();
            String sql = "Insert into Knowledge(KnowledgeName, Title, ChapterID)"
                    + "values(?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, knowledge.getKnowledgeName());
            statement.setString(2, knowledge.getKnowledgeContent());
            statement.setInt(3, knowledge.getChapterID());

            numberOfRow = statement.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return numberOfRow;
    }
    
    /**
     * searchByKnowledgeNameOfChap method
     * This method will get Knowledge which has corresponding knowledgeName, and Chapter ID 
     * 
     * @param knowledgeName. Name Of Knowledge we want to search.<code>java.lang.String</code> Object
     * @param chapId. Id of chapter. <code>java.lang.Intege</code> Object
     * @return check. <code>java.lang.Boolean</code> Object
     */
    @Override
    public boolean searchByKnowledgeNameOfChap(String knowledgeName, int chapId) throws SQLException {
        boolean check = true;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Knowledge where KnowledgeName=? and ChapterID=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, knowledgeName);
            statement.setInt(2, chapId);
            
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            while (rs.next()) {
                check = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return check;
    }

    @Override
    public int updateKnowledge(KnowledgeBean knowledge) throws SQLException {
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        int numberOfRow=0;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "Update Knowledge\n"
                       + "Set KnowledgeName=?,\n"
                       + "Title=?,\n"
                       + "ChapterID=?\n"
                       + "where KnowledgeID=?\n";
            statement = conn.prepareStatement(sql);
            statement.setString(1, knowledge.getKnowledgeName());
            statement.setString(2, knowledge.getKnowledgeContent());
            statement.setInt(3, knowledge.getChapterID());
            statement.setInt(4, knowledge.getKnowledgeID());
            /*Querry and save in ResultSet*/
            numberOfRow = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return numberOfRow;
    }

    @Override
    public KnowledgeBean getKnowledgeById(int knowledgeID) throws SQLException {
        KnowledgeBean knowledge = new KnowledgeBean();
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Knowledge where KnowledgeID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, knowledgeID);
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            /*Assign data to an arraylist of SubjectBean*/
            while (rs.next()) {
                knowledge.setKnowledgeID(rs.getInt("KnowledgeID"));
                knowledge.setKnowledgeName(rs.getString("KnowledgeName"));
                knowledge.setKnowledgeContent(rs.getString("Title"));
                knowledge.setChapterID(rs.getInt("ChapterID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return knowledge;
    }

    @Override
    public int deleteKnowledgeById(int knowledgeId) throws SQLException {
        Connection conn =null;
        PreparedStatement statement=null;
        ResultSet rs =null;
        int numberOfRow=0;
        
        try{
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "delete from Knowledge where KnowledgeID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, knowledgeId);
            
            /*Execute SQL and return numberOfRow affect*/
            numberOfRow = statement.executeUpdate();
            
        }catch(SQLException ex){
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw(ex);
        }finally{
            close(conn, statement, rs);
        }
        return numberOfRow;
    }
    
    public static void main(String[] args) throws SQLException {
       KnowledgeBean k = new KnowledgeDAO().getKnowledgeById(1);
        System.out.println(k);
    }
}
