/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectDAOTest 
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-26   1.0         Doan Tu    First Implement
 */
package dao;

import bean.SubjectBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contain method to Test SubjectDAO
 * 
 * @author Doan Tu
 */
public class SubjectDAOTest {
    
    public SubjectDAOTest() {
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
     * Test of getAllSubject method, of class SubjectDAO.
     */
    @Test
    public void testGetAllSubject() throws Exception {
        System.out.println("getAllSubject");
        SubjectDAO instance = new SubjectDAO();
        ArrayList<SubjectBean> expResult = new ArrayList<>();
        ArrayList<SubjectBean> result = instance.getAllSubject();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSubjectNames method, of class SubjectDAO.
     */
    @Test
    public void testGetSubjectNames() throws SQLException {
        System.out.println("getSubjectNames");
        SubjectDAO instance = new SubjectDAO();
        Map<Integer, String> expResult = null;
        Map<Integer, String> result = instance.getSubjectNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfSubject method, of class SubjectDAO.
     */
    @Test
    public void testGetNumberOfSubject() throws SQLException {
        System.out.println("getNumberOfSubject");
        SubjectDAO instance = new SubjectDAO();
        int expResult = 9;
        int result = instance.getNumberOfSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfSubject method with No data, of class SubjectDAO.
     */
    @Test
    public void testGetNumberOfSubjectWithNoData() throws SQLException {
        System.out.println("getNumberOfSubject");
        SubjectDAO instance = new SubjectDAO();
        int expResult = 0;
        int result = instance.getNumberOfSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchBySubName method, of class SubjectDAO.
     */
    @Test
    public void testSearchBySubName() throws SQLException {
        System.out.println("searchBySubName");
        String subName = "Algebra";
        SubjectDAO instance = new SubjectDAO();
        boolean expResult = false;
        boolean result = instance.searchBySubName(subName);
        assertEquals(expResult, result);
    }
    /**
     * Test of searchBySubName method with null value, of class SubjectDAO.
     */
    @Test
    public void testSearchBySubNameNull() throws SQLException {
        System.out.println("searchBySubName");
        String subName = null;
        SubjectDAO instance = new SubjectDAO();
        boolean expResult = true;
        boolean result = instance.searchBySubName(subName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of searchBySubName method with false value, of class SubjectDAO.
     */
    @Test
    public void testSearchBySubNameFalse() throws SQLException {
        System.out.println("searchBySubName");
        String subName = "Modern Physics";
        SubjectDAO instance = new SubjectDAO();
        boolean expResult = true;
        boolean result = instance.searchBySubName(subName);
        assertEquals(expResult, result);
    }

    /**
     * Test of createNewSubject method with Empty, of class SubjectDAO.
     */
    @Test
    public void testCreateNewSubjectEmpty() throws SQLException {
        System.out.println("createNewSubject");
        SubjectBean subject = new SubjectBean();
        SubjectDAO instance = new SubjectDAO();
        instance.createNewSubject(subject);
        int expResult = 0;
        int result =instance.createNewSubject(subject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createNewSubject method, of class SubjectDAO.
     */
    @Test
    public void testCreateNewSubject() throws SQLException {
        System.out.println("createNewSubject");
        SubjectBean subject = new SubjectBean(10,"Modern Physic","description", "image");
        SubjectDAO instance = new SubjectDAO();
        instance.createNewSubject(subject);
        int expResult = 1;
        int result =instance.createNewSubject(subject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createNewSubject method with Null value, of class SubjectDAO.
     */
    @Test(expected = Exception.class)
    public void testCreateNewSubjectNull() throws SQLException {
        System.out.println("createNewSubject");
        SubjectBean subject = null;
        SubjectDAO instance = new SubjectDAO();
        instance.createNewSubject(subject);
    }

    /**
     * Test of getSubjectById method with Boundary value, of class SubjectDAO.
     */
    @Test
    public void testGetSubjectByIdWithBoundary() throws SQLException{
        System.out.println("getSubjectById");
        int subId = 0;
        SubjectDAO instance = new SubjectDAO();
        String expResult = new SubjectBean().toString();
        String result = instance.getSubjectById(subId).toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSubjectById method with Boundary value, of class SubjectDAO.
     */
    @Test
    public void testGetSubjectByIdWithBoundary2() throws SQLException{
        System.out.println("getSubjectById");
        int subId = 10;
        SubjectDAO instance = new SubjectDAO();
        String expResult = new SubjectBean().toString();
        String result = instance.getSubjectById(subId).toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSubjectById method, of class SubjectDAO.
     */
    @Test
    public void testGetSubjectById() throws SQLException{
        System.out.println("getSubjectById");
        int subId = 1;
        SubjectDAO instance = new SubjectDAO();
        String expResult = new SubjectBean(1, "Algebra", "Algebra is a large "
                + "branch of mathematics, along with number theory, geometry, and "
                + "analysis. In the most general sense, algebra is the study of "
                + "mathematical notation and the rules for manipulating these symbols "
                + "| it is a unifying topic across almost all areas of mathematics As "
                + "such, algebra encompasses everything from solving elementary-level "
                + "equations to abstract studies like groups, rings, and fields, "
                + "This will be the subject you learn really care full in high school", "assets/image/Algebra.jpg").toString();
        String result = instance.getSubjectById(subId).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateSubject method, of class SubjectDAO.
     */
    @Test
    public void testUpdateSubject() throws Exception {
        System.out.println("updateSubject");
        SubjectBean subject = new SubjectBean(11, "demosubject2", "description", "image");
        SubjectDAO instance = new SubjectDAO();
        int expResult = 1;
        int result = instance.updateSubject(subject);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateSubjectWithEmpty() throws Exception {
        System.out.println("updateSubject");
        SubjectBean subject = new SubjectBean();
        SubjectDAO instance = new SubjectDAO();
        int expResult = 0;
        int result = instance.updateSubject(subject);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateSubjectWithNonExistedSubject() throws Exception {
        System.out.println("updateSubject");
        SubjectBean subject = new SubjectBean(13, "demosubject2", "description", "image");
        SubjectDAO instance = new SubjectDAO();
        int expResult = 0;
        int result = instance.updateSubject(subject);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testUpdateSubjectWithNull() throws Exception {
        System.out.println("updateSubject");
        SubjectBean subject = null;
        SubjectDAO instance = new SubjectDAO();
        instance.updateSubject(subject);

    }

    /**
     * Test of deleteSubject method, of class SubjectDAO.
     */
    @Test
    public void testDeleteSubject() throws Exception {
        System.out.println("deleteSubject");
        int subId = 11;
        SubjectDAO instance = new SubjectDAO();
        int expResult = 0;
        int result = instance.deleteSubject(subId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteSubjectWithNonExistedSubject() throws Exception {
        System.out.println("deleteSubject");
        int subId = 20;
        SubjectDAO instance = new SubjectDAO();
        int expResult = 0;
        int result = instance.deleteSubject(subId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteSubjectWithZero() throws Exception {
        System.out.println("deleteSubject");
        int subId = 0;
        SubjectDAO instance = new SubjectDAO();
        int expResult = 0;
        int result = instance.deleteSubject(subId);
        assertEquals(expResult, result);
    }

}
