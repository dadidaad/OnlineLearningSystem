/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         Doan Tu    First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import bean.SubjectBean;
import dao.INotificationDAO;
import dao.ISubjectDAO;
import dao.NotificationDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list of subjects /Subject is the URL of the web site Extend
 * HttpServlet class
 *
 * @author Doan Tu
 */
public class SubjectController extends HttpServlet {

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

            /*Notification*/
            HttpSession session = request.getSession();
            AccountBean account = (AccountBean) session.getAttribute("user");
            if (account != null) {
                INotificationDAO iNotificationDAO = new NotificationDAO();

                int totalNoti = iNotificationDAO.getTotalNoti(account.getUsername());
                List<NotificationBean> notiList = iNotificationDAO.getTopNotification(account.getUsername());
                request.setAttribute("totalNoti", totalNoti);
                request.setAttribute("notificationList", notiList);
            }

            List<SubjectBean> subjects = new ArrayList<>();
            ISubjectDAO subjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            subjects = subjectDAO.getAllSubject();

            /*Attach Attribute subjects for request and redirect it to ListSubject.jsp*/
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("./view/ListSubject.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
