/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * CreateRequestReplyController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.NotificationBean;
import bean.RequestBean;
import bean.RequestReplyBean;
import bean.TeacherBean;
import dao.INotificationDAO;
import dao.IRequestDAO;
import dao.ITeacherDAO;
import dao.NotificationDAO;
import dao.RequestDAO;
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
 * This is a Servlet responsible for handling the task when the teacher wants to create the reply of Request
 * /CreateRequestReply is the URL of the Servlet
 * Extend HttpServlet class
 * @author Duc Minh
 */
public class CreateRequestReplyController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String teacherSent = request.getParameter("teacherSent");
        String studentSent = request.getParameter("studentSent");
        String contentReply = request.getParameter("contentReply").replaceAll("\\s\\s+", " ").trim();
        String imgReply = "/assets/image/" + request.getParameter("imgReply");
        
        RequestReplyBean rpReply = new RequestReplyBean();
        rpReply.setRequestID(requestId);
        rpReply.setTutorSent(teacherSent);
        rpReply.setStudentGet(studentSent);
        rpReply.setContentReply(contentReply);
        rpReply.setImageLinkReply(imgReply);
        
        IRequestDAO iRequestDAO = new RequestDAO();
        iRequestDAO.updateRequestStatus("Approved", requestId);
        int daoCheck = iRequestDAO.createRequestReply(rpReply);
        
        INotificationDAO iNotificationDAO = new NotificationDAO();
        ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call   
        TeacherBean teacher = iTeacherDAO.getTeacherByUsername(teacherSent);
        if ((daoCheck!=0)) {
            iNotificationDAO.insertNotification(new NotificationBean(teacherSent,"Request", "You have successfully created your request."));
            iNotificationDAO.insertNotification(new NotificationBean(studentSent,"Request", "Your request has been answered by "+teacher.getDisplayName()+"."));
        }        
        else iNotificationDAO.insertNotification(new NotificationBean(teacherSent,"Request", "You have failed answered the request."));
        
        response.sendRedirect("ListAllRequest");
        
        }catch (Exception ex) {
            Logger.getLogger(CreateRequestReplyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
