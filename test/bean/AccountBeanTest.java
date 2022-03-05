/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.AccountBean;
import java.math.BigDecimal;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class AccountBeanTest {
    
    public AccountBeanTest() {
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
     * Test of toString method, of class AccountBean.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class AccountBean.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class AccountBean.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        AccountBean instance = new AccountBean();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToken method, of class AccountBean.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToken method, of class AccountBean.
     */
    @Test
    public void testSetToken() {
        System.out.println("setToken");
        String token = "";
        AccountBean instance = new AccountBean();
        instance.setToken(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class AccountBean.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class AccountBean.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        AccountBean instance = new AccountBean();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class AccountBean.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMail method, of class AccountBean.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "";
        AccountBean instance = new AccountBean();
        instance.setMail(mail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvatar method, of class AccountBean.
     */
    @Test
    public void testGetAvatar() {
        System.out.println("getAvatar");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getAvatar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvatar method, of class AccountBean.
     */
    @Test
    public void testSetAvatar() {
        System.out.println("setAvatar");
        String avatar = "";
        AccountBean instance = new AccountBean();
        instance.setAvatar(avatar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisplayName method, of class AccountBean.
     */
    @Test
    public void testGetDisplayName() {
        System.out.println("getDisplayName");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getDisplayName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisplayName method, of class AccountBean.
     */
    @Test
    public void testSetDisplayName() {
        System.out.println("setDisplayName");
        String displayName = "";
        AccountBean instance = new AccountBean();
        instance.setDisplayName(displayName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfBirth method, of class AccountBean.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
        AccountBean instance = new AccountBean();
        Date expResult = null;
        Date result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfBirth method, of class AccountBean.
     */
    @Test
    public void testSetDateOfBirth() {
        System.out.println("setDateOfBirth");
        Date dateOfBirth = null;
        AccountBean instance = new AccountBean();
        instance.setDateOfBirth(dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSex method, of class AccountBean.
     */
    @Test
    public void testIsSex() {
        System.out.println("isSex");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.isSex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSex method, of class AccountBean.
     */
    @Test
    public void testGetSex() {
        System.out.println("getSex");
        AccountBean instance = new AccountBean();
        boolean expResult = false;
        boolean result = instance.getSex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSex method, of class AccountBean.
     */
    @Test
    public void testSetSex_boolean() {
        System.out.println("setSex");
        boolean sex = false;
        AccountBean instance = new AccountBean();
        instance.setSex(sex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSex method, of class AccountBean.
     */
    @Test
    public void testSetSex_String() {
        System.out.println("setSex");
        String sex = "";
        AccountBean instance = new AccountBean();
        instance.setSex(sex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class AccountBean.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class AccountBean.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        AccountBean instance = new AccountBean();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCash method, of class AccountBean.
     */
    @Test
    public void testGetCash() {
        System.out.println("getCash");
        AccountBean instance = new AccountBean();
        BigDecimal expResult = null;
        BigDecimal result = instance.getCash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCash method, of class AccountBean.
     */
    @Test
    public void testSetCash() {
        System.out.println("setCash");
        BigDecimal cash = null;
        AccountBean instance = new AccountBean();
        instance.setCash(cash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreateDate method, of class AccountBean.
     */
    @Test
    public void testGetCreateDate() {
        System.out.println("getCreateDate");
        AccountBean instance = new AccountBean();
        Date expResult = null;
        Date result = instance.getCreateDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreateDate method, of class AccountBean.
     */
    @Test
    public void testSetCreateDate() {
        System.out.println("setCreateDate");
        Date createDate = null;
        AccountBean instance = new AccountBean();
        instance.setCreateDate(createDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class AccountBean.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class AccountBean.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        AccountBean instance = new AccountBean();
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class AccountBean.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        AccountBean instance = new AccountBean();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class AccountBean.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        AccountBean instance = new AccountBean();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isState method, of class AccountBean.
     */
    @Test
    public void testIsState() {
        System.out.println("isState");
        AccountBean instance = new AccountBean();
        boolean expResult = false;
        boolean result = instance.isState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class AccountBean.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        boolean state = false;
        AccountBean instance = new AccountBean();
        instance.setState(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
