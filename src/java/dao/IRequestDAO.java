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
     * getRequestById method implement from IRequestDAO
     * 
     * @param rqId <code>java.lang.Integer</code>
     * @return request. <code>Bean.RequestBean</code> object  
     */
    public RequestBean getRequestById(int rqId);
    
    /**
     * getRequestByStatus method implement from IRequestDAO
     * 
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return requests. <code>java.util.List</code> object  
     */
    public List<RequestBean> getRequestForStudent(String username, String rqStatus, int pageindex, int pagesize);
    
    /**
     * getRequestBySubject method implement from IRequestDAO
     * 
     * @param subjectId<code>java.lang.Integer</code>
     * @return requests. <code>java.util.List</code> object  
     */
    public List<RequestBean> getRequestBySubject(int subjectId); 
    
    /**
     * createRequest method implement from IRequestDAO
     * This method create request and add to the database
     * @param rq <code>Bean.RequestBean</code> object 
     * @return row Affected <code>java.lang.Integer</code>
     */
    public int createRequest(RequestBean rq);
    
    /**
     * updateRequest method implement from IRequestDAO
     * This method update request and add to the database
     * @param rq <code>Bean.RequestBean</code> object 
     * @return row Affected <code>java.lang.Integer</code>
     */
    public int updateRequest(RequestBean rq);
    
    /**
     * deleteRequest method implement from IRequestDAO
     * This method delete request and add to the database
     * @param rqId<code>java.lang.Integer</code>
     * @return affected row <code>java.lang.Integer</code> 
     */
    public int deleteRequest(int rqId);
    
    /**
     * deleteRequestReply method implement from IRequestDAO
     * This method delete request reply and add to the database
     * @param rqId <code>java.lang.Integer</code>
     */
    public void deleteRequestReply(int rqId);
    
    /**
     * updateRequestStatus method implement from IRequestDAO
     * This method update the status of request and update to database
     * @param status <code>java.lang.String</code>
     * @param requestId <code>java.lang.Integer</code>
     * @return affected row <code>java.lang.Integer</code> 
     */
    public int updateRequestStatus(String status, int requestId);
    
    /**
     * getRequestForTeacher method implement from IRequestDAO
     * 
     * @param subjectId <code>java.lang.Integer</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return request. <code>java.util.List</code>   
     */
    public List<RequestBean> getRequestForTeacher(int subjectId, String rqStatus, int pageindex, int pagesize);  
    
    /**
     * getRequestForTeacher method implement from IRequestDAO
     * 
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return request. <code>java.util.List</code>   
     */
    public List<RequestBean> getRequestForTeacher(String username,String rqStatus, int pageindex, int pagesize);  
    
    /**
     * getRequestRequestReplyBeanReplyById method implement from IRequestDAO
     * This method get the request reply from to database
     * @param rqId <code>java.lang.Integer</code>
     * @return request. <code>Bean.RequestBean</code> object 
     */
    public RequestReplyBean getRequestReplyById(int rqId);
    
    /**
     * createRequestReply method implement from IRequestDAO
     * This method create the request reply to database
     * @param rq  <code>Bean.RequestBean</code> object 
     * @return row affected <code>java.lang.Integer</code> 
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
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestStudent(String username, String rqStatus);
    
    /**
     * getTotalRequestTeacherApply method implement from IRequestDAO
     * 
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestTeacherApply();
    
    /**
     * getTotalRequestForTeacher method implement from IRequestDAO
     * 
     * @param subjectId <code>java.lang.Integer</code>
     * @param rqStatus <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestForTeacher(int subjectId, String rqStatus);
    
    /**
     * getTotalRequestForTeacher method implement from IRequestDAO
     * 
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestForTeacher(String username, String rqStatus);
    
    /**
     * getTotalRequestForTeacher method implement from IRequestDAO
     * 
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestSearchForStudent(String username, String rqStatus, String searchString);
    
    /**
     * getRequestSearchForStudent method implement from IRequestDAO
     * 
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return requests. <code>java.util.List</code>   
     */
    public List<RequestBean> getRequestSearchForStudent(String username, String rqStatus, String searchString, int pageindex, int pagesize);
    
    /**
     * getTotalRequestSearchForTeacher method implement from IRequestDAO
     * 
     * @param subjectId <code>java.lang.Integer</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestSearchForTeacher(int subjectId, String rqStatus, String searchString);
    
    /**
     * getTotalRequestForTeacher method implement from IRequestDAO
     * 
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalRequestSearchForTeacher(String username, String rqStatus, String searchString);

    /**
     * getRequestSearchForTeacher method implement from IRequestDAO
     * 
     * @param subjectId <code>java.lang.Integer</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return request. <code>java.util.List</code>   
     */
    public List<RequestBean> getRequestSearchForTeacher(int subjectId, String rqStatus, String searchString, int pageindex, int pagesize);
    
     /**
     * getRequestSearchForTeacher method implement from IRequestDAO
     * 
     * @param username <code>java.lang.String</code>
     * @param rqStatus <code>java.lang.String</code>
     * @param searchString <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return request. <code>java.util.List</code>   
     */
    public List<RequestBean> getRequestSearchForTeacher(String username, String rqStatus, String searchString, int pageindex, int pagesize);
    
    /**
     * getLastRequestId method implement from IRequestDAO
     *
     * @return requestId. <code>java.lang.Integer</code> object
     */
    public int getLastRequestId();
    
    /**
     * getTotalRequestForTeacher method implement from IRequestDAO
     * 
     * @param rqId <code>java.lang.Integer</code>
     * @return rowAffted. <code>java.lang.Integer</code> object  
     */
    public int updateRequestTime(int rqId);
}
