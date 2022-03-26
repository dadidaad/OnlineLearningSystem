/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System
 *
 * ChangeStatusRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.RequestBean;
import dao.IRequestDAO;
import dao.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * change status of a request /ChangeStatusRequest is the URL of the Servlet Extend
 * HttpServlet class
 *
 * @author Duc Minh
 */
public class ChangeStatusRequestController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String requestId = request.getParameter("requestId");
            IRequestDAO db = new RequestDAO();
            RequestBean requestAccept = db.getRequestById(Integer.parseInt(requestId));
            requestAccept.setStatus("On-time");
            HttpSession session = request.getSession(false);
            if(session == null){
                session = request.getSession(true);
            }
            session.setAttribute("requestAccept", requestAccept);
            out.print("Accept successfully, you have 30 minutes to reply request!");
        } catch (Exception e) {

        }
    }
}
