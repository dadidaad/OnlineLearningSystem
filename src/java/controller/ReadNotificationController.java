/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * ReadNotificationController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-8   1.0         Duc Minh    First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import dao.INotificationDAO;
import dao.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handle data from user want reset notification
 * page Extend HttpServlet class
 *
 * @author Duc Minh
 */
public class ReadNotificationController extends HttpServlet {


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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession();
        AccountBean account = (AccountBean) session.getAttribute("user");
        if (account != null) {
            INotificationDAO iNotificationDAO = new NotificationDAO();
            iNotificationDAO.updateReadedNotification(account.getUsername());
            int notiUnread = iNotificationDAO.getTotalNotiUnread(account.getUsername());
  
            out.print(notiUnread); 
        }
         
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(ReadNotificationController.class.getName()).log(Level.SEVERE, null, e);

        }
    }

}
