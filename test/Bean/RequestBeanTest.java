package Bean;

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
public class RequestBeanTest {
    
    public RequestBeanTest() {
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

    

    /**
     * Test of getRequestID method, of class RequestBean.
     */
    @Test
    public void testGetRequestID() {
        RequestBean instance = new RequestBean();
        int expResult = 0;
        int result = instance.getRequestID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRequestID method, of class RequestBean.
     */
    @Test
    public void testSetRequestID() {
        int requestID = 10;
        RequestBean instance = new RequestBean();
        instance.setRequestID(requestID);
        int expected = 10;
        int result = instance.getRequestID();
        assertEquals(expected, result);
    }

    /**
     * Test of getStudentSent method, of class RequestBean.
     */
    @Test
    public void testGetStudentSent() {
        RequestBean instance = new RequestBean();
        String expResult = null;
        String result = instance.getStudentSent();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setStudentSent method, of class RequestBean.
     */
    @Test
    public void testSetStudentSent() {
        String studentSent = "minhduc";
        RequestBean instance = new RequestBean();
        instance.setStudentSent(studentSent);
        String studentExpt = "minhduc";
        assertEquals(studentExpt, instance.getStudentSent());
    }

    /**
     * Test of getTutorGet method, of class RequestBean.
     */
    @Test
    public void testGetTutorGet() {
        RequestBean instance = new RequestBean();
        String expResult = null;
        String result = instance.getTutorGet();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setTutorGet method, of class RequestBean.
     */
    @Test
    public void testSetTutorGet() {
        System.out.println("setTutorGet");
        String tutorGet = "minhanh";
        RequestBean instance = new RequestBean();
        instance.setTutorGet(tutorGet);
        String tutorGetExpt = "minhanh";
        String result = instance.getTutorGet();
        
        assertEquals(tutorGetExpt, result);
    }

    /**
     * Test of getCreatedTime method, of class RequestBean.
     */
    @Test
    public void testGetCreatedTime() {
        RequestBean instance = new RequestBean();
        Date expResult = null;
        Date result = instance.getCreatedTime();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCreatedTime method, of class RequestBean.
     */
    @Test
    public void testSetCreatedTime() {
        RequestBean instance = new RequestBean();
        instance.setCreatedTime(null);
        
        Date expected = null;
        Date result = instance.getCreatedTime();
        
        assertEquals(expected, result);
        
        
    }

    /**
     * Test of getStatus method, of class RequestBean.
     */
    @Test
    public void testGetStatus() {
        RequestBean instance = new RequestBean();
        String expResult = null;
        String result = instance.getStatus();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setStatus method, of class RequestBean.
     */
    @Test
    public void testSetStatus() {
        String status = "Waiting";
        RequestBean instance = new RequestBean();
        instance.setStatus(status);
        String expected = "Waiting";
        String result = instance.getStatus();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getCost method, of class RequestBean.
     */
    @Test
    public void testGetCost() {
        RequestBean instance = new RequestBean();
        int expResult = 0;
        int result = instance.getCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCost method, of class RequestBean.
     */
    @Test
    public void testSetCost() {
        int cost = 10000;
        RequestBean instance = new RequestBean();
        instance.setCost(cost);
        int expected = 10000;
        int result = instance.getCost();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getContent method, of class RequestBean.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        RequestBean instance = new RequestBean();
        String expResult = null;
        String result = instance.getContent();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setContent method, of class RequestBean.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "Topic";
        RequestBean instance = new RequestBean();
        instance.setContent(content);
        
        String expected = "Topic";
        String result = instance.getContent();
        
        assertEquals(expected, result);
        
    }

    /**
     * Test of getImageLink method, of class RequestBean.
     */
    @Test
    public void testGetImageLink() {
        RequestBean instance = new RequestBean();
        String expResult = null;
        String result = instance.getImageLink();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setImageLink method, of class RequestBean.
     */
    @Test
    public void testSetImageLink() {
        String imageLink = "imgLink";
        RequestBean instance = new RequestBean();
        instance.setImageLink(imageLink);
         
        String expected = "imgLink";
        String result = instance.getImageLink();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getSubjectID method, of class RequestBean.
     */
    @Test
    public void testGetSubjectID() {
        RequestBean instance = new RequestBean();
        int expResult = 0;
        int result = instance.getSubjectID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSubjectID method, of class RequestBean.
     */
    @Test
    public void testSetSubjectID() {
        
        int subjectID = 1;
        RequestBean instance = new RequestBean();
        instance.setSubjectID(subjectID);
        
        int expected = 1;
        int result = instance.getSubjectID();
        assertEquals(expected, result);
    }

    /**
     * Test of getTitle method, of class RequestBean.
     */
    @Test
    public void testGetTitle() {
    
        RequestBean instance = new RequestBean();
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setTitle method, of class RequestBean.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "title";
        RequestBean instance = new RequestBean();
        instance.setTitle(title);
        
        String expected = "title";
        String result = instance.getTitle();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getLevel method, of class RequestBean.
     */
    @Test
    public void testGetLevel() {
        RequestBean instance = new RequestBean();
        int expResult = 0;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLevel method, of class RequestBean.
     */
    @Test
    public void testSetLevel() {
        int level = 10;
        RequestBean instance = new RequestBean();
        instance.setLevel(level);
        
        int expected = 10;
        int result = instance.getLevel();
        
        assertEquals(expected, result);
    }
    

    
}
