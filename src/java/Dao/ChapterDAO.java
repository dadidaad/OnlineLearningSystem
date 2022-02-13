/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ChapterDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Doan Tu    First Implement
 */
package Dao;

import Bean.ChapterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find Chapter information from database
 * Extend BaseDAO class to call getConnection() method
 * Implement IChapterDAO Interface
 * 
 * @author Doan Tu
 */
public class ChapterDAO extends BaseDAO implements IChapterDAO{

    /**
     * getAllSubject method implement from IChapterDAO
     * 
     * @param subId ID of Subject which Chapter belongs <code>java.lang.Integer</code> object
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<ChapterBean> getBySubId(int subId) {
       ArrayList<ChapterBean> chapters = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Chapter where SubjectID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, subId);
            
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();
            
            /*Assign data to an arraylist of ChapterBean*/
            while(rs.next())
            {
                ChapterBean chapter = new ChapterBean();
                chapter.setChapterID(rs.getInt("ChapterID"));
                chapter.setChapterName(rs.getString("ChapterName"));
                chapter.setSemester(rs.getInt("Semester"));
                chapter.setChapterContent(rs.getString("Chapter Content"));
                chapter.setSubjectID(rs.getInt("SubjectID"));
                
                chapters.add(chapter);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chapters;
    }
    /**
     * getChapterById method implement from IChapterDAO
     * 
     * @param chapId ID of the Chapter. <code>java.lang.Integer</code> object
     * @return chapter <code>Bean.ChapterBean</code> object
     */
    @Override
    public ChapterBean getChapterById(int chapId) {
        ChapterBean chapter = new ChapterBean();
        try {
            /*Set up connection and Sql statement for Querry*/
            Connection conn = getConnection();
            String sql = "select * from Chapter where ChapterID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, chapId);
            
            /*Querry and save in ResultSet*/
            ResultSet rs = statement.executeQuery();
            
            /*Assign data to an ChapterBean*/
            while(rs.next())
            {
                chapter.setChapterID(rs.getInt("ChapterID"));
                chapter.setChapterName(rs.getString("ChapterName"));
                chapter.setSemester(rs.getInt("Semester"));
                chapter.setChapterContent(rs.getString("Chapter Content"));
                chapter.setSubjectID(rs.getInt("SubjectID"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chapter;
    }
}
