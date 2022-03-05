/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectBean Test 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-12   1.0         Doan Tu    First Implement
 */
package bean;

import bean.ChapterBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class use to test all get set and toString method of ChapterBean
 * @author Doan Tu
 */
public class ChapterBeanTest {
    
    public ChapterBeanTest() {
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
     * Test of getChapterID method, of class ChapterBean.
     */
    @Test
    public void testGetChapterID() {
        ChapterBean instance = new ChapterBean();
        int expResult = 0;
        int result = instance.getChapterID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChapterID method, of class ChapterBean.
     */
    @Test
    public void testSetChapterID() {
        int chapterID = 1;
        ChapterBean instance = new ChapterBean();
        instance.setChapterID(chapterID);
        
        int expected = 1;
        int result = instance.getChapterID();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getChapterName method, of class ChapterBean.
     */
    @Test
    public void testGetChapterName() {
        ChapterBean instance = new ChapterBean();
        String expResult = null;
        String result = instance.getChapterName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChapterName method, of class ChapterBean.
     */
    @Test
    public void testSetChapterName() {
        String chapterName = "Clause and set";
        ChapterBean instance = new ChapterBean();
        instance.setChapterName(chapterName);
        
        String expected = "Clause and set";
        String result = instance.getChapterName();
    }

    /**
     * Test of getSemester method, of class ChapterBean.
     */
    @Test
    public void testGetSemester() {
        ChapterBean instance = new ChapterBean();
        int expResult = 0;
        int result = instance.getSemester();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSemester method, of class ChapterBean.
     */
    @Test
    public void testSetSemester() {
        int semester = 2;
        ChapterBean instance = new ChapterBean();
        instance.setSemester(semester);
        
        int expected = 2;
        int result=instance.getSemester();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getChapterContent method, of class ChapterBean.
     */
    @Test
    public void testGetChapterContent() {
        ChapterBean instance = new ChapterBean();
        String expResult = null;
        String result = instance.getChapterContent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChapterContent method, of class ChapterBean.
     */
    @Test
    public void testSetChapterContent() {
        String chapterContent = "Content demo";
        ChapterBean instance = new ChapterBean();
        instance.setChapterContent(chapterContent);

        String expected = "Content demo";
        String result=instance.getChapterContent();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getSubjectID method, of class ChapterBean.
     */
    @Test
    public void testGetSubjectID() {
        ChapterBean instance = new ChapterBean();
        int expResult = 0;
        int result = instance.getSubjectID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubjectID method, of class ChapterBean.
     */
    @Test
    public void testSetSubjectID() {
        int subjectID = 3;
        ChapterBean instance = new ChapterBean();
        instance.setSubjectID(subjectID);
        
        int expected  = 3;
        int result=instance.getSubjectID();
        
        assertEquals(expected, result);
    }

    /**
     * Test of toString method, of class ChapterBean.
     */
    @Test
    public void testToString() {
        ChapterBean instance = new ChapterBean();
        instance.setChapterID(1);
        instance.setChapterName("Clause and set");
        instance.setSemester(2);
        instance.setChapterContent("ContentDemo");
        instance.setSubjectID(3);
        String expResult = "ChapterBean{chapterID=1, ChapterName=Clause and set, semester=2, chapterContent=ContentDemo, subjectID=3}";
        String result = instance.toString();
    }
    
}
