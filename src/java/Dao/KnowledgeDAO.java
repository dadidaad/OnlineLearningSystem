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
 * Document: KnowledgeDAO for get data for Knowledge bean from database
 * Create on: Feb 9, 2022, 8:11:23 PM
 * @author Doan Tu
 */
public class KnowledgeDAO extends BaseDAO implements IKnowledgeDAO{

    @Override
    public ArrayList<KnowledgeBean> getByChapterId(int chapId) {
       ArrayList<KnowledgeBean> knowledges = new ArrayList<>();
        try {
            //Set up connection and Sql statement for Querry
            Connection conn = getConnection();
            String sql = "select * from Knowledge where ChapterID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, chapId);
            
            //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
            
            //Assign data to an arraylist of ChapterBean
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
}
