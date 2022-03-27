/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AccountBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.invocation.InvocationOnMock;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Admin
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpServlet.class})
@PowerMockIgnore({"javax.net.ssl.*", "javax.security.*", "javax.crypto.*"})
public class LoginControllerTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    HttpSession session;

    public LoginControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        request = mock(HttpServletRequest.class);
         response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        final Map<String, Object> attributes = new ConcurrentHashMap<>();
        // Mock setAttribute
        PowerMockito.doAnswer((InvocationOnMock invocation) -> {
            String key = invocation.getArgumentAt(0, String.class);
            Object value = invocation.getArgumentAt(1, Object.class);
            attributes.put(key, value);
            return null;
        }).when(request).setAttribute(anyString(), any());
        PowerMockito.doAnswer((InvocationOnMock invocation) -> {
            String key = invocation.getArgumentAt(0, String.class);
            Object value = invocation.getArgumentAt(1, Object.class);
            attributes.put(key, value);
            return null;
        }).when(session).setAttribute(anyString(), any());
// Mock getAttribute
        PowerMockito.doAnswer((InvocationOnMock invocation) -> {
            String key = invocation.getArgumentAt(0, String.class);
            Object value = attributes.get(key);
            return value;
        }).when(request).getAttribute(anyString());
        PowerMockito.doAnswer((InvocationOnMock invocation) -> {
            String key = invocation.getArgumentAt(0, String.class);
            Object value = attributes.get(key);
            return value;
        }).when(session).getAttribute(anyString());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoGet() throws Exception {
        LoginController controller = new LoginController();
        String page = "./view/Login.jsp";
        when(request.getRequestDispatcher(page)).thenReturn(dispatcher);
        controller.doGet(request, response);
        verify(response, times(1)).setContentType("text/html;charset=UTF-8");
        verify(request, times(1)).setCharacterEncoding("utf-8");
        verify(request, never()).getSession();
        verify(request, times(1)).getRequestDispatcher(page);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_WrongPassword() throws Exception {
        LoginController controller = new LoginController();
        controller = PowerMockito.spy(controller);
        String page = "./view/Login.jsp";
        String username = "admin";
        String password = "Aa1234567";
        AccountBean loginedUser = new AccountBean();
        Map<String, String> expResult = new HashMap<>();
        expResult.put("loginNoti", "Invalid password");
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        PowerMockito.doNothing().when(session).setAttribute("user", loginedUser);
        when(request.getRequestDispatcher(page)).thenReturn(dispatcher);
        controller.doPost(request, response);
        Map<String, String> result = new HashMap<>();
        verify(request, times(1)).getSession();
        verify(request, times(1)).getRequestDispatcher(page);
        verify(dispatcher).forward(request, response);
        result = (Map<String, String>) request.getAttribute("message_forward");
        assertEquals(expResult.get("loginNoti"), result.get("loginNoti"));
    }
    @Test
    public void testDoPost_WrongUsername() throws Exception {
        LoginController controller = new LoginController();
        controller = PowerMockito.spy(controller);
        String page = "./view/Login.jsp";
        String username = "a";
        String password = "Aa1234567";
        AccountBean loginedUser = new AccountBean();
        Map<String, String> expResult = new HashMap<>();
        expResult.put("loginNoti", "User isn't exist");
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        PowerMockito.doNothing().when(session).setAttribute("user", loginedUser);
        when(request.getRequestDispatcher(page)).thenReturn(dispatcher);
        controller.doPost(request, response);
        Map<String, String> result = new HashMap<>();
        verify(request, times(1)).getSession();
        verify(request, times(1)).getRequestDispatcher(page);
        verify(dispatcher).forward(request, response);
        result = (Map<String, String>) request.getAttribute("message_forward");
        assertEquals(expResult.get("loginNoti"), result.get("loginNoti"));
    }
    @Test
    public void testDoPost_CorrectUser() throws Exception {
        LoginController controller = new LoginController();
        controller = PowerMockito.spy(controller);
        String page = "./view/Login.jsp";
        String username = "admin";
        String password = "Aa123456";
        AccountBean loginedUser = new AccountBean();
        Map<String, String> expResult = new HashMap<>();
        expResult.put("loginNoti", "User isn't exist");
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        PowerMockito.doNothing().when(session).setAttribute("user", loginedUser);
        PowerMockito.doNothing().when(response).sendRedirect(anyString());
        controller.doPost(request, response);
        AccountBean testAccount = (AccountBean) session.getAttribute("user");
        assertEquals(username, testAccount.getUsername());
    }
    
    @Test(expected = NullPointerException.class)
    public void testDoPost_NullUser() throws Exception {
        LoginController controller = new LoginController();
        controller = PowerMockito.spy(controller);
        String page = "./view/Login.jsp";
        String username = null;
        String password = "Aa123456";
        AccountBean loginedUser = new AccountBean();
        Map<String, String> expResult = new HashMap<>();
        expResult.put("loginNoti", "User isn't exist");
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        PowerMockito.doNothing().when(session).setAttribute("user", loginedUser);
        PowerMockito.doNothing().when(response).sendRedirect(anyString());
        controller.doPost(request, response);
        AccountBean testAccount = (AccountBean) session.getAttribute("user");
        assertEquals(username, testAccount.getUsername());
    }
    @Test(expected = NullPointerException.class)
    public void testDoPost_NullPass() throws Exception {
        LoginController controller = new LoginController();
        controller = PowerMockito.spy(controller);
        String page = "./view/Login.jsp";
        String username = "admin";
        String password = null;
        AccountBean loginedUser = new AccountBean();
        Map<String, String> expResult = new HashMap<>();
        expResult.put("loginNoti", "User isn't exist");
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        PowerMockito.doNothing().when(session).setAttribute("user", loginedUser);
        PowerMockito.doNothing().when(response).sendRedirect(anyString());
        controller.doPost(request, response);
        AccountBean testAccount = (AccountBean) session.getAttribute("user");
        assertEquals(username, testAccount.getUsername());
    }


}
