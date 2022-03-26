/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * DeleteNotificationController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-8   1.0         Duc Minh    First Implement
 */
package controller;

import dao.INotificationDAO;
import dao.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handle data from user want delete notification
 * page Extend HttpServlet class
 * Url : /DeleteNotification
 * @author Duc Minh
 */
public class DeleteNotificationController extends HttpServlet {
  
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
        try (PrintWriter out = response.getWriter()) {
            String notiId = request.getParameter("notiId");
            INotificationDAO iNotificationDAO = new NotificationDAO();
            iNotificationDAO.deleteNotification(Integer.parseInt(notiId));
        } catch (Exception ex) {
            Logger.getLogger(DeleteNotificationController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("Home");
        }
    }

   

}
