package Dao;

import Bean.TeacherBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Document: TeacherDAO handle data for Teacher bean from database
 * Create on: Feb 10, 2022, 9:12:04 PM
 * @author Duc Minh
 */
public class TeacherDAO extends BaseDAO implements ITeacherDAO{

/**    This method get all the teacher has approved from Admin and ready to reply request from student
 **/
    @Override
    public ArrayList<TeacherBean> getAllTeacher() {
        ArrayList<TeacherBean> teachers = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select Account.*,Tutor.*\n" +
                        "from Account, Tutor\n" +
                "where Account.Username = Tutor.Username and Account.[Role] ='tutor' and Tutor.Status= 'approved'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                TeacherBean teacher = new TeacherBean();
                
                teacher.setUsername(rs.getString("Username"));
                teacher.setPassword(rs.getString("Password"));
                teacher.setMail(rs.getString("Mail"));
                teacher.setAvatar(rs.getString("Avatar"));
                teacher.setDisplayName(rs.getString("DisplayName"));
                teacher.setDateOfBirth(rs.getDate("DateOfBirth"));
                teacher.setSex(rs.getBoolean("Sex"));
                teacher.setDescription(rs.getString("Description"));
                teacher.setCash(rs.getInt("Cash in account"));
                teacher.setCreateDate(rs.getDate("CreatedDate"));
                teacher.setRole(rs.getString("Role"));
                teacher.setStatus(rs.getString("Status"));
                teacher.setState(rs.getBoolean("State"));
                teacher.setCvImg(rs.getString("CV"));
                teacher.setSubjectId(rs.getInt("SubjectID"));
                        
                teachers.add(teacher);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teachers;
    }
    public static void main(String[] args) {
        TeacherDAO dal = new TeacherDAO();
        ArrayList<TeacherBean> teachers = dal.getAllTeacher();
        
        for(TeacherBean t : teachers){
            System.out.println(t);
        }
    }
    
}
