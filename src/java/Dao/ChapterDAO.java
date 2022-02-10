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
 *Document: ChpaterDAO for get data for Chapter bean from database
 * Create on: Feb 10, 2022, 8:13:05 PM
 * @author Doan Tu
 */
public class ChapterDAO extends BaseDAO implements IChapterDAO{

    @Override
    public ArrayList<ChapterBean> getBySubId(int subId) {
       ArrayList<ChapterBean> chapters = new ArrayList<>();
        try {
            //Set up connection and Sql statement for Querry
            Connection conn = getConnection();
            String sql = "select * from Chapter where SubjectID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, subId);
            
            //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
            
            //Assign data to an arraylist of ChapterBean
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
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chapters;
    }
}
