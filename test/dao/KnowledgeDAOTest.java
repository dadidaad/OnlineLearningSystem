/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * KnowledgeDAOTest 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-26   1.0         Doan Tu    First Implement
 */
package dao;

import bean.KnowledgeBean;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contain method to Test KnowledgeDAO
 * 
 * @author Doan Tu
 */
public class KnowledgeDAOTest {
    
    public KnowledgeDAOTest() {
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
     * Test of getByChapterId method, of class KnowledgeDAO.
     */
    @Test
    public void testGetByChapterId() throws SQLException {
        System.out.println("getByChapterId");
        int chapId = 0;
        KnowledgeDAO instance = new KnowledgeDAO();
        ArrayList<KnowledgeBean> expResult = null;
        ArrayList<KnowledgeBean> result = instance.getByChapterId(chapId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfKnowledgeByChpaterId method, of class KnowledgeDAO.
     */
    @Test
    public void testGetNumberOfKnowledgeByChpaterId() throws SQLException {
        System.out.println("getNumberOfKnowledgeByChpaterId");
        int chapId = 1;
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 5;
        int result = instance.getNumberOfKnowledgeByChpaterId(chapId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumberOfKnowledgeByChpaterId method if this chapter is unknown, of class KnowledgeDAO.
     */
    @Test
    public void testGetNumberOfKnowledgeByUnknownChpaterId() throws SQLException {
        System.out.println("getNumberOfKnowledgeByChpaterId");
        int chapId = 7;
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.getNumberOfKnowledgeByChpaterId(chapId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumberOfKnowledgeByChpaterId method if this chapter is unknown, of class KnowledgeDAO.
     */
    @Test
    public void testGetNumberOfKnowledgeByUnknownChpaterId2() throws SQLException {
        System.out.println("getNumberOfKnowledgeByChpaterId");
        int chapId = 0;
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.getNumberOfKnowledgeByChpaterId(chapId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumbberOfKnowledge method, of class KnowledgeDAO.
     */
    @Test
    public void testGetNumbberOfKnowledge() throws SQLException {
        System.out.println("getNumbberOfKnowledge");
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 38;
        int result = instance.getNumbberOfKnowledge();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumbberOfKnowledge method if No data in database, of class KnowledgeDAO.
     */
    @Test
    public void testGetNumbberOfKnowledgeWithNoData() throws SQLException {
        System.out.println("getNumbberOfKnowledge");
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.getNumbberOfKnowledge();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createKnowledge method, of class KnowledgeDAO.
     */
    @Test
    public void testCreateKnowledge() throws SQLException {
        System.out.println("createKnowledge");
        KnowledgeBean knowledge = new KnowledgeBean(41, "New Knowledge", "Content", 1);
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 1;
        int result = instance.createKnowledge(knowledge);
        assertEquals(expResult, result);
    }

    /**
     * Test of createKnowledge method with Empty KnowledgeBean, of class KnowledgeDAO.
     */
    @Test
    public void testCreateKnowledgeWithEmpty() throws SQLException {
        System.out.println("createKnowledge");
        KnowledgeBean knowledge = new KnowledgeBean();
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.createKnowledge(knowledge);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createKnowledge method with Null, of class KnowledgeDAO.
     */
    @Test(expected = Exception.class)
    public void testCreateKnowledgeWithNull() throws SQLException {
        System.out.println("createKnowledge");
        KnowledgeBean knowledge = null;
        KnowledgeDAO instance = new KnowledgeDAO();
        instance.createKnowledge(knowledge);
    }
    
    /**
     * Test of searchByKnowledgeNameOfChap method, of class KnowledgeDAO.
     */
    @Test
    public void testSearchByKnowledgeNameOfChap() throws SQLException {
        System.out.println("searchByKnowledgeNameOfChap");
        String knowledgeName = "Khái niệm tập hợp";
        int chapId = 1;
        KnowledgeDAO instance = new KnowledgeDAO();
        boolean expResult = false;
        boolean result = instance.searchByKnowledgeNameOfChap(knowledgeName, chapId);
        assertEquals(expResult, result);
    }
  
    /**
     * Test of searchByKnowledgeNameOfChap method with Another Knowledge Name, of class KnowledgeDAO.
     */
    @Test
    public void testSearchByKnowledgeNameOfChapWithAnotherKnowledge() throws SQLException {
        System.out.println("searchByKnowledgeNameOfChap");
        String knowledgeName = "New Knowledge";
        int chapId = 1;
        KnowledgeDAO instance = new KnowledgeDAO();
        boolean expResult = true;
        boolean result = instance.searchByKnowledgeNameOfChap(knowledgeName, chapId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of searchByKnowledgeNameOfChap method with Another Chapter ID, of class KnowledgeDAO.
     */
    @Test
    public void testSearchByKnowledgeNameOfChapWithAnotherChap() throws SQLException {
        System.out.println("searchByKnowledgeNameOfChap");
        String knowledgeName = "Khái niệm tập hợp";
        int chapId = 2;
        KnowledgeDAO instance = new KnowledgeDAO();
        boolean expResult = true;
        boolean result = instance.searchByKnowledgeNameOfChap(knowledgeName, chapId);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateKnowledge method, of class KnowledgeDAO.
     */
    @Test
    public void testUpdateKnowledge() throws Exception {
        System.out.println("updateKnowledge");
        KnowledgeBean knowledge = new KnowledgeBean(42, "demoknowledge", "content", 19);
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 1;
        int result = instance.updateKnowledge(knowledge);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateKnowledgeWithEmpty() throws Exception {
        System.out.println("updateKnowledge");
        KnowledgeBean knowledge = new KnowledgeBean();
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.updateKnowledge(knowledge);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateKnowledgeWithNonExistedKnowledge() throws Exception {
        System.out.println("updateKnowledge");
        KnowledgeBean knowledge = new KnowledgeBean(50, "demoknowledge", "content", 19);
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.updateKnowledge(knowledge);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testUpdateKnowledgeWithNull() throws Exception {
        System.out.println("updateKnowledge");
        KnowledgeBean knowledge = null;
        KnowledgeDAO instance = new KnowledgeDAO();
        instance.updateKnowledge(knowledge);
    }
    /**
     * Test of getKnowledgeById method, of class KnowledgeDAO.
     */
    @Test
    public void testGetKnowledgeById() throws Exception {
        System.out.println("getKnowledgeById");
        int knowledgeID = 1;
        KnowledgeDAO instance = new KnowledgeDAO();
        KnowledgeBean expResult = new KnowledgeBean(1, "Khái niệm tập hợp", "assets/image/Algebra/Menh de Tap hop/Khai niem tap hop.png", 1);
        KnowledgeBean result = instance.getKnowledgeById(knowledgeID);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetKnowledgeByIdWithNonExistedID() throws Exception {
        System.out.println("getKnowledgeById");
        int knowledgeID = 50;
        KnowledgeDAO instance = new KnowledgeDAO();
        KnowledgeBean expResult = new KnowledgeBean();
        KnowledgeBean result = instance.getKnowledgeById(knowledgeID);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetKnowledgeByIdWithZero() throws Exception {
        System.out.println("getKnowledgeById");
        int knowledgeID = 0;
        KnowledgeDAO instance = new KnowledgeDAO();
        KnowledgeBean expResult = new KnowledgeBean();
        KnowledgeBean result = instance.getKnowledgeById(knowledgeID);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteKnowledgeById method, of class KnowledgeDAO.
     */
    @Test
    public void testDeleteKnowledgeById() throws Exception {
        System.out.println("deleteKnowledgeById");
        int knowledgeId = 44;
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 1;
        int result = instance.deleteKnowledgeById(knowledgeId);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteKnowledgeByIdWithNonExistedKnowledge() throws Exception {
        System.out.println("deleteKnowledgeById");
        int knowledgeId = 50;
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.deleteKnowledgeById(knowledgeId);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteKnowledgeByIdWithZero() throws Exception {
        System.out.println("deleteKnowledgeById");
        int knowledgeId = 0;
        KnowledgeDAO instance = new KnowledgeDAO();
        int expResult = 0;
        int result = instance.deleteKnowledgeById(knowledgeId);
        assertEquals(expResult, result);
    }
}
