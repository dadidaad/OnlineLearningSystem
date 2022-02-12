package Dao;

import Bean.RequestBean;
import Bean.RequestReplyBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Document: RequestDAO handle data for Request bean from database
 * Create on: Feb 10, 2022, 9:12:04 PM
 * @author Duc Minh
 */
public class RequestDAO extends BaseDAO implements IRequestDAO{

    
/**    This method get all the request from database
 **/
    @Override
    public ArrayList<RequestBean> getAllRequest() {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select *\n" +
                         "from Request";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                RequestBean request = new RequestBean();
                request.setRequestID(rs.getInt("RequestID"));
                request.setStudentSent(rs.getString("Student_sent"));
                request.setTutorGet(rs.getString("Tutor_get"));
                request.setCreatedTime(rs.getDate("CreatedTime"));
                request.setStatus(rs.getString("Status"));
                request.setCost(rs.getInt("Cost"));
                request.setContent(rs.getString("Content"));
                request.setImageLink(rs.getString("Image"));
                request.setSubjectID(rs.getInt("SubjectID"));
                request.setLevel(rs.getInt("Level"));
                request.setTitle(rs.getString("Title"));
                        
                requests.add(request);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }
/**    This method get all the request by id from database
 **/
    @Override
    public RequestBean getRequestById(int rqId) {
        try {
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request\n" +
                    "where RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                RequestBean request = new RequestBean();
                request.setRequestID(rs.getInt("RequestID"));
                request.setStudentSent(rs.getString("Student_sent"));
                request.setTutorGet(rs.getString("Tutor_get"));
                request.setCreatedTime(rs.getDate("CreatedTime"));
                request.setStatus(rs.getString("Status"));
                request.setCost(rs.getInt("Cost"));
                request.setContent(rs.getString("Content"));
                request.setImageLink(rs.getString("Image"));
                request.setSubjectID(rs.getInt("SubjectID"));
                request.setLevel(rs.getInt("Level"));
                request.setTitle(rs.getString("Title"));
                        
                return request;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
/**    This method get all the request by status from database
 **/
    @Override
    public ArrayList<RequestBean> getRequestByStatus(String username, String rqStatus) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request\n" +
                    "where Status =? and Student_sent = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setString(2, username);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                RequestBean request = new RequestBean();
                request.setRequestID(rs.getInt("RequestID"));
                request.setStudentSent(rs.getString("Student_sent"));
                request.setTutorGet(rs.getString("Tutor_get"));
                request.setCreatedTime(rs.getDate("CreatedTime"));
                request.setStatus(rs.getString("Status"));
                request.setCost(rs.getInt("Cost"));
                request.setContent(rs.getString("Content"));
                request.setImageLink(rs.getString("Image"));
                request.setSubjectID(rs.getInt("SubjectID"));
                request.setLevel(rs.getInt("Level"));
                request.setTitle(rs.getString("Title"));
                
                        
                requests.add(request);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }
/**    This method get all the request by Subject from database
 **/
    @Override
    public ArrayList<RequestBean> getRequestBySubject(int subjectId) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request\n" +
                    "where SubjectID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, subjectId);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                RequestBean request = new RequestBean();
                request.setRequestID(rs.getInt("RequestID"));
                request.setStudentSent(rs.getString("Student_sent"));
                request.setTutorGet(rs.getString("Tutor_get"));
                request.setCreatedTime(rs.getDate("CreatedTime"));
                request.setStatus(rs.getString("Status"));
                request.setCost(rs.getInt("Cost"));
                request.setContent(rs.getString("Content"));
                request.setImageLink(rs.getString("Image"));
                request.setSubjectID(rs.getInt("SubjectID"));
                request.setLevel(rs.getInt("Level"));
                request.setTitle(rs.getString("Title"));
                
                        
                requests.add(request);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }
    
/**    This method create the request and update to database
 **/
    @Override
    public void createRequest(RequestBean rq) {
       try {
            Connection conn = getConnection();
            String sql = "insert into Request(Student_sent, Tutor_get, CreatedTime, [Status], Cost, Content, [Image], SubjectID,"
                    + "level, Title) \n" +
                    "values(?, ?, GETDATE(), 'Waiting', ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rq.getStudentSent());
            statement.setString(2, rq.getTutorGet());
            statement.setInt(3, rq.getCost());
            statement.setString(4, rq.getContent());
            statement.setString(5, rq.getImageLink());
            statement.setInt(6, rq.getSubjectID());
            statement.setInt(7, rq.getLevel());
            statement.setString(8, rq.getTitle());

            
            statement.executeUpdate();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**    This method update the request and update to database
 **/
    @Override
    public void updateRequest(RequestBean rq) {
         try {
            Connection conn = getConnection();
            String sql = "update Request\n" +
"               set Tutor_get= ?, [Status] = ?, Cost = ?, Content = ?,[Image] = ?, SubjectID = ? WHERE RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rq.getTutorGet());
            statement.setString(2, rq.getStatus());
            statement.setInt(3, rq.getCost());
            statement.setString(4, rq.getContent());
            statement.setString(5, rq.getImageLink());
            statement.setInt(6,  rq.getSubjectID());
            statement.setInt(7, rq.getRequestID());
            

            
            statement.executeUpdate();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**    This method update the status of request and update to database
 **/
    @Override
    public void updateRequestStatus(String status, int requestId) {
         try {
            Connection conn = getConnection();
            String sql = "update Request\n" +
                    "set [Status] = ?\n" +
                    "where RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, requestId);
            

            
            statement.executeUpdate();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

/**    This method delete the request and update to database
 **/
    @Override
    public void deleteRequest(int rqId) {
        try {
            Connection conn = getConnection();
            String sql = "delete from Request where RequestID = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);
            
            statement.executeUpdate();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**    This method get the request Reply by id from database
 **/
    @Override
    public RequestReplyBean getRequestReplyById(int rqId) {
        try {
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request_Reply\n" +
                    "where RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                RequestReplyBean request = new RequestReplyBean();
                request.setRequestID(rs.getInt("RequestID"));
                request.setStudentGet(rs.getString("Student_get"));
                request.setTutorSent(rs.getString("Tutor_sent"));
                request.setCreatedTimeReply(rs.getDate("CreatedTime"));
                request.setContentReply(rs.getString("Content_reply"));
                request.setImageLinkReply(rs.getString("Image_reply"));
                        
                return request;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
/**    This method insert the request Reply to database
 **/     
    @Override
    public void createRequestReply(RequestReplyBean rq) {
       try {
            Connection conn = getConnection();
            String sql = "insert into Request_Reply(RequestID,Tutor_sent,Student_get,CreatedTime,Content_reply,Image_reply)\n" +
                                "values(?, ?, ?, GETDATE(), ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rq.getRequestID());
            statement.setString(2, rq.getTutorSent());
            statement.setString(3, rq.getStudentGet());
            statement.setString(4, rq.getContentReply());
            statement.setString(5, rq.getImageLinkReply());

            
            statement.executeUpdate();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        RequestDAO dal = new RequestDAO();
        ArrayList<RequestBean> requests = dal.getRequestBySubject(1);
//        RequestReplyBean rq = dal.getRequestReplyById(3);
//        RequestBean rq = dal.getRequestById(100);
//        System.out.println(rq);
        RequestBean rq = new RequestBean("minhduc07", "minhanh01", "Waiting", 50000, "de bai so 1", "img", 1, 11, "giup em vs co minh anh");
        dal.createRequest(rq);
//        RequestBean rq = new RequestBean(26, null, "Waiting", 25000, "de bai so 1", "img2", "1");
//        dal.updateRequest(rq);
//        dal.deleteRequest(24);
//        for(RequestBean t : requests){
//            System.out.println(t);
//        }
//        dal.updateRequestStatus("Report",3); 
    }

   

    
}
