/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.AccountBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Fields;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Admin
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountDAOTest {

    @Mock
    DataSource mockDataSource;
    @Mock
    Connection mockConn;
    @Mock
    PreparedStatement mockPreparedStmnt;
    @Mock
    ResultSet mockResultSet;
    int userId = 100;

    public AccountDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        when(mockDataSource.getConnection()).thenReturn(mockConn);
        when(mockDataSource.getConnection(anyString(), anyString())).thenReturn(mockConn);
        doNothing().when(mockConn).commit();
        when(mockConn.prepareStatement(anyString(), anyInt())).thenReturn(mockPreparedStmnt);
        doNothing().when(mockPreparedStmnt).setString(anyInt(), anyString());
        when(mockPreparedStmnt.execute()).thenReturn(Boolean.TRUE);
        when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDisplayNames method, of class AccountDAO.
     */
    @Test
    public void testGetDisplayNames() {
        System.out.println("getDisplayNames");
        AccountDAO instance = new AccountDAO();
        Map<String, String> expResult = null;
        Map<String, String> result = instance.getDisplayNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountByUsername method, of class AccountDAO.
     */
    @Test
    public void testGetAccountByUsername() {
        System.out.println("getAccountByUsername");
        String username = "";
        AccountDAO instance = new AccountDAO();
        AccountBean expResult = null;
        AccountBean result = instance.getAccountByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountByMail method, of class AccountDAO.
     */
    @Test
    public void testGetAccountByMail() {
        System.out.println("getAccountByMail");
        String email = "";
        AccountDAO instance = new AccountDAO();
        AccountBean expResult = null;
        AccountBean result = instance.getAccountByMail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateNewPassword method, of class AccountDAO.
     */
    @Test
    public void testUpdateNewPassword() {
        System.out.println("updateNewPassword");
        AccountBean account = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.updateNewPassword(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertNewAccount method, of class AccountDAO with null Data.
     */
    @Test(expected = Exception.class)
    public void testInsertNewAccountWithNullData() {
        System.out.println("testInsertNewAccountWithNullData");
        AccountBean account = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.insertNewAccount(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertNewAccount method, of class AccountDAO with empty Data.
     */
    @Test(expected = Exception.class)
    public void testInsertNewAccountWithEmptyData() {
        System.out.println("testInsertNewAccountWithEmptyData");
        AccountBean account = new AccountBean();
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.insertNewAccount(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertNewAccount method, of class AccountDAO with valid Data.
     */
    @Test(expected = Exception.class)
    public void testInsertNewAccountWithValidData() {
        System.out.println("testInsertNewAccountWithValidData");
        AccountBean account = new AccountBean();
        account.setUsername("test");
        account.setPassword("test");
        account.setMail("test@mail.com");
        account.setSex(true);
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.insertNewAccount(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AccountDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AccountDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
