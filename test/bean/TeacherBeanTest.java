package bean;

import bean.TeacherBean;
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
public class TeacherBeanTest {
    
    public TeacherBeanTest() {
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
    public void testGetCvImg() {
        System.out.println("getCvImg");
        TeacherBean instance = new TeacherBean();
        String expResult = null;
        String result = instance.getCvImg();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetCvImg() {
        System.out.println("setCvImg");
        String cvImg = "img";
        TeacherBean instance = new TeacherBean();
        instance.setCvImg(cvImg);
        
        String expected = "img";
        String result = instance.getCvImg();
        assertEquals(expected, result);
    }

    @Test
    public void testGetSubjectId() {
        TeacherBean instance = new TeacherBean();
        int expResult = 0;
        int result = instance.getSubjectId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSubjectId() {
        System.out.println("setSubjectId");
        int subjectId = 10;
        TeacherBean instance = new TeacherBean();
        instance.setSubjectId(subjectId);
        
        int expected = 10;
        int result = instance.getSubjectId();
        assertEquals(expected, result);
    }
    
}
