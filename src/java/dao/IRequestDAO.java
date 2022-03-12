/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface ISubjectDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Duc Minh    First Implement
 */
package dao;

import bean.RequestBean;
import bean.RequestReplyBean;
import java.util.List;

/**
 * This is the interface class that declares the methods to access the data of the Request object
 * Abstract method getAllRequest used to retrieve all requests
 * Abstract method getRequestById used to retrieve the request with corresponding ID
 * Abstract method getRequestByStatus used to retrieve the request with corresponding username and status
 * Abstract method getRequestBySubject used to retrieve the request with corresponding subjectID
 * Abstract method createRequest, updateRequest, deleteRequest, updateRequestStatus to change attribute and create of Request from database
 * Abstract method getRequestReplyById used to retrieve the request reply with corresponding ID
 * Abstract method createRequestReply used to create the request.
 * 
 * @author Duc Minh
 */
public interface IRequestDAO {
    /**
     * getAllRequest method implement from IRequestDAO
     * 
     * @return requests. <code>java.util.List</code> object  
     */
    public List<RequestBean> getAllRequest();
    
    /**
     * getRequestById method implement from IRequestDAO
     * 
     * @return requests. <code>Bean.RequestBean</code> object  
     */
    public RequestBean getRequestById(int rqId);
    
    /**
     * getRequestByStatus method implement from IRequestDAO
     * 
     * @return requests. <code>java.util.List</code> object  
     */
    public List<RequestBean> getRequestForStudent(String username, String rqStatus, int pageindex, int pagesize);
    
    /**
     * getRequestBySubject method implement from IRequestDAO
     * 
     * @return requests. <code>java.util.List</code> object  
     */
    public List<RequestBean> getRequestBySubject(int subjectId); 
    
    /**
     * createRequest method implement from IRequestDAO
     * This method create request and add to the databse
     */
    public int createRequest(RequestBean rq);
    
    /**
     * updateRequest method implement from IRequestDAO
     * This method update request and add to the databse
     */
    public int updateRequest(RequestBean rq);
    
    /**
     * deleteRequest method implement from IRequestDAO
     * This method delete request and add to the databse
     */
    public int deleteRequest(int rqId);
    
    /**
     * updateRequestStatus method implement from IRequestDAO
     * This method update the status of request and update to database
     */
    public int updateRequestStatus(String status, int requestId);
    
    /**
     * getRequestForTeacher method implement from IRequestDAO
     * 
     * @return request. <code>java.util.List</code> object  
     */
    public List<RequestBean> getRequestForTeacher(int subjectId, String rqStatus, int pageindex, int pagesize);  
    
    /**
     * getRequestForTeacher method implement from IRequestDAO
     * 
     * @return request. <code>java.util.List</code> object  
     */
    public List<RequestBean> getRequestForTeacher(String username,String rqStatus, int pageindex, int pagesize);  
    
    /**
     * getRequestRequestReplyBeanReplyById method implement from IRequestDAO
     * This method get the request reply from to database
     * @return request. <code>Bean.RequestBean</code> object 
     */
    public RequestReplyBean getRequestReplyById(int rqId);
    
    /**
     * createRequestReply method implement from IRequestDAO
     * This method create the request reply to database
     */ 
    public int createRequestReply(RequestReplyBean rq);
    
    /**
     * getTotalPendingRequest method implement from IRequestDAO
     * 
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalPendingRequest();
    
    /**
     * getTotalRequestStudent method implement from IRequestDAO
     * 
     * @param username
     * @param rqStatus
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestStudent(String username, String rqStatus);
    
    /**
     * getTotalRequestTeacher method implement from IRequestDAO
     * 
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestTeacherApply();
    public int getTotalRequestForTeacher(int subjectId, String rqStatus);
    public int getTotalRequestForTeacher(String username, String rqStatus);
    public int getTotalRequestSearchForStudent(String username, String rqStatus, String searchString);
    public List<RequestBean> getRequestSearchForStudent(String username, String rqStatus, String searchString, int pageindex, int pagesize);
    
    public int getTotalRequestSearchForTeacher(int subjectId, String rqStatus, String searchString);
    public int getTotalRequestSearchForTeacher(String username, String rqStatus, String searchString);

    public List<RequestBean> getRequestSearchForTeacher(int subjectId, String rqStatus, String searchString, int pageindex, int pagesize);
    public List<RequestBean> getRequestSearchForTeacher(String username, String rqStatus, String searchString, int pageindex, int pagesize);
}
