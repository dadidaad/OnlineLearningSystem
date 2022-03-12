/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * HomeController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-15   1.0         DajtVox    First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import bean.TeacherBean;
import dao.INotificationDAO;
import dao.ITeacherDAO;
import dao.NotificationDAO;
import dao.TeacherDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling home url
 * /Home is the URL of the web site
 * Extend HttpServlet class
 * 
 * @author DajtVox
 */
public class HomeController extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        ITeacherDAO iTeacherDAO = new TeacherDAO();
        List<TeacherBean> teacherList = iTeacherDAO.getTop3Teacher();
        request.setAttribute("teachers", teacherList);
        ServletContext ctx = getServletContext();
        Integer count = (Integer)ctx.getAttribute("pcount");
        ctx.setAttribute("pcount", ++count);  
        
        HttpSession session = request.getSession();
            AccountBean account = (AccountBean) session.getAttribute("user");
            if (account != null) {
                INotificationDAO iNotificationDAO = new NotificationDAO();
                int notiUnread = iNotificationDAO.getTotalNotiUnread(account.getUsername());
                request.setAttribute("notiUnread", notiUnread);
                
                List<NotificationBean> notiList = iNotificationDAO.getTopNotification(account.getUsername());
                request.setAttribute("notificationList", notiList);
            }
        request.getRequestDispatcher("/view/Home.jsp").forward(request, response); //forward Home.jsp if get url
        request.getRequestDispatcher("./view/Home.jsp").forward(request, response); //forward Home.jsp if get url
    }

   
}
