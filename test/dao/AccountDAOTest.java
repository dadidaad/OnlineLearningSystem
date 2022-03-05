/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.AccountDAO;
import bean.AccountBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

/**
 *
 * @author Admin
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountDAOTest {

    @Mock
    DataSource mockDataSource;
    @Mock
    Connection mockConn;
    @Mock
    PreparedStatement mockPreparedStmnt;
    @Mock
    ResultSet mockResultSet;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().silent();
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
        Map<String, String> expResult = new HashMap<>();
        expResult.put("test", "test");
        expResult.put("admin1", "admin1");
        expResult.put("admin2", "admin2");
        Map<String, String> result = instance.getDisplayNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
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
    }

    /**
     * Test of getAccountByMail method, of class AccountDAO.
     */
    @Test
    public void testGetAccountByNullMail() {
        System.out.println("getAccountByMail");
        String email = null;
        AccountDAO instance = new AccountDAO();
        AccountBean expResult = null;
        AccountBean result = instance.getAccountByMail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAccountByMail method, of class AccountDAO with empty mail.
     */
    @Test
    public void testGetAccountByEmptyMail() {
        System.out.println("getAccountByMail");
        String email = "";
        AccountDAO instance = new AccountDAO();
        AccountBean expResult = null;
        AccountBean result = instance.getAccountByMail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAccountByMail method, of class AccountDAO with empty mail.
     */
    @Test
    public void testGetAccountByValidMail() {
        System.out.println("getAccountByMail");
        String email = "dathp.proxy@gmail.com";
        AccountDAO instance = new AccountDAO();
        String expResullt = "dathp.proxy@gmail.com";
        AccountBean result = instance.getAccountByMail(email);
        assertEquals(expResullt, result.getMail());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAccountByMail method, of class AccountDAO with invalid mail.
     */
    @Test
    public void testGetAccountByInvalidMail() {
        System.out.println("getAccountByMail");
        String email = "dathp.proxy@@gmail.com";
        AccountDAO instance = new AccountDAO();
        AccountBean expResult = null;
        AccountBean result = instance.getAccountByMail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateNewPassword method, of class AccountDAO.
     */
    @Test(expected = Exception.class)
    public void testUpdateNewPassword() {
        System.out.println("updateNewPassword");
        AccountBean account = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.updateNewPassword(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
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
    }

    /**
     * Test of insertNewAccount method, of class AccountDAO with empty Data.
     */
    @Test
    public void testInsertNewAccountWithEmptyData() {
        System.out.println("testInsertNewAccountWithEmptyData");
        AccountBean account = new AccountBean();
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.insertNewAccount(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of insertNewAccount method, of class AccountDAO with valid Data.
     */
    @Test
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
    }

}
