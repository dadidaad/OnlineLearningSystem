/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AccountBean;
import java.io.IOException;
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
import org.mockito.ArgumentCaptor;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.invocation.InvocationOnMock;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.doNothing;
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
public class ViewProfileUserControllerTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    HttpSession session;

    public ViewProfileUserControllerTest() {
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
    public void testDoGet_NullUser() throws Exception {
        ViewProfileUserController controller = new ViewProfileUserController();
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        controller = PowerMockito.spy(controller);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(null);
        doNothing().when(response).sendRedirect(anyString());
        controller.doGet(request, response);
        verify(response, times(1)).setContentType("text/html;charset=UTF-8");
        verify(response, times(1)).sendRedirect(captor.capture());
        assertEquals("Login", captor.getValue());
    }
    @Test
    public void testDoGet_ValidUser() throws Exception {
        ViewProfileUserController controller = new ViewProfileUserController();
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        String page = "./view/UserSettings.jsp";
        String username = "vanngoc";
        AccountBean loginedUser = new AccountBean();
        loginedUser.setUsername(username);
        controller = PowerMockito.spy(controller);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(loginedUser);
        controller.doGet(request, response);
        verify(response, times(1)).setContentType("text/html;charset=UTF-8");
        assertEquals("Login", captor.getValue());
    }

}
