/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AccountBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.internal.progress.ArgumentMatcherStorage;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import utils.PasswordUtils;

/**
 *
 * @author Admin
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({BaseDAO.class, AccountDAO.class})
public class AccountDAOTest {

    private AccountDAO accountDAO;

    private AccountDAO accountDAOspy;

    @Mock
    private Connection conn;

    @Mock
    private PreparedStatement statement;

    @Mock
    private ResultSet rs;

    @Before
    public void setUp() throws SQLException {
        accountDAO = new AccountDAO();
        PowerMockito.mockStatic(BaseDAO.class);
        accountDAOspy = PowerMockito.spy(new AccountDAO());
        when(BaseDAO.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(rs);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetDisplayNames() throws Exception {
        Map<String, String> expResult = new HashMap<>();
        PowerMockito.doReturn(expResult).when(accountDAOspy, "getDisplayNames");
        Map<String, String> result = accountDAOspy.getDisplayNames();
        assertThat(result, CoreMatchers.is(expResult));
    }

    @Test
    public void testGetAccountByUsernameNotFound() throws Exception {
        String username = "";
        AccountBean expResult = null;
        PowerMockito.doReturn(expResult).when(accountDAOspy, "getAccountByUsername", anyString());
        AccountBean result = accountDAOspy.getAccountByUsername(username);
        assertThat(result, CoreMatchers.is(expResult));
    }
    @Test
    public void testGetAccountByUsername() throws Exception {
        String username = "admin";
        AccountBean expResult = null;
        PowerMockito.doReturn(expResult).when(accountDAOspy, "getAccountByUsername", anyString());
        AccountBean result = accountDAOspy.getAccountByUsername(username);
        assertThat(result, CoreMatchers.is(expResult));
    }

    @Test
    public void testGetAccountByMail() {
        System.out.println("getAccountByMail");
        String email = "";
        AccountDAO instance = new AccountDAO();
        AccountBean expResult = null;
        AccountBean result = instance.getAccountByMail(email);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateNewPassword() {
        System.out.println("updateNewPassword");
        AccountBean account = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertNewValidAccount() {
        AccountBean account = new AccountBean();
        account.setUsername("username");
        account.setPassword("Gello");
        account.setMail("dat@gmail.com");
        account.setSex(true);
        accountDAO.insertNewAccount(account);
    }

    @Test(expected = NullPointerException.class)
    public void testInsertNewNullAccount() {
        AccountBean account = null;
        accountDAO.insertNewAccount(account);
    }

    @Test
    public void testInsertNewEmptyAccount() throws SQLException {
        AccountBean x = new AccountBean();
        accountDAO.insertNewAccount(x);
        verify(statement).setString(1, x.getUsername());
        verify(statement).setString(2, x.getPassword());
        verify(statement).setString(3, x.getMail());
        verify(statement).setBoolean(4, x.getSex());
        verify(statement).executeUpdate();

    }

    @Test
    public void testUpdateInformation() {
        System.out.println("updateInformation");
        AccountBean account = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.updateInformation(account);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTotalAccount() {
        System.out.println("totalAccount");
        AccountDAO instance = new AccountDAO();
        int expResult = 0;
        int result = instance.totalAccount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTotalAccountSearch() {
        System.out.println("totalAccountSearch");
        String searchString = "";
        AccountDAO instance = new AccountDAO();
        int expResult = 0;
        int result = instance.totalAccountSearch(searchString);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllAccountBySearch() {
        System.out.println("getAllAccountBySearch");
        String searchString = "";
        int pageindex = 0;
        int pagesize = 0;
        AccountDAO instance = new AccountDAO();
        List<AccountBean> expResult = null;
        List<AccountBean> result = instance.getAllAccountBySearch(searchString, pageindex, pagesize);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllAccount() {
        System.out.println("getAllAccount");
        int pageindex = 0;
        int pagesize = 0;
        AccountDAO instance = new AccountDAO();
        List<AccountBean> expResult = null;
        List<AccountBean> result = instance.getAllAccount(pageindex, pagesize);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateStatusAccount() {
        System.out.println("updateStatusAccount");
        String username = "";
        String status = "";
        AccountDAO instance = new AccountDAO();
        instance.updateStatusAccount(username, status);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        String username = "";
        AccountDAO instance = new AccountDAO();
        instance.deleteAccount(username);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateStateACcount() {
        System.out.println("updateStateACcount");
        AccountBean account = null;
        AccountDAO instance = new AccountDAO();
        instance.updateStateACcount(account);
        fail("The test case is a prototype.");
    }

}
