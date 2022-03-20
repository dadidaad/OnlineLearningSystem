/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ChapterDAO 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Duc Minh   First Implement
 */
package dao;

import bean.RequestBean;
import bean.RequestReplyBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find Request information from database Extend
 * BaseDAO class to call getConnection() method Implement IRequestDAO Interface
 *
 * @author Duc Minh
 */
public class RequestDAO extends BaseDAO implements IRequestDAO {

    /**
     * getRequestById method implement from IRequestDAO
     *
     * @return request. <code>Bean.RequestBean</code> object
     */
    @Override
    public RequestBean getRequestById(int rqId) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select *\n"
                    + "from Request\n"
                    + "where RequestID = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();
            while (rs.next()) {
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

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return null;
    }

    /**
     * getRequestByStatus method implement from IRequestDAO
     *
     * @return request. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<RequestBean> getRequestForStudent(String username, String rqStatus, int pageindex, int pagesize) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select t.*\n"
                    + "from (select Request.*, ROW_NUMBER() OVER(ORDER BY Request.CreatedTime DESC) e from Request) t\n"
                    + "Where t.[Status] = ? and t.Student_sent = ? and e between ? and ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setString(2, username);
            statement.setInt(3, (pageindex - 1) * pagesize);
            statement.setInt(4, pagesize);

            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
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
    public ArrayList<RequestBean> getRequestForTeacher(int subjectId, String rqStatus, int pageindex, int pagesize) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select t.*\n"
                    + "from (select Request.*, ROW_NUMBER() OVER(ORDER BY Request.CreatedTime DESC) e from Request) t\n"
                    + "Where t.[Status] = ? and t.SubjectID = ? and e between ? and ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setInt(2, subjectId);
            statement.setInt(3, (pageindex - 1) * pagesize);
            statement.setInt(4, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();
            while (rs.next()) {
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

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return requests;
    }

    /**
     * getRequestForEachTeacher method implement from IRequestDAO
     *
     * @return request. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<RequestBean> getRequestForTeacher(String username, String rqStatus, int pageindex, int pagesize) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select t.*\n" 
                    + "from (select Request.*, ROW_NUMBER() OVER(ORDER BY Request.CreatedTime DESC) e from Request, Request_Reply where Request.RequestID = Request_Reply.RequestID and Request_Reply.Tutor_sent = ?  and Request.[Status]= ?)t\n"
                    + "Where  e between ? and ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, rqStatus);
            statement.setInt(3, (pageindex - 1) * pagesize);
            statement.setInt(4, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();
            while (rs.next()) {
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

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
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
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select *\n"
                    + "from Request\n"
                    + "where SubjectID = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, subjectId);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();
            while (rs.next()) {
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

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return requests;
    }

    /**
     * createRequest method implement from IRequestDAO This method create
     * request and add to the databse
     */
    @Override
    public int createRequest(RequestBean rq) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "insert into Request(Student_sent, Tutor_get, CreatedTime, [Status], Cost, Content, [Image], SubjectID,"
                    + "Level, Title) \n"
                    + "values(?, ?, GETDATE(), 'Waiting', ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, rq.getStudentSent());
            statement.setString(2, rq.getTutorGet());
            statement.setInt(3, rq.getCost());
            statement.setString(4, rq.getContent());
            statement.setString(5, rq.getImageLink());
            statement.setInt(6, rq.getSubjectID());
            statement.setInt(7, rq.getLevel());
            statement.setString(8, rq.getTitle());

            /*Excuse Query*/
            totalRow = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return totalRow;
    }

    /**
     * updateRequest method implement from IRequestDAO This method update the
     * request and update to database
     */
    @Override
    public int updateRequest(RequestBean rq) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "update Request\n"
                    + "               set Tutor_get= ?, Cost = ?, [Status] = 'Waiting', Content = ?,[Image] = ?, SubjectID = ?,"
                    + " Level = ?, Title = ?,CreatedTime = GETDATE()  WHERE RequestID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, rq.getTutorGet());
            statement.setInt(2, rq.getCost());
            statement.setString(3, rq.getContent());
            statement.setString(4, rq.getImageLink());
            statement.setInt(5, rq.getSubjectID());
            statement.setInt(6, rq.getLevel());
            statement.setString(7, rq.getTitle());
            statement.setInt(8, rq.getRequestID());


            /*Excuse Query*/
            totalRow = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return totalRow;
    }

    /**
     * updateRequestStatus method implement from IRequestDAO This method update
     * the status of request and update to database
     */
    @Override
    public int updateRequestStatus(String status, int requestId) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "update Request\n"
                    + "set [Status] = ?\n"
                    + "where RequestID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, requestId);


            /*Excuse Query*/
            totalRow = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return totalRow;
    }

    /**
     * deleteRequest method implement from IRequestDAO This method delete the
     * request to database
     *
     * @param rqId
     */
    @Override
    public int deleteRequest(int rqId) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "delete from Request where RequestID = ? ";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);

            /*Excuse Query*/
            totalRow = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return totalRow;
    }

    @Override
    public void deleteRequestReply(int rqId) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "delete from Request_Reply where RequestID = ? ";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);

            /*Excuse Query*/
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
    }

    /**
     * getRequestRequestReplyBeanReplyById method implement from IRequestDAO
     * This method get the request reply from to database
     *
     * @param rqId
     * @return request. <code>Bean.RequestBean</code> object
     */
    @Override
    public RequestReplyBean getRequestReplyById(int rqId) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select *\n"
                    + "from Request_Reply\n"
                    + "where RequestID = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, rqId);

            /*Excuse Query and Get data*/
            rs = statement.executeQuery();
            while (rs.next()) {
                RequestReplyBean request = new RequestReplyBean();
                request.setRequestID(rs.getInt("RequestID"));
                request.setStudentGet(rs.getString("Student_get"));
                request.setTutorSent(rs.getString("Tutor_sent"));
                request.setCreatedTimeReply(rs.getDate("CreatedTime"));
                request.setContentReply(rs.getString("Content_reply"));
                request.setImageLinkReply(rs.getString("Image_reply"));

                return request;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return null;
    }

    /**
     * createRequestReply method implement from IRequestDAO This method create
     * the request reply to database
     */
    @Override
    public int createRequestReply(RequestReplyBean rq) {
        int totalRow = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "insert into Request_Reply(RequestID,Tutor_sent,Student_get,CreatedTime,Content_reply,Image_reply)\n"
                    + "values(?, ?, ?, GETDATE(), ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, rq.getRequestID());
            statement.setString(2, rq.getTutorSent());
            statement.setString(3, rq.getStudentGet());
            statement.setString(4, rq.getContentReply());
            statement.setString(5, rq.getImageLinkReply());

            /*Excuse Query*/
            totalRow = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return totalRow;
    }

    /**
     * getTotalPendingRequest method implement from IAccountDAO
     *
     * @return total Integer<Integer>.
     */
    @Override
    public int getTotalPendingRequest() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select count(RequestID) as NumberOfRequest from Request where [Status] = 'Waiting'";

            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfRequest");
            }

        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    @Override
    public int getTotalRequestTeacherApply() {
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select COUNT(Account.Username) AS NumberOfAccount  \n"
                    + "from Account, Tutor\n"
                    + "where Account.Username = Tutor.Username and Account.[Role] ='Teacher' and Tutor.Status = 'Waiting' \n";

            PreparedStatement statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }

            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;

    }

    @Override
    public int getTotalRequestStudent(String username, String rqStatus) {
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select count(Request.RequestID) as NumberOfRequest \n"
                    + "from Request\n"
                    + "where Status =? and Student_sent = ?  \n";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setString(2, username);
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfRequest");
            }

            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public int getTotalRequestForTeacher(int subjectId, String rqStatus) {
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select count(RequestID) as NumberOfRequest \n"
                    + "from Request\n"
                    + "where Status =? and SubjectID = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setInt(2, subjectId);

            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfRequest");
            }

            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public int getTotalRequestForTeacher(String username, String rqStatus) {
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select count(Request.RequestID) as NumberOfRequest\n"
                    + "from Request, Request_Reply\n"
                    + "where Request.RequestID = Request_Reply.RequestID and Request_Reply.Tutor_sent = ? and Request.Status = ? ";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, rqStatus);
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfRequest");
            }

            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public int getTotalRequestSearchForStudent(String username, String rqStatus, String searchString) {
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select count(Request.RequestID) as NumberOfRequest \n"
                    + "from Request\n"
                    + "where Status =? and Student_sent = ?  and Title like ? \n";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setString(2, username);
            statement.setString(3, "%" + searchString + "%");
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfRequest");
            }

            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public ArrayList<RequestBean> getRequestSearchForStudent(String username, String rqStatus, String searchString, int pageindex, int pagesize) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select t.*\n"
                    + "from (select Request.*, ROW_NUMBER() OVER(ORDER BY Request.CreatedTime DESC) e from Request) t\n"
                    + "Where t.[Status] = ? and t.Student_sent = ? and t.Title like ?  and e between ? and ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setString(2, username);
            statement.setString(3, "%" + searchString + "%");
            statement.setInt(4, (pageindex - 1) * pagesize);
            statement.setInt(5, pagesize);

            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
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

    @Override
    public int getTotalRequestSearchForTeacher(String username, String rqStatus, String searchString) {
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select count(Request.RequestID) as NumberOfRequest\n"
                    + "from Request, Request_Reply\n"
                    + "where Request.RequestID = Request_Reply.RequestID and Request_Reply.Tutor_sent = ? and Request.Status = ? and Request.Title like ? ";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, rqStatus);
            statement.setString(3, "%" + searchString + "%");
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfRequest");
            }

            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public int getTotalRequestSearchForTeacher(int subjectId, String rqStatus, String searchString) {
        int total = 0;
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select count(RequestID) as NumberOfRequest \n"
                    + "from Request\n"
                    + "where Status =? and SubjectID = ? and Request.Title like ? ";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setInt(2, subjectId);
            statement.setString(3, "%" + searchString + "%");

            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfRequest");
            }

            /*Close all the connection */
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public ArrayList<RequestBean> getRequestSearchForTeacher(String username, String rqStatus, String searchString, int pageindex, int pagesize) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select t.*\n"
                    + "from (select Request.*, ROW_NUMBER() OVER(ORDER BY Request.CreatedTime DESC) e from Request) t, Request_Reply\n"
                    + "Where t.RequestID = Request_Reply.RequestID and Request_Reply.Tutor_sent = ? and t.[Status] = ? and t.Title like ?  and e between ? and ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, rqStatus);
            statement.setString(3, "%" + searchString + "%");
            statement.setInt(4, (pageindex - 1) * pagesize);
            statement.setInt(5, pagesize);
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
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

    @Override
    public ArrayList<RequestBean> getRequestSearchForTeacher(int subjectId, String rqStatus, String searchString, int pageindex, int pagesize) {
        ArrayList<RequestBean> requests = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query */
            Connection conn = getConnection();
            String sql = "select t.*\n"
                    + "from (select Request.*, ROW_NUMBER() OVER(ORDER BY Request.CreatedTime DESC) e from Request) t\n"
                    + "Where t.[Status] = ? and t.SubjectID = ? and t.Title like ? and e between ? and ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, rqStatus);
            statement.setInt(2, subjectId);
            statement.setString(3, "%" + searchString + "%");
            statement.setInt(4, (pageindex - 1) * pagesize);
            statement.setInt(5, pagesize);
            /*Query and save in ResultSet */
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
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
    public static void main(String[] args) {
        RequestDAO dal = new RequestDAO();
        ArrayList<RequestBean> list = dal.getRequestForTeacher("ducgiang", "Approved", 1, 10);
        for(RequestBean r : list){
            System.out.println(r);
        }
        
    }

    @Override
    public int getLastRequestId() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int requestID = 0;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select top 1 RequestID\n" 
                    + "from Request\n" 
                    + "order by RequestID desc";

            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                requestID = rs.getInt("RequestId");
            }

        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return requestID;
    }
}
