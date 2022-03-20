/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AccountBean;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockPreparedStatement;
import com.mockrunner.mock.jdbc.MockResultSet;
import java.math.BigDecimal;
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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
    private MockConnection mockConn;

    @Mock
    private MockPreparedStatement mockStatement;

    @Spy
    @InjectMocks
    private MockResultSet mockRs = new MockResultSet("MyMock");

    @Before
    public void setUp() throws SQLException {
        accountDAO = new AccountDAO();
        PowerMockito.mockStatic(BaseDAO.class);
        accountDAOspy = PowerMockito.spy(new AccountDAO());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetDisplayNames() throws Exception {
        Map<String, String> result = new HashMap<>();
        mockRs = initMockResultSet();
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        PowerMockito.when(mockStatement.executeQuery()).thenReturn(mockRs);
        result = accountDAOspy.getDisplayNames();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetAccountByUsernameNotFound() throws Exception {
        String username = "";
        AccountBean expResult = null;
        mockRs = initMockResultSet();
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        PowerMockito.when(mockStatement.executeQuery()).thenReturn(mockRs);
        AccountBean result = accountDAOspy.getAccountByUsername(username);
        assertThat(result, CoreMatchers.is(expResult));
    }

    @Test
    public void testGetAccountByUsername() throws Exception {
        String username = "admin";
        AccountBean expResult = new AccountBean();
        mockRs = initMockResultSet();
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        PowerMockito.when(mockStatement.executeQuery()).thenReturn(mockRs);
        PowerMockito.doReturn(expResult).when(accountDAOspy, "getAccountByUsername", anyString());
        AccountBean result = accountDAOspy.getAccountByUsername(username);
        assertThat(result, CoreMatchers.is(expResult));
    }

    @Test
    public void testGetAccountByMailNotFound() {
        String email = "";
        AccountBean expResult = null;
        AccountBean result = accountDAOspy.getAccountByMail(email);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetAccountByMailFound() throws Exception {
        String username = "dat@gmail.com";
        AccountBean expResult = new AccountBean();
        mockRs = initMockResultSet();
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        PowerMockito.when(mockStatement.executeQuery()).thenReturn(mockRs);
        PowerMockito.doReturn(expResult).when(accountDAOspy, "getAccountByMail", anyString());
        AccountBean result = accountDAOspy.getAccountByMail(username);
        assertThat(result, CoreMatchers.is(expResult));
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateNewPasswordWithNull() throws Exception {
        AccountBean x = null;
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        accountDAOspy.updateNewPassword(x);
    }
    @Test()
    public void testUpdateNewPasswordWithEmpty() throws Exception {
        AccountBean x = new AccountBean();
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        int result = accountDAOspy.updateNewPassword(x);
        assertEquals(0, result);
    }
    @Test()
    public void testUpdateNewPasswordWithValid() throws Exception {
        AccountBean x = new AccountBean();
        x.setMail("dat@gmail.com");
        x.setPassword("hello");
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        accountDAOspy.updateNewPassword(x);
    }

    @Test
    public void testInsertNewValidAccount() throws SQLException {
        AccountBean account = new AccountBean();
        account.setUsername("username");
        account.setPassword("Gello");
        account.setMail("dat@gmail.com");
        account.setSex(true);
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        accountDAOspy.insertNewAccount(account);
    }

    @Test(expected = NullPointerException.class)
    public void testInsertNewNullAccount() {
        AccountBean account = null;
        accountDAO.insertNewAccount(account);
    }

    @Test
    public void testInsertNewEmptyAccount() throws SQLException {
        AccountBean x = new AccountBean();
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        accountDAOspy.insertNewAccount(x);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateInformation() {
        AccountBean account = null;
        accountDAOspy.updateInformation(account);
    }

    @Test
    public void testTotalAccount() throws SQLException {
        mockRs = initMockResultSet();
        PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        PowerMockito.when(mockStatement.executeQuery()).thenReturn(mockRs);
        int result = accountDAOspy.totalAccount();
        assertEquals(3, result);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteAccountWithNull() {
       String username = null;
       accountDAOspy.deleteAccount(username);
    }
    @Test
    public void testDeleteAccount() throws SQLException {
       String username = "admin";
       PowerMockito.when(BaseDAO.getConnection()).thenReturn(mockConn);
        PowerMockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
       accountDAOspy.deleteAccount(username);
    }



    private MockResultSet initMockResultSet() throws SQLException {
        mockRs.addColumn("Username", new String[]{"admin1", "vodat", "minhthu"});
        mockRs.addColumn("Password", new String[]{"hello", "hello", "hello"});
        mockRs.addColumn("Mail", new String[]{"dat@gmail.com", "dat1@gmail.com", "dat2@gmail.com"});
        mockRs.addColumn("Avatar", new String[]{"avatar.png", "avatar.png", "avatar.png"});
        mockRs.addColumn("DisplayName", new String[]{"Dat Vo", "Dat Vo 1", "Dat Vo 2"});
        mockRs.addColumn("DateOfBirth", new java.sql.Date[]{new java.sql.Date(20010228), new java.sql.Date(20010228), new java.sql.Date(20010228)});
        mockRs.addColumn("Sex", new Boolean[]{true, true, true});
        mockRs.addColumn("Description", new String[]{"hello", "hello", "hello"});
        mockRs.addColumn("Cash In Account", new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO});
        mockRs.addColumn("CreatedDate", new java.sql.Date[]{new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis())});
        mockRs.addColumn("Role", new String[]{"Student", "Teacher", "Admin"});
        mockRs.addColumn("Status", new String[]{"Waiting", "Actived", "Banned"});
        mockRs.addColumn("State", new Boolean[]{false, false, false});
        mockRs.addColumn("NumberOfAccount", new Integer[]{3,3,3});
        return mockRs;
    }

}
