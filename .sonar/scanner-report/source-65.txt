/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * KnowledgeDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Doan Tu    First Implement
 * 2022-02-25   2.0         Doan Tu    Second Implement
 */
package Dao;

import Bean.KnowledgeBean;
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
    public ArrayList<KnowledgeBean> getByChapterId(int chapId) {
       ArrayList<KnowledgeBean> knowledges = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Knowledge where ChapterID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, chapId);
            
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();
            
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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public int getNumberOfKnowledgeByChpaterId(int chapId) {
       int numberOfKnowledge=0;
       try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select COUNT(*) as Number from Knowledge where ChapterID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, chapId);
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();
            
            /*Assign data to an arraylist of SubjectBean*/
            while(rs.next())
            {
                numberOfKnowledge = rs.getInt("Number");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public int getNumbberOfKnowledge() {
        int numberOfKnowledge=0;
       try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select COUNT(*) as Number from Knowledge";
            PreparedStatement statement = conn.prepareStatement(sql);
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();
            
            /*Assign data to an numberOfKnowledge Integer Type*/
            while(rs.next())
            {
                numberOfKnowledge = rs.getInt("Number");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public int createKnowledge(KnowledgeBean knowledge) {
        int numberOfRow=0;
        try{
            Connection conn = getConnection();
            String sql = "Insert into Knowledge(KnowledgeName, Title, ChapterID)"
                    + "values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, knowledge.getKnowledgeName());
            statement.setString(2, knowledge.getKnowledgeContent());
            statement.setInt(3, knowledge.getChapterID());

            numberOfRow = statement.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean searchByKnowledgeNameOfChap(String knowledgeName, int chapId) {
        boolean check = true;
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Knowledge where KnowledgeName=? and ChapterID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, knowledgeName);
            statement.setInt(2, chapId);
            
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                check = false;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
  
}
