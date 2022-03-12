/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * TeacherRequestHandleController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.NotificationBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import dao.INotificationDAO;
import dao.ITeacherDAO;
import dao.NotificationDAO;
import dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the Admin wants to
 * handle Request to apply from teacher /TeacherRequestHandle is the URL of the
 * Servlet Extend HttpServlet class
 *
 * @author Duc Minh
 */
public class TeacherRequestHandleController extends HttpServlet {

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
            String type = request.getParameter("type");
            String username = request.getParameter("username");

            int daoCheck;
            ITeacherDAO iTeacherDAO = new TeacherDAO();
            INotificationDAO iNotificationDAO = new NotificationDAO();
            if (type.equals("accept")) {
                daoCheck = iTeacherDAO.handleTeacherApply(username, "Approved");
                if ((daoCheck != 0)) {
                    iNotificationDAO.insertNotification(new NotificationBean(username, "Admin", "Your application has been accepted."));
                } 
            } else if (type.equals("reject")) {
                daoCheck = iTeacherDAO.handleTeacherApply(username, "Reject");
                if ((daoCheck != 0)) {
                    iNotificationDAO.insertNotification(new NotificationBean(username, "Admin", "Your application has been rejected."));
                } 
            }

            response.sendRedirect("TeacherRequest");

        } catch (Exception ex) {
            Logger.getLogger(TeacherRequestHandleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
