/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * KnowledgeBean Test 
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
 * This class use to test all get set and toString method of KnowledgeBean
 * @author Doan Tu
 */
public class KnowledgeBeanTest {
    
    public KnowledgeBeanTest() {
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
     * Test of getKnowledgeID method, of class KnowledgeBean.
     */
    @Test
    public void testGetKnowledgeID() {
        KnowledgeBean instance = new KnowledgeBean();
        int expResult = 0;
        int result = instance.getKnowledgeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKnowledgeID method, of class KnowledgeBean.
     */
    @Test
    public void testSetKnowledgeID() {
        int knowledgeID = 1;
        KnowledgeBean instance = new KnowledgeBean();
        instance.setKnowledgeID(knowledgeID);
        
        int expected = 1;
        int result = instance.getKnowledgeID();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getKnowledgeName method, of class KnowledgeBean.
     */
    @Test
    public void testGetKnowledgeName() {
        KnowledgeBean instance = new KnowledgeBean();
        String expResult = null;
        String result = instance.getKnowledgeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKnowledgeName method, of class KnowledgeBean.
     */
    @Test
    public void testSetKnowledgeName() {
        String knowledgeName = "Important Definiton";
        KnowledgeBean instance = new KnowledgeBean();
        instance.setKnowledgeName(knowledgeName);
        
        String expected = "Important Definiton";
        String result = instance.getKnowledgeName();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getKnowledgeContent method, of class KnowledgeBean.
     */
    @Test
    public void testGetKnowledgeContent() {
        KnowledgeBean instance = new KnowledgeBean();
        String expResult = null;
        String result = instance.getKnowledgeContent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKnowledgeContent method, of class KnowledgeBean.
     */
    @Test
    public void testSetKnowledgeContent() {
        String knowledgeContent = "/assets/image/Algebra/Menh de Tap hop/Khai niem tap hop.png";
        KnowledgeBean instance = new KnowledgeBean();
        instance.setKnowledgeContent(knowledgeContent);
        
        String expected = "/assets/image/Algebra/Menh de Tap hop/Khai niem tap hop.png";
        String result = instance.getKnowledgeContent();
        
        assertEquals(expected, result);
    }

    /**
     * Test of getChapterID method, of class KnowledgeBean.
     */
    @Test
    public void testGetChapterID() {
        KnowledgeBean instance = new KnowledgeBean();
        int expResult = 0;
        int result = instance.getChapterID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChapterID method, of class KnowledgeBean.
     */
    @Test
    public void testSetChapterID() {
        int chapterID = 1;
        KnowledgeBean instance = new KnowledgeBean();
        instance.setChapterID(chapterID);
        
        int expected = 1;
        int result = instance.getChapterID();
    }

    /**
     * Test of toString method, of class KnowledgeBean.
     */
    @Test
    public void testToString() {
        KnowledgeBean instance = new KnowledgeBean();
        instance.setKnowledgeID(1);
        instance.setKnowledgeName("Important Definition");
        instance.setKnowledgeContent("/assets/image/Algebra/Menh de Tap hop/Khai niem tap hop.png");
        instance.setChapterID(1);
        String expResult = "KnowledgeBean{knowledgeID=1, knowledgeName=Important Definition, knowledgeContent=/assets/image/Algebra/Menh de Tap hop/Khai niem tap hop.png, chapterID=1}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
