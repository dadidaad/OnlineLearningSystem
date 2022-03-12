/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ConstantTableController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-22   1.0         Doan Tu    First Implement
 */
package controller;

import bean.AccountBean;
import bean.ConstantBean;
import bean.NotificationBean;
import bean.SubjectBean;
import dao.ConstantDAO;
import dao.IConstantDAO;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * View important Constant and searching. /ConstantTableController is the URL of
 * the web site Extend HttpServlet class
 *
 * @author Doan Tu
 */
@WebServlet(name = "ConstantTableController", urlPatterns = {"/ConstantTableController"})
public class ConstantTableController extends HttpServlet {

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
            /*Declare variable*/
            List<ConstantBean> constants = new ArrayList<>();
            IConstantDAO constantDAO = new ConstantDAO();
            constants = constantDAO.getAllConstant();

            List<SubjectBean> subjects = new ArrayList<>();
            ISubjectDAO subjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call

            /*Query to database*/
            subjects = subjectDAO.getAllSubject();

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
            
            /*Attach subjects and constants attribute to request and ridirect*/
            request.setAttribute("subjects", subjects);
            request.setAttribute("constants", constants);
            request.getRequestDispatcher("./view/ConstantLookUp.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConstantTableController.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*Get Parameter from request*/
            String name = request.getParameter("name").replaceAll("\\s\\s+", " ").trim();
            String sign = request.getParameter("sign").replaceAll("\\s\\s+", " ").trim();

            /*Declare variables*/
            IConstantDAO constantDAO = new ConstantDAO();
            List<ConstantBean> constants = new ArrayList<>();

            /*Search queries*/
            if (name.equals("")) {
                constants = constantDAO.getBySignOrConvention(sign);
            } else if (sign.equals("")) {
                constants = constantDAO.getByConstantName(name);
            } else {
                constants = constantDAO.getByNameAndSign(name, sign);
            }

            List<SubjectBean> subjects = new ArrayList<>();
            ISubjectDAO subjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            subjects = subjectDAO.getAllSubject();

            /*Attach constans, subjects attribute for request*/
            request.setAttribute("constants", constants);
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("./view/ConstantLookUp.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConstantTableController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
