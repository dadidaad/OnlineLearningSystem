/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.PrintWriter;
import java.io.StringWriter;
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
public class SignUpControllerTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    HttpSession session;

    public SignUpControllerTest() {
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
        SignUpController controller = new SignUpController();
        String page = "./view/SignUp.jsp";
        when(request.getRequestDispatcher(page)).thenReturn(dispatcher);
        controller.doGet(request, response);
        verify(request, never()).getSession();
        verify(request, times(1)).getRequestDispatcher(page);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_ExistUsername() throws Exception {
        SignUpController controller = new SignUpController();
        PowerMockito.spy(controller);
        String username = "admin";
        String password = "Aa1234567";
        String email = "datvthe151388@fpt.edu.vn";
        String sex = "male";
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("sex")).thenReturn(sex);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        controller.doPost(request, response);
        assertEquals(true, stringWriter.toString().contains("User is exist"));
    }
    @Test
    public void testDoPost_ExistEmail() throws Exception {
        SignUpController controller = new SignUpController();
        PowerMockito.spy(controller);
        String username = "admin1234";
        String password = "Aa1234567";
        String email = "datvthe151388@fpt.edu.vn";
        String sex = "male";
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("sex")).thenReturn(sex);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        controller.doPost(request, response);
        assertEquals(true, stringWriter.toString().contains("Mail is exist"));
    }
}
