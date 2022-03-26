package dao;

import bean.RequestBean;
import bean.RequestReplyBean;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author win
 */
public class RequestDAOTest {
    
    public RequestDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
 
    
    public Date convertSqlDate(String s) throws ParseException{
        java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(s); // This throws a ParseException
        java.sql.Date d1 = new java.sql.Date(d.getTime());
        return d1;
    }

    @Test
    public void testGetRequestById_UTC1() throws ParseException {
        System.out.println("getRequestById");
        int rqId = 1;
        RequestDAO instance = new RequestDAO();
        RequestBean expResult = new RequestBean(1, "minhduc07", "ducgiang", convertSqlDate("2022-03-14"), "Waiting", 20000, "de bai so 1", "/assets/image/", 1, 12, "title request 1");
        RequestBean result = instance.getRequestById(rqId);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetRequestById_UTC2() throws ParseException {
        System.out.println("getRequestById");
        int rqId = 0;
        RequestDAO instance = new RequestDAO();
        RequestBean expResult = null;
        RequestBean result = instance.getRequestById(rqId);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetRequestById_UTC3() throws ParseException {
        System.out.println("getRequestById");
        int rqId = -1;
        RequestDAO instance = new RequestDAO();
        RequestBean expResult = null;
        RequestBean result = instance.getRequestById(rqId);
        assertEquals(expResult, result);

    }
    
    @Test(expected = Exception.class)
    public void testGetRequestById_UTC4() throws ParseException {
        System.out.println("getRequestById");
        int rqId = Integer.parseInt("a");
        RequestDAO instance = new RequestDAO();
        RequestBean expResult = null;
        RequestBean result = instance.getRequestById(rqId);
        assertEquals(expResult, result);

    }

    @Test
    public void testUpdateRequest_UTC1() throws ParseException {
        System.out.println("updateRequest");
        RequestBean rq = new RequestBean(2, "minhduc07", "ducgiang", convertSqlDate("2022-03-14"), "Waiting", 20000, "de bai so 2 update", "/assets/image/", 1, 12, "title request 2 update");
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        int result = instance.updateRequest(rq);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateRequest_UTC2() throws ParseException {
        System.out.println("updateRequest");
        RequestBean rq = new RequestBean(99, "minhduc07", "ducgiang", convertSqlDate("2022-03-14"), "Approved", 20000, "de bai so 1", "/assets/image/", 1, 12, "title request 1");
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.updateRequest(rq);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateRequest_UTC3() throws ParseException {
        System.out.println("updateRequest");
        RequestBean rq = new RequestBean();
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.updateRequest(rq);
        assertEquals(expResult, result);
    }
    @Test (expected = Exception.class)
    public void testUpdateRequest_UTC4() throws ParseException {
        System.out.println("updateRequest");
        RequestBean rq =  null;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.updateRequest(rq);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateRequestStatus_UTC1() {
        System.out.println("updateRequestStatus");
        String status = "Waiting";
        int requestId = 21;
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        int result = instance.updateRequestStatus(status, requestId);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateRequestStatus_UTC2() {
        System.out.println("updateRequestStatus");
        String status = "Done";
        int requestId = 21;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.updateRequestStatus(status, requestId);
        assertEquals(expResult, result);
    }
    @Test (expected = Exception.class)
    public void testUpdateRequestStatus_UTC3() {
        System.out.println("updateRequestStatus");
        String status = null;
        int requestId = 21;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.updateRequestStatus(status, requestId);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateRequestStatus_UTC4() {
        System.out.println("updateRequestStatus");
        String status = "    Wa  iti  ng     ";
        int requestId = 2;
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        int result = instance.updateRequestStatus(status, requestId);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetRequestReplyById_UTC1() throws ParseException {
        System.out.println("getRequestReplyById");
        int rqId = 1;
        RequestDAO instance = new RequestDAO();
        RequestReplyBean expResult = new RequestReplyBean(1, "ducgiang", "minhduc07", convertSqlDate("2022-03-14"), "dap an cua ban", "/assets/image/");
        RequestReplyBean result = instance.getRequestReplyById(rqId);
        assertEquals(expResult, result);
     
    }
    
    @Test
    public void testGetRequestReplyById_UTC2() {
        System.out.println("getRequestReplyById");
        int rqId = 0;
        RequestDAO instance = new RequestDAO();
        RequestReplyBean expResult = null;
        RequestReplyBean result = instance.getRequestReplyById(rqId);
        assertEquals(expResult, result);
     
    }
    @Test
    public void testGetRequestReplyById_UTC3() {
        System.out.println("getRequestReplyById");
        int rqId = -1;
        RequestDAO instance = new RequestDAO();
        RequestReplyBean expResult = null;
        RequestReplyBean result = instance.getRequestReplyById(rqId);
        assertEquals(expResult, result);
     
    }
       @Test (expected = Exception.class)
    public void testGetRequestReplyById_UTC4() {
        System.out.println("getRequestReplyById");
        int rqId = Integer.parseInt("a");
        RequestDAO instance = new RequestDAO();
        RequestReplyBean expResult = null;
        RequestReplyBean result = instance.getRequestReplyById(rqId);
        assertEquals(expResult, result);
     
    }
    @Test
    public void testCreateRequest_UTC1() {
        System.out.println("createRequest");
        RequestBean rq = new RequestBean("minhduc07", "ducgiang", "Waiting", 20000, "debai so n", "img", 1, 12, "giai toan co loi van");
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        int result = instance.createRequest(rq);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testCreateRequest_UTC2() {
        System.out.println("createRequest");
        RequestBean rq = new RequestBean("minhduc07", "ducgiang", "Done", -20000, "debai so n", "img", -1, 12, "giai toan co loi van");
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.createRequest(rq);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testCreateRequest_UTC3() {
        System.out.println("createRequest");
        RequestBean rq = new RequestBean();
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.createRequest(rq);
        assertEquals(expResult, result);
       
    }
    @Test (expected = Exception.class)
    public void testCreateRequest_UTC4() {
        System.out.println("createRequest");
        RequestBean rq = null;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.createRequest(rq);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateRequestReply_UTC1() {
        System.out.println("createRequestReply");
        RequestReplyBean rq = new RequestReplyBean(1024, "ducgiang", "minhduc07", "dap an", "/assets/image/");
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        int result = instance.createRequestReply(rq);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateRequestReply_UTC2() {
        System.out.println("createRequestReply");
        RequestReplyBean rq = new RequestReplyBean(-1, "ducgiang", "minhduc07", "dap an", "/assets/image/");
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.createRequestReply(rq);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateRequestReply_UTC3() {
        System.out.println("createRequestReply");
        RequestReplyBean rq = new RequestReplyBean();
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.createRequestReply(rq);
        assertEquals(expResult, result);
    }
    @Test (expected = Exception.class)
    public void testCreateRequestReply_UTC4() {
        System.out.println("createRequestReply");
        RequestReplyBean rq = null;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.createRequestReply(rq);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeleteRequest_UTC1() {
        System.out.println("deleteRequest");
        int rqId = 1033;
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        int result = instance.deleteRequest(rqId);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testDeleteRequest_UTC2() {
        System.out.println("deleteRequest");
        int rqId = 9999;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.deleteRequest(rqId);
        assertEquals(expResult, result);
       
    } 
    @Test 
    public void testDeleteRequest_UTC3() {
        System.out.println("deleteRequest");
        int rqId = -1;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.deleteRequest(rqId);
        assertEquals(expResult, result);
       
    }
    @Test (expected = Exception.class)
    public void testDeleteRequest_UTC4() {
        System.out.println("deleteRequest");
        int rqId = Integer.parseInt("a");
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.deleteRequest(rqId);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testDeleteRequestReply_UTC1() {
        System.out.println("deleteRequestReply");
        int rqId = 0;
        RequestDAO instance = new RequestDAO();
        instance.deleteRequestReply(rqId);
    }
            
    @Test
    public void testDeleteRequestReply_UTC2() {
        System.out.println("deleteRequestReply");
        int rqId = 0;
        RequestDAO instance = new RequestDAO();
        instance.deleteRequestReply(rqId);
    }
    @Test
    public void testDeleteRequestReply_UTC3() {
        System.out.println("deleteRequestReply");
        int rqId = 0;
        RequestDAO instance = new RequestDAO();
        instance.deleteRequestReply(rqId);
    }
        
    @Test
    public void testDeleteRequestReply_UTC4() {
        System.out.println("deleteRequestReply");
        int rqId = 0;
        RequestDAO instance = new RequestDAO();
        instance.deleteRequestReply(rqId);
    }
    @Test
    public void testGetRequestForStudent() {
        System.out.println("getRequestForStudent");
        String username = "minhduc07";
        String rqStatus = "Approved";
        int pageindex = 1;
        int pagesize = 10;
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        ArrayList<RequestBean> result = instance.getRequestForStudent(username, rqStatus, pageindex, pagesize);
        assertEquals(expResult, result.size());
    }
    
       
    @Test
    public void testGetRequestForTeacher_4args_1() {
        System.out.println("getRequestForTeacher");
        int subjectId = 1;
        String rqStatus = "Waiting";
        int pageindex = 1;
        int pagesize = 10;
        RequestDAO instance = new RequestDAO();
        int expResult = 3;
        ArrayList<RequestBean> result = instance.getRequestForTeacher(subjectId, rqStatus, pageindex, pagesize);
        assertEquals(expResult, result.size());
    }

    @Test
    public void testGetRequestForTeacher_4args_2() {
        System.out.println("getRequestForTeacher");
        String username = "ducgiang";
        String rqStatus = "Approved";
        int pageindex = 1;
        int pagesize = 10;
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        ArrayList<RequestBean> result = instance.getRequestForTeacher(username, rqStatus, pageindex, pagesize);
        assertEquals(expResult, result.size());
    }

    @Test
    public void testGetRequestBySubject() {
        System.out.println("getRequestBySubject");
        int subjectId = 1;
        RequestDAO instance = new RequestDAO();
        int expResult = 4;
        ArrayList<RequestBean> result = instance.getRequestBySubject(subjectId);
        assertEquals(expResult, result.size());
    }


    @Test
    public void testGetRequestSearchForStudent() {
        System.out.println("getRequestSearchForStudent");
        String username = "minhduc07";
        String rqStatus = "Waiting";
        String searchString = "title";
        int pageindex = 1;
        int pagesize = 10;
        RequestDAO instance = new RequestDAO();
        int expResult = 3;
        ArrayList<RequestBean> result = instance.getRequestSearchForStudent(username, rqStatus, searchString, pageindex, pagesize);
        assertEquals(expResult, result.size());
        
    }


    @Test
    public void testGetRequestSearchForTeacher_5args_1() {
        System.out.println("getRequestSearchForTeacher");
        String username = "ducgiang";
        String rqStatus = "Approved";
        String searchString = "title";
        int pageindex = 1;
        int pagesize = 10;
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        ArrayList<RequestBean> result = instance.getRequestSearchForTeacher(username, rqStatus, searchString, pageindex, pagesize);
        assertEquals(expResult, result.size());
        
    }

    @Test
    public void testGetRequestSearchForTeacher_5args_2() {
        System.out.println("getRequestSearchForTeacher");
        int subjectId = 1;
        String rqStatus = "Approved";
        String searchString = "title";
        int pageindex = 1;
        int pagesize = 10;
        RequestDAO instance = new RequestDAO();
        int expResult = 1;
        ArrayList<RequestBean> result = instance.getRequestSearchForTeacher(subjectId, rqStatus, searchString, pageindex, pagesize);
        assertEquals(expResult, result.size());
  
    }
    
}
