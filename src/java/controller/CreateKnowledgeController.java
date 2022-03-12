/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * CreateKnowledgeController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-25   1.0         Doan Tu    First Implement
 */
package controller;

import bean.AccountBean;
import bean.KnowledgeBean;
import bean.NotificationBean;
import dao.IKnowledgeDAO;
import dao.INotificationDAO;
import dao.KnowledgeDAO;
import dao.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * Create new knowledge and insert it into database. /CreateKnowledgeController
 * is the URL of the web site Extend HttpServlet class
 *
 * @author Doan Tu
 */
@MultipartConfig
@WebServlet(name = "CreateKnowledgeController", urlPatterns = {"/CreateKnowledgeController"})
public class CreateKnowledgeController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*Get data from Parameter of request*/
            String chapId = request.getParameter("chapId");

            /*get total Number Of Knowledge*/
            IKnowledgeDAO knowledgeDAO = new KnowledgeDAO();
            int numberOfKnowledge = knowledgeDAO.getNumbberOfKnowledge() + 1;

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
            
            /*Attach nextID and chapID Atrribute to request and redirect*/
            request.setAttribute("nextId", numberOfKnowledge);
            request.setAttribute("chapId", chapId);
            request.getRequestDispatcher("./view/CreateKnowledge.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*get data from parameter of request*/
            String knowledgeName = request.getParameter("knowledgeName").replaceAll("\\s\\s+", " ").trim();
            String knowledgeId = request.getParameter("knowledgeId");
            String chapId = request.getParameter("chapId");
            Part part = request.getPart("Image");
            String knowledgeContent = part.getSubmittedFileName();

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
            
            /*Query for check whether Knowledge Name has existed*/
            IKnowledgeDAO knowledgeDAO = new KnowledgeDAO();
            boolean check = knowledgeDAO.searchByKnowledgeNameOfChap(knowledgeName, Integer.parseInt(chapId));
            /*If existed, reiderect*/
            if (!check) {
                request.setAttribute("nextId", knowledgeId);
                request.setAttribute("chapId", chapId);
                request.setAttribute("check", check);
                request.getRequestDispatcher("./view/CreateKnowledge.jsp").forward(request, response);
            } else {//If not, insert new Chapter into database
                KnowledgeBean knowledge = new KnowledgeBean(Integer.parseInt(knowledgeId), knowledgeName, "assets/image/Algebra/" + knowledgeContent, Integer.parseInt(chapId));
                knowledgeDAO.createKnowledge(knowledge);
                response.sendRedirect("AdminKnowledgeController?chapId=" + chapId);
            }
        }
    }

}
