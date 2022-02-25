/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ChapterDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Duc Minh   First Implement
 */
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
 * This class contain method to find Request information from database
 * Extend BaseDAO class to call getConnection() method
 * Implement IRequestDAO Interface
 * 
 * @author Duc Minh
 */
public class RequestDAO extends BaseDAO implements IRequestDAO{

    
    /**
     * getAllRequest method implement from IRequestDAO
     * 
     * @return requests. <code>java.util.ArrayList</code> object  
     */
    @Override
    public ArrayList<RequestBean> getAllRequest() {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select *\n" +
                         "from Request";
            PreparedStatement statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();
            
            /*Assign data to an arraylist of Request*/
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
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return requests;
    }
    
    /**
     * getRequestById method implement from IRequestDAO
     * 
     * @return request. <code>Bean.RequestBean</code> object  
     */
    @Override
    public RequestBean getRequestById(int rqId) {
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request\n" +
                    "where RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);
            
            /*Query and save in ResultSet */
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
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * getRequestByStatus method implement from IRequestDAO
     * 
     * @return request. <code>java.util.ArrayList</code> object  
     */
    @Override
    public ArrayList<RequestBean> getRequestForStudent(String username, String rqStatus) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request\n" +
                    "where Status =? and Student_sent = ? order by CreatedTime desc";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setString(2, username);
            
            /*Query and save in ResultSet */
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
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }
    /**
     * getRequestForTeacher method implement from IRequestDAO
     * 
     * @return request. <code>java.util.ArrayList</code> object  
     */
    @Override
    public ArrayList<RequestBean> getRequestForTeacher(int subjectId, String rqStatus) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request\n" +
                    "where Status =? and SubjectID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setInt(2, subjectId);
            
            /*Query and save in ResultSet */
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
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }
    
    
    /**
     * getRequestForEachTeacher method implement from IRequestDAO
     * 
     * @return request. <code>java.util.ArrayList</code> object  
     */
     @Override
    public ArrayList<RequestBean> getRequestForEachTeacher(String username, int subjectId, String rqStatus) {
       ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select Request.*\n" +
                "from Request, Request_Reply\n" +
                "where Request.Status = ? and SubjectID = ? and Request_Reply.tutor_sent = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setInt(2, subjectId);
            statement.setString(3, username);
            
            /*Query and save in ResultSet */
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
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }
    
    /**
     * getRequestBySubject method implement from IRequestDAO
     * 
     * @return request. <code>java.util.ArrayList</code> object  
     */
    @Override
    public ArrayList<RequestBean> getRequestBySubject(int subjectId) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request\n" +
                    "where SubjectID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, subjectId);
            
            /*Query and save in ResultSet */
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
            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }
    
    /**
     * createRequest method implement from IRequestDAO
     * This method create request and add to the databse
     */
    @Override
    public void createRequest(RequestBean rq) {
       try {
           /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "insert into Request(Student_sent, Tutor_get, CreatedTime, [Status], Cost, Content, [Image], SubjectID,"
                    + "Level, Title) \n" +
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

            /*Excuse Query*/
            statement.executeUpdate();
            
            /*Close all the connection */
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * updateRequest method implement from IRequestDAO
     * This method update the request and update to database
     */

    @Override
    public void updateRequest(RequestBean rq) {
         try {
             /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "update Request\n" +
"               set Tutor_get= ?, Cost = ?, [Status] = 'Waiting', Content = ?,[Image] = ?, SubjectID = ?,"
                    + " Level = ?, Title = ?,CreatedTime = GETDATE()  WHERE RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rq.getTutorGet());
            statement.setInt(2, rq.getCost());
            statement.setString(3, rq.getContent());
            statement.setString(4, rq.getImageLink());
            statement.setInt(5,  rq.getSubjectID());
            statement.setInt(6, rq.getLevel());
            statement.setString(7, rq.getTitle());
            statement.setInt(8, rq.getRequestID());
            

            /*Excuse Query*/
            statement.executeUpdate();
            
            /*Close all the connection */
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * updateRequestStatus method implement from IRequestDAO
     * This method update the status of request and update to database
     */
    @Override
    public void updateRequestStatus(String status, int requestId) {
         try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "update Request\n" +
                    "set [Status] = ?\n" +
                    "where RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, requestId);
            

            /*Excuse Query*/
            statement.executeUpdate();
            
            /*Close all the connection */
            
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * deleteRequest method implement from IRequestDAO
     * This method delete the request to database
     */
    @Override
    public void deleteRequest(int rqId) {
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "delete from Request where RequestID = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);
            
            /*Excuse Query*/
            statement.executeUpdate();
            
            /*Close all the connection */
           
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * getRequestRequestReplyBeanReplyById method implement from IRequestDAO
     * This method get the request reply from to database
     * @return request. <code>Bean.RequestBean</code> object 
     */
    @Override
    public RequestReplyBean getRequestReplyById(int rqId) {
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select *\n" +
                    "from Request_Reply\n" +
                    "where RequestID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);
            
            /*Excuse Query and Get data*/
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
           /*Close all the connection */
            
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * createRequestReply method implement from IRequestDAO
     * This method create the request reply to database
     */  
    @Override
    public void createRequestReply(RequestReplyBean rq) {
       try {
           /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "insert into Request_Reply(RequestID,Tutor_sent,Student_get,CreatedTime,Content_reply,Image_reply)\n" +
                                "values(?, ?, ?, GETDATE(), ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rq.getRequestID());
            statement.setString(2, rq.getTutorSent());
            statement.setString(3, rq.getStudentGet());
            statement.setString(4, rq.getContentReply());
            statement.setString(5, rq.getImageLinkReply());

            /*Excuse Query*/
            statement.executeUpdate();
            
           /*Close all the connection */
            
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
         
//            String sql = "update Request\n" +
//"               set Tutor_get= ?, Cost = ?, [Status] = 'Waiting', Content = ?,[Image] = ?, SubjectID = ?,"
//                    + " Level = ?, Title = ?,  WHERE RequestID = ?, CreatedTime = GETDATE()";
//        RequestBean rq = new RequestBean();
//        
//        rq.setRequestID(53);
//        rq.setStudentSent("minhduc07");
//        rq.setTutorGet(null);
//        rq.setCost(Integer.parseInt("20000"));
//        rq.setContent("bai tap toan co loi giai");
//        rq.setImageLink("img");
//        rq.setSubjectID(Integer.parseInt("1"));
//        rq.setLevel(Integer.parseInt("11"));
//        rq.setTitle("tieu update 12h54");
//        
        IRequestDAO iRequestDAO = new RequestDAO();
//        iRequestDAO.updateRequest(rq);
//        System.out.println("Done");    
    ArrayList<RequestBean> list = iRequestDAO.getRequestForEachTeacher("thuhuong", 1, "approved");
        System.out.println(list.size());
    
    }

   
}
