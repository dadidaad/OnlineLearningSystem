/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ChapterDAOTest 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-26   1.0         Doan Tu    First Implement
 */
package dao;

import bean.ChapterBean;
import java.sql.SQLException;
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
    public void testGetBySubId() throws SQLException {
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
    public void testGetChapterById() throws SQLException {
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
    public void testGetChapterByIdBoundary() throws SQLException {
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
    public void testGetChapterByIdBoundary2() throws SQLException {
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
    public void testGetNumberOfChapterById() throws SQLException {
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
    public void testGetNumberOfChapter() throws SQLException {
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
    public void testGetNumberOfChapterWithNoData() throws SQLException {
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
    public void testSearchByChapNameOfSubject() throws SQLException {
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
    public void testSearchByChapNameOfSubjectWithAnotherSub() throws SQLException {
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
    public void testSearchByChapNameOfSubjectWithAnotherChap() throws SQLException {
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
    public void testCreateChapter() throws SQLException {
        System.out.println("CreateChapter");
        ChapterBean chapter = new ChapterBean(19, "ChapterName", 0, "Content", 1);
        ChapterDAO instance = new ChapterDAO();
        int expResult = 1;
        int result = instance.CreateChapter(chapter);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of CreateChapter method With Empty ChapterBean, of class ChapterDAO.
     */
    @Test
    public void testCreateChapterWithEmpty() throws SQLException {
        System.out.println("CreateChapter");
        ChapterBean chapter = new ChapterBean();
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.CreateChapter(chapter);
        assertEquals(expResult, result);
    }

    /**
     * Test of CreateChapter method With Null ChapterBean, of class ChapterDAO.
     */
    @Test(expected = Exception.class)
    public void testCreateChapterWithNull() throws SQLException {
        System.out.println("CreateChapter");
        ChapterBean chapter = null;
        ChapterDAO instance = new ChapterDAO();
        instance.CreateChapter(chapter);
    }

    /**
     * Test of updateChapter method, of class ChapterDAO.
     */
    @Test
    public void testUpdateChapter() throws Exception {
        System.out.println("updateChapter");
        ChapterBean chapter = new ChapterBean(21, "Update Name Chapter", 0, "Update COntent", 11);
        ChapterDAO instance = new ChapterDAO();
        int expResult = 1;
        int result = instance.updateChapter(chapter);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateChapterWithEmpty() throws Exception {
        System.out.println("updateChapter");
        ChapterBean chapter = new ChapterBean();
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.updateChapter(chapter);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateChapterWithNonExistedChpater() throws Exception {
        System.out.println("updateChapter");
        ChapterBean chapter = new ChapterBean(25, "Update Name Chapter", 0, "Update Content", 11);
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.updateChapter(chapter);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testUpdateChapterWithNull() throws Exception {
        System.out.println("updateChapter");
        ChapterBean chapter = null;
        ChapterDAO instance = new ChapterDAO();
        instance.updateChapter(chapter);
    }

    /**
     * Test of searchByChapName method, of class ChapterDAO.
     */
    @Test
    public void testSearchByChapName() throws Exception {
        System.out.println("searchByChapName");
        String chapName = "Clauses and Sets";
        ChapterDAO instance = new ChapterDAO();
        boolean expResult = false;
        boolean result = instance.searchByChapName(chapName);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchByChapNameWithNonExisted() throws Exception {
        System.out.println("searchByChapName");
        String chapName = "demoChapname";
        ChapterDAO instance = new ChapterDAO();
        boolean expResult = true;
        boolean result = instance.searchByChapName(chapName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSearchByChapNameWithNull() throws Exception {
        System.out.println("searchByChapName");
        String chapName = null;
        ChapterDAO instance = new ChapterDAO();
        boolean expResult = false;
        boolean result = instance.searchByChapName(chapName);
        assertEquals(expResult, result);
    }
    /**
     * Test of deleteChapterById method, of class ChapterDAO.
     */
    @Test
    public void testDeleteChapterById() throws Exception {
        System.out.println("deleteChapterById");
        int chapId = 21;
        ChapterDAO instance = new ChapterDAO();
        int expResult = 1;
        int result = instance.deleteChapterById(chapId);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testDeleteChapterByIdWithNonExistedChapter() throws Exception {
        System.out.println("deleteChapterById");
        int chapId = 30;
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.deleteChapterById(chapId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteChapterByIdWithNull() throws Exception {
        System.out.println("deleteChapterById");
        int chapId = 0;
        ChapterDAO instance = new ChapterDAO();
        int expResult = 0;
        int result = instance.deleteChapterById(chapId);
        assertEquals(expResult, result);
    }
}
