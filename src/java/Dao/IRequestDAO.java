package Dao;

import Bean.RequestBean;
import Bean.RequestReplyBean;
import java.util.ArrayList;

/**
 * Document: Interface IRequestDAO
 * Create on: Feb 10, 2022, 9:14:35 PM
 * @author Duc Minh
 */
public interface IRequestDAO {
    public ArrayList<RequestBean> getAllRequest();
    public RequestBean getRequestById(int rqId);
    public ArrayList<RequestBean> getRequestByStatus(String username, String rqStatus);
    public ArrayList<RequestBean> getRequestBySubject(int subjectId); 
    public void createRequest(RequestBean rq);
    public void updateRequest(RequestBean rq);
    public void deleteRequest(int rqId);
    public void updateRequestStatus(String status, int requestId);
            
    public RequestReplyBean getRequestReplyById(int rqId);
    public void createRequestReply(RequestReplyBean rq);
    
}
