/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectBean Test 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-12   1.0         Doan Tu    First Implement
 */
package Bean;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class use to test all get set and toString method of SubjectBean
 * @author Doan Tu
 */
public class SubjectBeanTest {
    
    public SubjectBeanTest() {
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
     * Test of getSubjectImage method, of class SubjectBean.
     */
    @Test
    public void testGetSubjectImage() {
        SubjectBean instance = new SubjectBean();
        String expResult = null;
        String result = instance.getSubjectImage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubjectImage method, of class SubjectBean.
     */
    @Test
    public void testSetSubjectImage() {
        String subjectImage = "assets/image/Algebra.png";
        SubjectBean instance = new SubjectBean();
        instance.setSubjectImage(subjectImage);
        String expected = "assets/image/Algebra.png";
        assertEquals(expected, instance.getSubjectImage());
    }

    /**
     * Test of getSubjectID method, of class SubjectBean.
     */
    @Test
    public void testGetSubjectID() {
        SubjectBean instance = new SubjectBean();
        int expResult = 0;
        int result = instance.getSubjectID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubjectID method, of class SubjectBean.
     */
    @Test
    public void testSetSubjectID() {
        int subjectID = 1;
        SubjectBean instance = new SubjectBean();
        instance.setSubjectID(subjectID);
        
        int expected = 1;
        int result = instance.getSubjectID();
        
        assertEquals(expected, result);
    }
    /**
     * Test of getSubjectName method, of class SubjectBean.
     */
    @Test
    public void testGetSubjectName() {
        SubjectBean instance = new SubjectBean();
        String expResult = null;
        String result = instance.getSubjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubjectName method, of class SubjectBean.
     */
    @Test
    public void testSetSubjectName() {
        String subjectName = "Algebra";
        SubjectBean instance = new SubjectBean();
        instance.setSubjectName(subjectName);
        
        String expected = "Algebra";
        String result = instance.getSubjectName();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getDescription method, of class SubjectBean.
     */
    @Test
    public void testGetDescription() {
        SubjectBean instance = new SubjectBean();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class SubjectBean.
     */
    @Test
    public void testSetDescription() {
        String description = "Description Demo";
        SubjectBean instance = new SubjectBean();
        instance.setDescription(description);
        
        String expected = "Description Demo";
        String result = instance.getDescription();
        
        assertEquals(expected, result);
    }

    /**
     * Test of toString method, of class SubjectBean.
     */
    @Test
    public void testToString() {
        SubjectBean instance = new SubjectBean();
        String expResult = "SubjectBean{subjectID=1, subjectName=Algebra, description=DescriptionDemo, subjectImage=assets/image/Algebra.png}";
        instance.setSubjectID(1);
        instance.setSubjectName("Algebra");
        instance.setDescription("DescriptionDemo");
        instance.setSubjectImage("assets/image/Algebra.png");
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
