/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface ISubjectDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Duc Minh    First Implement
 */
package Dao;

import Bean.RequestBean;
import Bean.RequestReplyBean;
import java.util.ArrayList;

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
     * @return requests. <code>java.util.ArrayList</code> object  
     */
    public ArrayList<RequestBean> getAllRequest();
    
    /**
     * getRequestById method implement from IRequestDAO
     * 
     * @return requests. <code>Bean.RequestBean</code> object  
     */
    public RequestBean getRequestById(int rqId);
    
    /**
     * getRequestByStatus method implement from IRequestDAO
     * 
     * @return requests. <code>java.util.ArrayList</code> object  
     */
    public ArrayList<RequestBean> getRequestForStudent(String username, String rqStatus);
    
    /**
     * getTotalPendingRequest method implement from IRequestDAO
     * 
     * @return total. <code>java.lang.Integer</code> object  
     */
    public int getTotalPendingRequest();
    
    /**
     * getRequestBySubject method implement from IRequestDAO
     * 
     * @return requests. <code>java.util.ArrayList</code> object  
     */
    public ArrayList<RequestBean> getRequestBySubject(int subjectId); 
    
    /**
     * createRequest method implement from IRequestDAO
     * This method create request and add to the databse
     */
    public void createRequest(RequestBean rq);
    
    /**
     * updateRequest method implement from IRequestDAO
     * This method update request and add to the databse
     */
    public void updateRequest(RequestBean rq);
    
    /**
     * deleteRequest method implement from IRequestDAO
     * This method delete request and add to the databse
     */
    public void deleteRequest(int rqId);
    
    /**
     * updateRequestStatus method implement from IRequestDAO
     * This method update the status of request and update to database
     */
    public void updateRequestStatus(String status, int requestId);
    
    /**
     * getRequestForTeacher method implement from IRequestDAO
     * 
     * @return request. <code>java.util.ArrayList</code> object  
     */
    public ArrayList<RequestBean> getRequestForTeacher(int subjectId, String rqStatus);  
    
    /**
     * getRequestForEachTeacher method implement from IRequestDAO
     * 
     * @return request. <code>java.util.ArrayList</code> object  
     */
    public ArrayList<RequestBean> getRequestForEachTeacher(String username, int subjectId, String rqStatus);  
        
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
    public void createRequestReply(RequestReplyBean rq);
    
}
