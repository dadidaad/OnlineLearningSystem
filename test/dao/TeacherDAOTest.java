package dao;

import bean.TeacherBean;
import java.util.ArrayList;
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
public class TeacherDAOTest {

    public TeacherDAOTest() {
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
    public void testHandleTeacherApply_UTC1() {
        System.out.println("handleTeacherApply");
        String username = "ngocanh";
        String status = "Waiting";
        TeacherDAO instance = new TeacherDAO();
        int expResult = 1;
        int result = instance.handleTeacherApply(username, status);
        assertEquals(expResult, result);
    }

    @Test
    public void testHandleTeacherApply_UTC2() {
        System.out.println("handleTeacherApply");
        String username = "ngocanh";
        String status = "Done";
        TeacherDAO instance = new TeacherDAO();
        int expResult = 0;
        int result = instance.handleTeacherApply(username, status);
        assertEquals(expResult, result);
    }

    @Test
    public void testHandleTeacherApply_UTC3() {
        System.out.println("handleTeacherApply");
        String username = "minhduc07";
        String status = "Waiting";
        TeacherDAO instance = new TeacherDAO();
        int expResult = 0;
        int result = instance.handleTeacherApply(username, status);
        assertEquals(expResult, result);
    }

    @Test
    public void testHandleTeacherApply_UTC4() {
        System.out.println("handleTeacherApply");
        String username = "ngocanh";
        String status = null;
        TeacherDAO instance = new TeacherDAO();
        int expResult = 0;
        int result = instance.handleTeacherApply(username, status);
        assertEquals(expResult, result);
    }

    @Test
    public void testHandleTeacherApply_UTC5() {
        System.out.println("handleTeacherApply");
        String username = "";
        String status = "Approved";
        TeacherDAO instance = new TeacherDAO();
        int expResult = 0;
        int result = instance.handleTeacherApply(username, status);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTeacherByUsername_UTC1() {
        System.out.println("getTeacherByUsername");
        String username = "ngocanh";
        TeacherDAO instance = new TeacherDAO();
        TeacherBean expResult = new TeacherBean("ngocanh","/assets/image/cv_template_1.jpg", 1, "Waiting", 4);
        
        TeacherBean result = instance.getTeacherByUsername(username);
        assertEquals(expResult.getUsername(), result.getUsername());
    }

    @Test (expected = Exception.class)
    public void testGetTeacherByUsername_UTC2() {
        System.out.println("getTeacherByUsername");
        String username = "minhduc07";
        TeacherDAO instance = new TeacherDAO();
        TeacherBean expResult = new TeacherBean("minhduc07","/assets/image/cv_template_1.jpg", 1, "Waiting", 4);
    
        TeacherBean result = instance.getTeacherByUsername(username);
        assertEquals(expResult.getUsername(), result.getUsername());
    }

    @Test (expected = Exception.class)
    public void testGetTeacherByUsername_UTC3() {
       System.out.println("getTeacherByUsername");
        String username = "";
        TeacherDAO instance = new TeacherDAO();
        TeacherBean expResult = new TeacherBean("","/assets/image/cv_template_1.jpg", 1, "Waiting", 4);
   
        TeacherBean result = instance.getTeacherByUsername(username);
        assertEquals(expResult.getUsername(), result.getUsername());
    }

    @Test (expected = Exception.class)
    public void testGetTeacherByUsername_UTC4() {
        System.out.println("getTeacherByUsername");
        String username = null;
        TeacherDAO instance = new TeacherDAO();
        TeacherBean expResult = new TeacherBean(null,"/assets/image/cv_template_1.jpg", 1, "Waiting", 4);
       
        TeacherBean result = instance.getTeacherByUsername(username);
        assertEquals(expResult.getUsername(), result.getUsername());
    }
    @Test (expected = Exception.class)
    public void testGetTeacherByUsername_UTC5() {
        System.out.println("getTeacherByUsername");
        String username = null;
        TeacherDAO instance = new TeacherDAO();
        TeacherBean expResult = new TeacherBean(null,"/assets/image/cv_template_1.jpg", 1, "Waiting", 4);
     
        TeacherBean result = instance.getTeacherByUsername(username);
        assertEquals(expResult.getUsername(), result.getUsername());
    }

//    @Test
//    public void testGetAllTeacher() {
//        System.out.println("getAllTeacher");
//        int pageindex = 1;
//        int pagesize = 20;
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 9;
//        ArrayList<TeacherBean> result = instance.getAllTeacher(pageindex, pagesize);
//        assertEquals(expResult, result.size());
//    }
//
//    @Test
//    public void testGetAllOnlineTeacher() {
//        System.out.println("getAllOnlineTeacher");
//        int pageindex = 1;
//        int pagesize = 20;
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 8;
//        ArrayList<TeacherBean> result = instance.getAllOnlineTeacher(pageindex, pagesize);
//        assertEquals(expResult, result.size());
//    }
//
//    @Test
//    public void testCheckTeacherStatus() {
//        System.out.println("checkTeacherStatus");
//        String username = "ducgiang";
//        TeacherDAO instance = new TeacherDAO();
//        boolean expResult = false;
//        boolean result = instance.checkTeacherStatus(username);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetSubjectId() {
//        System.out.println("getSubjectId");
//        String usernameTeacher = "ducgiang";
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        int result = instance.getSubjectId(usernameTeacher);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetTeacherBySearching_String() {
//        System.out.println("getTeacherBySearching");
//        String searchString = "giang";
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        ArrayList<TeacherBean> result = instance.getTeacherBySearching(searchString);
//        assertEquals(expResult, result.size());
//
//    }
//
//    @Test
//    public void testInsertNewTeacher() {
//        System.out.println("insertNewTeacher");
//        TeacherBean teacher = new TeacherBean("img", 1, "Waiting", 0);
//        teacher.setUsername("");
//        TeacherDAO instance = new TeacherDAO();
//        boolean expResult = true;
//        boolean result = instance.insertNewTeacher(teacher);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetAllTeacherApply_int_int() {
//        System.out.println("getAllTeacherApply");
//        int pageindex = 1;
//        int pagesize = 20;
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 9;
//        ArrayList<TeacherBean> result = instance.getAllTeacherApply(pageindex, pagesize);
//        assertEquals(expResult, result.size());
//
//    }
//
//    @Test
//    public void testGetAllTeacherApply_3args() {
//        System.out.println("getAllTeacherApply");
//        String status = "Waiting";
//        int pageindex = 1;
//        int pagesize = 20;
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 4;
//        ArrayList<TeacherBean> result = instance.getAllTeacherApply(status, pageindex, pagesize);
//        assertEquals(expResult, result.size());
//
//    }
//
//    @Test
//    public void testGetTotalTeacherApply_0args() {
//        System.out.println("getTotalTeacherApply");
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 10;
//        int result = instance.getTotalTeacherApply();
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetTotalTeacherApply_String() {
//        System.out.println("getTotalTeacherApply");
//        String status = "Waiting";
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 5;
//        int result = instance.getTotalTeacherApply(status);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetTotalTeacher() {
//        System.out.println("getTotalTeacher");
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 9;
//        int result = instance.getTotalTeacher();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetTotalOnlineTeacher() {
//        System.out.println("getTotalOnlineTeacher");
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 8;
//        int result = instance.getTotalOnlineTeacher();
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetTotalTeacherSearch() {
//        System.out.println("getTotalTeacherSearch");
//        String searchString = "giang";
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        int result = instance.getTotalTeacherSearch(searchString);
//        assertEquals(expResult, result);
//    }
//
    @Test
    public void testGetTeacherBySearching_3args() {
        System.out.println("getTeacherBySearching");
        String searchString = "giang";
        int pageindex = 1;
        int pagesize = 10;
        TeacherDAO instance = new TeacherDAO();
        int expResult = 1;
        ArrayList<TeacherBean> result = instance.getTeacherBySearching(searchString, pageindex, pagesize);
        assertEquals(expResult, result);

    }
//
//    @Test
//    public void testGetTeacherBySearching_String_int() {
//        System.out.println("getTeacherBySearching");
//        String searchString = "giang";
//        int subjectId = 1;
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        ArrayList<TeacherBean> result = instance.getTeacherBySearching(searchString, subjectId);
//        assertEquals(expResult, result.size());
//
//    }
//
//    @Test
//    public void testGetTopTeacher() {
//        System.out.println("getTopTeacher");
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 9;
//        ArrayList<TeacherBean> result = instance.getTopTeacher();
//        assertEquals(expResult, result.size());
//
//    }
//
//    @Test
//    public void testGetTop3Teacher() {
//        System.out.println("getTop3Teacher");
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 3;
//        ArrayList<TeacherBean> result = instance.getTop3Teacher();
//        assertEquals(expResult, result.size());
//    }
//
//    @Test
//    public void testGetTotalTeacherApplySearch_String() {
//        System.out.println("getTotalTeacherApplySearch");
//        String searchString = "giang";
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        int result = instance.getTotalTeacherApplySearch(searchString);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetTotalTeacherApplySearch_String_String() {
//        System.out.println("getTotalTeacherApplySearch");
//        String status = "Waiting";
//        String searchString = "tung";
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        int result = instance.getTotalTeacherApplySearch(status, searchString);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetTeacherApplyBySearching_4args() {
//        System.out.println("getTeacherApplyBySearching");
//        String status = "Waiting";
//        String searchString = "tung";
//        int pageindex = 1;
//        int pagesize = 10;
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        ArrayList<TeacherBean> result = instance.getTeacherApplyBySearching(status, searchString, pageindex, pagesize);
//        assertEquals(expResult, result.size());
//
//    }
//
//    @Test
//    public void testGetTeacherApplyBySearching_3args() {
//        System.out.println("getTeacherApplyBySearching");
//        String searchString = "tung";
//        int pageindex = 1;
//        int pagesize = 20;
//        TeacherDAO instance = new TeacherDAO();
//        int expResult = 1;
//        ArrayList<TeacherBean> result = instance.getTeacherApplyBySearching(searchString, pageindex, pagesize);
//        assertEquals(expResult, result.size());
//
//    }

}
