/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RecommendBean;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phong Vu
 */
public class RecommendDAOTest {
    
    public RecommendDAOTest() {
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
     * Test of createRecommend method, of class RecommendDAO.
     */
    @Test
    public void testCreateRecommend() throws Exception {
        System.out.println("createRecommend");
        RecommendBean recommend = new RecommendBean(3, "anhtuan", 1, true, "Description", "waiting");
        RecommendDAO instance = new RecommendDAO();
        int expResult = 1;
        int result = instance.createRecommend(recommend);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateRecommendWithEmpty() throws Exception {
        System.out.println("createRecommend");
        RecommendBean recommend = new RecommendBean();
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.createRecommend(recommend);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testCreateRecommendWithNull() throws Exception {
        System.out.println("createRecommend");
        RecommendBean recommend = null;
        RecommendDAO instance = new RecommendDAO();

        instance.createRecommend(recommend);
    }

    /**
     * Test of getByUsername method, of class RecommendDAO.
     */
    @Test
    public void testGetByUsername() throws Exception {
        System.out.println("getByUsername");
        String username = "anhtuan09";
        RecommendDAO instance = new RecommendDAO();
        ArrayList<RecommendBean> expResult = new ArrayList<>();
        expResult.add(new RecommendBean(1, "anhtuan09", 1, true, "Them kien thuc nay nha", "decline"));
        expResult.add(new RecommendBean(2, "anhtuan09", 2, false, "Them cai nay nhe", "accept"));
        ArrayList<RecommendBean> result = instance.getByUsername(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetByUsernameWithRandomName() throws Exception {
        System.out.println("getByUsername");
        String username = "random";
        RecommendDAO instance = new RecommendDAO();
        ArrayList<RecommendBean> expResult = new ArrayList<>();
        ArrayList<RecommendBean> result = instance.getByUsername(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetByUsernameWithNullValue() throws Exception {
        System.out.println("getByUsername");
        String username = null;
        RecommendDAO instance = new RecommendDAO();
        ArrayList<RecommendBean> expResult = new ArrayList<>();
        ArrayList<RecommendBean> result = instance.getByUsername(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetByUsernameWithEmptyString() throws Exception {
        System.out.println("getByUsername");
        String username = "";
        RecommendDAO instance = new RecommendDAO();
        ArrayList<RecommendBean> expResult = new ArrayList<>();
        ArrayList<RecommendBean> result = instance.getByUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberOfAccept method, of class RecommendDAO.
     */
    @Test
    public void testNumberOfAccept() throws Exception {
        System.out.println("numberOfAccept");
        String username = "anhtuan09";
        RecommendDAO instance = new RecommendDAO();
        int expResult = 1;
        int result = instance.numberOfAccept(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfAcceptWithEmpty() throws Exception {
        System.out.println("numberOfAccept");
        String username = "";
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.numberOfAccept(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfAcceptWithNull() throws Exception {
        System.out.println("numberOfAccept");
        String username = null;
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.numberOfAccept(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumberOfAcceptWithRandomName() throws Exception {
        System.out.println("numberOfAccept");
        String username = "random";
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.numberOfAccept(username);
        assertEquals(expResult, result);
    }
    /**
     * Test of numberOfDecline method, of class RecommendDAO.
     */
    @Test
    public void testNumberOfDecline() throws Exception {
        System.out.println("numberOfDecline");
        String username = "anhtuan09";
        RecommendDAO instance = new RecommendDAO();
        int expResult = 1;
        int result = instance.numberOfDecline(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfDeclineWithRandomName() throws Exception {
        System.out.println("numberOfDecline");
        String username = "random";
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.numberOfDecline(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfDeclineWithEmpty() throws Exception {
        System.out.println("numberOfDecline");
        String username = "";
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.numberOfDecline(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfDeclineWithNull() throws Exception {
        System.out.println("numberOfDecline");
        String username = null;
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.numberOfDecline(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getByAction method, of class RecommendDAO.
     */
    @Test
    public void testGetByActionFalse() throws Exception {
        System.out.println("getByAction");
        boolean action = false;
        RecommendDAO instance = new RecommendDAO();
        ArrayList<RecommendBean> expResult = new ArrayList<>();
        expResult.add(new RecommendBean(2, "anhtuan09", 2, false,"Them cai nay nhe", "accept"));
        ArrayList<RecommendBean> result = instance.getByAction(action);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetByActionTrue() throws Exception {
        System.out.println("getByAction");
        boolean action = true;
        RecommendDAO instance = new RecommendDAO();
        ArrayList<RecommendBean> expResult = new ArrayList<>();
        expResult.add(new RecommendBean(1, "anhtuan09", 1, true,"Them kien thuc nay nha", "decline"));
        ArrayList<RecommendBean> result = instance.getByAction(action);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of changeStatus method, of class RecommendDAO.
     */
    @Test
    public void testChangeStatusForWaiting() throws Exception {
        System.out.println("changeStatus");
        String status = "waiting";
        int RecId = 1;
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.changeStatus(status, RecId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeStatusForAccept() throws Exception {
        System.out.println("changeStatus");
        String status = "accept";
        int RecId = 1;
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.changeStatus(status, RecId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeStatusForDecline() throws Exception {
        System.out.println("changeStatus");
        String status = "decline";
        int RecId = 1;
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.changeStatus(status, RecId);
        assertEquals(expResult, result);
    }
    @Test(expected = Exception.class)
    public void testChangeStatusForNull() throws Exception {
        System.out.println("changeStatus");
        String status = null;
        int RecId = 1;
        RecommendDAO instance = new RecommendDAO();

        instance.changeStatus(status, RecId);

    }
    
    @Test
    public void testChangeStatusWithNonExistedID() throws Exception {
        System.out.println("changeStatus");
        String status = "waiting";
        int RecId = 10;
        RecommendDAO instance = new RecommendDAO();
        int expResult = 0;
        int result = instance.changeStatus(status, RecId);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testChangeStatusWithInvalidStatus() throws Exception {
        System.out.println("changeStatus");
        String status = "Random";
        int RecId = 1;
        RecommendDAO instance = new RecommendDAO();
        instance.changeStatus(status, RecId);
    }
   
}
