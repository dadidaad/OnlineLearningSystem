package Dao;

import Bean.SubjectBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Document: SusbjectDAO for get data for Student bean from database
 * Create on: Feb 9, 2022, 9:12:04 PM
 * @author Doan Tu
 */
public class SubjectDAO extends BaseDAO implements ISubjectDAO{

    @Override
    public ArrayList<SubjectBean> getAllSubject() {
        ArrayList<SubjectBean> subjects = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select * from Subject";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                SubjectBean subject = new SubjectBean();
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setDescription(rs.getString("Description"));
                subjects.add(subject);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjects;
    } 
    
    public static void main(String[] args) {
        SubjectDAO db = new SubjectDAO();
        System.out.println(db.getAllSubject());
    }
}
