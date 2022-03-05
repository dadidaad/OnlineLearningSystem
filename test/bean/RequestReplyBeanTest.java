package bean;

import bean.RequestReplyBean;
import java.sql.Date;
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
public class RequestReplyBeanTest {
    
    public RequestReplyBeanTest() {
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

  

    @Test
    public void testGetRequestID() {
        RequestReplyBean instance = new RequestReplyBean();
        int expResult = 1;
        int result = instance.getRequestID();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSetRequestID() {
        int requestID = 10;
        RequestReplyBean instance = new RequestReplyBean();
        instance.setRequestID(requestID);
        int expected = 10;
        int result = instance.getRequestID();
        
        assertEquals(expected, result);
    }

    @Test
    public void testGetTutorSent() {
        
        RequestReplyBean instance = new RequestReplyBean();
        String expResult = null;
        String result = instance.getTutorSent();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTutorSent() {
        System.out.println("setTutorSent");
        String tutorSent = "minhanh";
        RequestReplyBean instance = new RequestReplyBean();
        instance.setTutorSent(tutorSent);
        String tutorGetExpt = "minhanh";
        String result = instance.getTutorSent();
        
        assertEquals(tutorGetExpt, result);
    }

    @Test
    public void testGetStudentGet() {
        RequestReplyBean instance = new RequestReplyBean();
        String expected = null;
        String result = instance.getStudentGet();
        assertEquals(expected, result);
    }

    @Test
    public void testSetStudentGet() {
        System.out.println("setStudentGet");
        String studentGet = "minhduc";
        RequestReplyBean instance = new RequestReplyBean();
        instance.setStudentGet(studentGet);
        String expected = "minhduc";
        String result = instance.getStudentGet();
        assertEquals(expected, result);
    }

    @Test
    public void testGetCreatedTimeReply() {
        System.out.println("getCreatedTimeReply");
        RequestReplyBean instance = new RequestReplyBean();
        String expResult = null;
        Date result = instance.getCreatedTimeReply();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCreatedTimeReply() {
        System.out.println("setCreatedTimeReply");
        Date createdTimeReply = new Date(2022, 10, 2);
        RequestReplyBean instance = new RequestReplyBean();
        instance.setCreatedTimeReply(createdTimeReply);
        
        Date expected = new Date(2022, 10, 2);
        Date result = instance.getCreatedTimeReply();
        assertEquals(expected, result);
       
    }

    @Test
    public void testGetContentReply() {
        System.out.println("getContentReply");
        RequestReplyBean instance = new RequestReplyBean();
        String expResult = null;
        String result = instance.getContentReply();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetContentReply() {
        System.out.println("setContentReply");
        String contentReply = "minh";
        RequestReplyBean instance = new RequestReplyBean();
        instance.setContentReply(contentReply);
        
        
        String expected = "minh";
        String result = instance.getContentReply();
        assertEquals(expected, result);
    }

    @Test
    public void testGetImageLinkReply() {
        System.out.println("getImageLinkReply");
        RequestReplyBean instance = new RequestReplyBean();
        String expResult = null;
        String result = instance.getImageLinkReply();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetImageLinkReply() {
        String imageLinkReply = "img1";
        RequestReplyBean instance = new RequestReplyBean();
        instance.setImageLinkReply(imageLinkReply);
        
        String expected = "img1";
        String result = instance.getContentReply();
        assertEquals(expected, result);
    }
      @Test
    public void testToString() {
        System.out.println("toString");
        RequestReplyBean instance = new RequestReplyBean();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
