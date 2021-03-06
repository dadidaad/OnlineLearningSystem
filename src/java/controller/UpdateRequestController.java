/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * UpdateRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import bean.RequestBean;
import bean.SubjectBean;
import bean.TeacherBean;
import dao.INotificationDAO;
import dao.IRequestDAO;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
import dao.NotificationDAO;
import dao.RequestDAO;
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
 * This is a Servlet responsible for handling the task when the student wants to
 * update Request /UpdateRequest is the URL of the Servlet Extend HttpServlet
 * class
 *
 * @author Duc Minh
 */
public class UpdateRequestController extends HttpServlet {

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

            int rqId = Integer.parseInt(request.getParameter("requestId"));

            IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
            RequestBean rq = iRequestDAO.getRequestById(rqId);

            SubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();
            List<SubjectBean> subjects = new ArrayList<>();
            subjects = iSubjectDAO.getAllSubject();

            ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
            List<TeacherBean> teacherList = iTeacherDAO.getTopTeacher();

            request.setAttribute("teachers", teacherList);
                      
            //Attach Attribute teachers for request and redirect it to UpdateRequestStu.jsp
            request.setAttribute("request", rq);
            request.setAttribute("subjectNames", SubjectNames);
            request.setAttribute("subjects", subjects);

            request.getRequestDispatcher("./view/UpdateRequest.jsp").forward(request, response);
        } catch (Exception e) {

        }
    }

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

            int requestId = Integer.parseInt(request.getParameter("rqId"));
            String requestTitle = request.getParameter("rqTitle").replaceAll("\\s\\s+", " ").trim();
            String requestSubject = request.getParameter("rqSubject");
            String requestLevel = request.getParameter("rqLevel");
            String requestPrice = request.getParameter("rqPrice");
            String requestStudentSent = request.getParameter("studentSent");

            String requestTeacherRcm = request.getParameter("rqTeacherRcm");
            if (requestTeacherRcm.equals("")) {
                requestTeacherRcm = null;
            }

            String requestContent = request.getParameter("content").replaceAll("\\s\\s+", " ").trim();
            String requestImg = "/assets/image/" + request.getParameter("imgContent");

            RequestBean rq = new RequestBean();

            rq.setRequestID(requestId);
            rq.setStudentSent(requestStudentSent);
            rq.setTutorGet(requestTeacherRcm);
            rq.setCost(Integer.parseInt(requestPrice));
            rq.setContent(requestContent);
            rq.setImageLink(requestImg);
            rq.setSubjectID(Integer.parseInt(requestSubject));
            rq.setLevel(Integer.parseInt(requestLevel));
            rq.setTitle(requestTitle);

            IRequestDAO iRequestDAO = new RequestDAO();
            int daoCheck = iRequestDAO.updateRequest(rq);

            INotificationDAO iNotificationDAO = new NotificationDAO();
            if ((daoCheck != 0)) {
                iNotificationDAO.insertNotification(new NotificationBean(requestStudentSent, "Request", "You have successfully updated your request.","ViewRequestStu?requestId="+requestId));
            } else {
                iNotificationDAO.insertNotification(new NotificationBean(requestStudentSent, "Request", "You have failed updated your request."));
            }
            
            response.sendRedirect("ListAllRequest");

        } catch (Exception ex) {
            Logger.getLogger(UpdateRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
