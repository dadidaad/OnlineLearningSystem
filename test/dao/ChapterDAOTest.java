/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ChapterDAOTest 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-26   1.0         Doan Tu    First Implement
 */
package dao;

import dao.ChapterDAO;
import bean.ChapterBean;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contain method to Test ChapterDAO
 * 
 * @author Doan Tu
 */
public class ChapterDAOTest {
    
    public ChapterDAOTest() {
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
     * Test of getBySubId method, of class ChapterDAO.
     */
    @Test
    public void testGetBySubId() {
        System.out.println("getBySubId");
        int subId = 0;
        ChapterDAO instance = new ChapterDAO();
        ArrayList<ChapterBean> expResult = null;
        ArrayList<ChapterBean> result = instance.getBySubId(subId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getChapterById method, of class ChapterDAO.
     */
    @Test
    public void testGetChapterById() {
        System.out.println("getChapterById");
        int chapId = 1;
        ChapterDAO instance = new ChapterDAO();
        ChapterBean expResult = new ChapterBean(1, "Clauses and Sets", 0, "This chapter will strengthen "
                + "and expand students' understanding of set theory learned in lower grades; provides "
                + "the initial knowledge of logic and the concepts of approximate and error numbers, "
                + "creating a basis for good learning in the following chapters.", 1);
        ChapterBean result = instance.getChapterById(chapId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getChapterById method with Boundary value, of class ChapterDAO.
     */
    @Test
    public void testGetChapterByIdBoundary() {
        System.out.println("getChapterById");
        int chapId = 0;
        ChapterDAO instance = new ChapterDAO();
        ChapterBean expResult = new ChapterBean();
        ChapterBean result = instance.getChapterById(chapId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getChapterById method with Boundary, of class ChapterDAO.
     */
    @Test
    public void testGetChapterByIdBoundary2() {
        System.out.println("getChapterById");
        int chapId = 19;
        ChapterDAO instance = new ChapterDAO();
        ChapterBean expResult = new ChapterBean();
        ChapterBean result = instance.getChapterById(chapId);
        assertEquals(expResult, result);
    }
    /**
     * Test of getNumberOfChapterById method, of class ChapterDAO.
     */
    @Test
    public void testGetNumberOfChapterById() {
        System.out.println("getNumberOfChapterById");
        int subId = 0;
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.getNumberOfChapterById(subId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfChapter method, of class ChapterDAO.
     */
    @Test
    public void testGetNumberOfChapter() {
        System.out.println("getNumberOfChapter");
        ChapterDAO instance = new ChapterDAO();
        int expResult = 18;
        int result = instance.getNumberOfChapter();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumberOfChapter method with No data, of class ChapterDAO.
     */
    @Test
    public void testGetNumberOfChapterWithNoData() {
        System.out.println("getNumberOfChapter");
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.getNumberOfChapter();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchByChapNameOfSubject method, of class ChapterDAO.
     */
    @Test
    public void testSearchByChapNameOfSubject() {
        System.out.println("searchByChapNameOfSubject");
        String chapName = "Clauses and Sets";
        int subId = 1;
        ChapterDAO instance = new ChapterDAO();
        boolean expResult = false;
        boolean result = instance.searchByChapNameOfSubject(chapName, subId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of searchByChapNameOfSubject method with another Subject ID, of class ChapterDAO.
     */
    @Test
    public void testSearchByChapNameOfSubjectWithAnotherSub() {
        System.out.println("searchByChapNameOfSubject");
        String chapName = "Clauses and Sets";
        int subId = 2;
        ChapterDAO instance = new ChapterDAO();
        boolean expResult = true;
        boolean result = instance.searchByChapNameOfSubject(chapName, subId);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchByChapNameOfSubject method with another Chapter name, of class ChapterDAO.
     */
    @Test
    public void testSearchByChapNameOfSubjectWithAnotherChap() {
        System.out.println("searchByChapNameOfSubject");
        String chapName = "New Chap Name";
        int subId = 1;
        ChapterDAO instance = new ChapterDAO();
        boolean expResult = true;
        boolean result = instance.searchByChapNameOfSubject(chapName, subId);
        assertEquals(expResult, result);
    }
    /**
     * Test of CreateChapter method, of class ChapterDAO.
     */
    @Test
    public void testCreateChapter() {
        System.out.println("CreateChapter");
        ChapterBean chapter = new ChapterBean(19, "ChapterName", 0, "Content", 1);
        ChapterDAO instance = new ChapterDAO();
        int expResult = 1;
        int result = instance.createChapter(chapter);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of CreateChapter method With Empty ChapterBean, of class ChapterDAO.
     */
    @Test
    public void testCreateChapterWithEmpty() {
        System.out.println("CreateChapter");
        ChapterBean chapter = new ChapterBean();
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.createChapter(chapter);
        assertEquals(expResult, result);
    }

    /**
     * Test of CreateChapter method With Null ChapterBean, of class ChapterDAO.
     */
    @Test(expected = Exception.class)
    public void testCreateChapterWithNull() {
        System.out.println("CreateChapter");
        ChapterBean chapter = null;
        ChapterDAO instance = new ChapterDAO();
        instance.createChapter(chapter);
    }
}
