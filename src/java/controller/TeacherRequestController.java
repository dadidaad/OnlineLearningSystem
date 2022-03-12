/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * TeacherRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import bean.TeacherBean;
import dao.INotificationDAO;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
import dao.NotificationDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when the Admin wants to see all the Request to apply from teacher
 * /TeacherRequest is the URL of the Servlet
 * Extend HttpServlet class
 * @author Duc Minh
 */
public class TeacherRequestController extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        /*Notification*/
        HttpSession session = request.getSession();
        AccountBean account = (AccountBean) session.getAttribute("user");
        if (account != null) {
            INotificationDAO iNotificationDAO = new NotificationDAO();

            int notiUnread = iNotificationDAO.getTotalNotiUnread(account.getUsername());
            request.setAttribute("notiUnread", notiUnread);
            List<NotificationBean> notiList = iNotificationDAO.getTopNotification(account.getUsername());
            request.setAttribute("notificationList", notiList);
        }    
            
        ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call    
        String status = request.getParameter("rqStatus");
        if(status==null) status = "waiting";
        /*Pagination*/   
         String page = request.getParameter("page");
         if(page == null || page.length() == 0)
             page = "1";
         int pageindex = Integer.parseInt(page);
         int pagesize = 10;
         int totalrow,totalpage; 
       
        List <TeacherBean> teacherList = new ArrayList<>();
        
        
        if(status.equals("waiting")){
             totalrow = iTeacherDAO.getTotalTeacherApply(status);
             totalpage = (totalrow%pagesize==0)?totalrow/pagesize:totalrow/pagesize + 1  ;
            teacherList = iTeacherDAO.getAllTeacherApply("waiting", pageindex, pagesize);
        }else{
             totalrow = iTeacherDAO.getTotalTeacherApply();
             totalpage = (totalrow%pagesize==0)?totalrow/pagesize:totalrow/pagesize + 1  ;
            teacherList = iTeacherDAO.getAllTeacherApply(pageindex, pagesize);
        }
     
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pageindex", pageindex);    
            request.setAttribute("status", status);
 
        ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
        Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();
                
        /*Attach Attribute teachers for request and redirect it to ListAllTeacher.jsp*/
            request.setAttribute("subjectNames", SubjectNames);
            request.setAttribute("teachers", teacherList);
            request.getRequestDispatcher("./view/TeacherRequest.jsp").forward(request, response);
            
        }catch (Exception ex) {
            Logger.getLogger(TeacherRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
