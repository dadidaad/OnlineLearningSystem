package dao;

import bean.NotificationBean;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author win
 */
public class NotificationDAOTest {
    
    public NotificationDAOTest() {
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
    
    @Test
    public void testInsertNotification_UTC1() {
        System.out.println("insertNotification");
        NotificationBean noti = new NotificationBean("minhduc07", "Request", "You have successfully created your request.");
        NotificationDAO instance = new NotificationDAO();
        int expResult = 1;
        int result = instance.insertNotification(noti);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertNotification_UTC2() {
        System.out.println("insertNotification");
        NotificationBean noti = new NotificationBean("minhduc07", "Request", "You have successfully created your request.","ViewRequestStu?requestId=1003");
        NotificationDAO instance = new NotificationDAO();
        int expResult = 1;
        int result = instance.insertNotification(noti);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertNotification_UTC3() {
        System.out.println("insertNotification");
        NotificationBean noti = new NotificationBean("minhduc08", "Request", "You have successfully created your request.");
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.insertNotification(noti);
        assertEquals(expResult, result);
    }
    @Test
    public void testInsertNotification_UTC4() {
        System.out.println("insertNotification");
        NotificationBean noti = new NotificationBean();
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.insertNotification(noti);
        assertEquals(expResult, result);
    }
    @Test (expected = Exception.class)
    public void testInsertNotification_UTC5() {
        System.out.println("insertNotification");
        NotificationBean noti = null;
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.insertNotification(noti);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeleteNotification_UTC1() {
        System.out.println("deleteNotification");
        int notiId = 1104;
        NotificationDAO instance = new NotificationDAO();
        int expResult = 1;
        int result = instance.deleteNotification(notiId);
        assertEquals(expResult, result);
    }
    @Test 
    public void testDeleteNotification_UTC2() {
        System.out.println("deleteNotification");
        int notiId = 9999;
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.deleteNotification(notiId);
        assertEquals(expResult, result);
    }
    @Test 
    public void testDeleteNotification_UTC3() {
        System.out.println("deleteNotification");
        int notiId = -1;
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.deleteNotification(notiId);
        assertEquals(expResult, result);
    }
    @Test (expected = Exception.class)
    public void testDeleteNotification_UTC4() {
        System.out.println("deleteNotification");
        int notiId = Integer.parseInt("a");
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.deleteNotification(notiId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateReadedNotification_UTC1() {
        System.out.println("updateReadedNotification");
        String username = "minhduc07";
        NotificationDAO instance = new NotificationDAO();
        int expResult = instance.getTotalNoti(username);
        int result = instance.updateReadedNotification(username);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testUpdateReadedNotification_UTC2() {
        System.out.println("updateReadedNotification");
        String username = "minhduc08";
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.updateReadedNotification(username);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testUpdateReadedNotification_UTC3() {
        System.out.println("updateReadedNotification");
        String username = "ducgiang";
        NotificationDAO instance = new NotificationDAO();
        int expResult = 9;
        int result = instance.updateReadedNotification(username);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testUpdateReadedNotification_UTC4() {
        System.out.println("updateReadedNotification");
        String username = null;
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.updateReadedNotification(username);
        assertEquals(expResult, result);
       
    }
    
//    @Test
//    public void testGetTopNotification() {
//        System.out.println("getTopNotification");
//        String username = "";
//        NotificationDAO instance = new NotificationDAO();
//        List<NotificationBean> expResult = null;
//        List<NotificationBean> result = instance.getTopNotification(username);
//        assertEquals(expResult, result);
//       
//    }

//    @Test
//    public void testGetNotification() {
//        System.out.println("getNotification");
//        int index = 0;
//        int amount = 10;
//        String username = "minhduc07";
//        NotificationDAO instance = new NotificationDAO();
//        List<NotificationBean> expResult = null;
//        List<NotificationBean> result = instance.getNotification(index, amount, username);
//        assertEquals(expResult, result);
//    }
   
}
