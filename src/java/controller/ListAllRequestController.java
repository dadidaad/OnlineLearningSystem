/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Online Learning System

 * ListAllRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         Duc Minh   First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import bean.RequestBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import dao.INotificationDAO;
import dao.IRequestDAO;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
import dao.NotificationDAO;
import dao.RequestDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import utils.SortRequest;
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
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list of Request /ListALlRequest is the URL of the Servlet Extend
 * HttpServlet class
 *
 * @author Duc Minh
 */
public class ListAllRequestController extends HttpServlet {

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

            HttpSession session = request.getSession();
            AccountBean account = (AccountBean) session.getAttribute("user");
            if (account != null) {
                SortRequest sortRequest = new SortRequest();//call the sort modify class
                List<RequestBean> requestList = new ArrayList<>();

                ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();

                IAccountDAO iAccountDAO = new AccountDAO(); //Use ISubjectDAO interface to call
                Map<String, String> DisplayNames = iAccountDAO.getDisplayNames();

                request.setAttribute("subjectNames", SubjectNames);
                request.setAttribute("displayNames", DisplayNames);

                INotificationDAO iNotificationDAO = new NotificationDAO();
                int totalNoti = iNotificationDAO.getTotalNoti(account.getUsername());
                List<NotificationBean> notiList = iNotificationDAO.getTopNotification(account.getUsername());
                request.setAttribute("totalNoti", totalNoti);
                request.setAttribute("notificationList", notiList);

                IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
                String rqStatus = request.getParameter("rqStatus");
                if (rqStatus == null) {
                    rqStatus = "Waiting";
                }
                request.setAttribute("status", rqStatus);

                String page = request.getParameter("page");
                if (page == null || page.length() == 0) {
                    page = "1";
                }
                int pageindex = Integer.parseInt(page);
                int pagesize = 10;
                int totalrow, totalpage;

                if (account.getRole().equalsIgnoreCase("student")) {

                    totalrow = iRequestDAO.getTotalRequestStudent(account.getUsername(), rqStatus);
                    totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;

                    requestList = iRequestDAO.getRequestForStudent(account.getUsername(), rqStatus, pageindex, pagesize);

                    request.setAttribute("requests", requestList);

                    request.setAttribute("totalpage", totalpage);
                    request.setAttribute("pageindex", pageindex);

                    /*Attach Attribute teachers for request and redirect it to ListAllRequestStu.jsp  */
                    request.getRequestDispatcher("./view/ListAllRequestStu.jsp").forward(request, response);

                } else if (account.getRole().equalsIgnoreCase("teacher")) {

                    ITeacherDAO iteacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
                    int subjectId = iteacherDAO.getSubjectId(account.getUsername());

                    if (rqStatus.equalsIgnoreCase("Approved") || rqStatus.equalsIgnoreCase("Report")) {
                        totalrow = iRequestDAO.getTotalRequestForTeacher(account.getUsername(), rqStatus);
                    } else {
                        totalrow = iRequestDAO.getTotalRequestForTeacher(subjectId, rqStatus);
                    }

                    totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;

                    if (rqStatus.equalsIgnoreCase("Approved") || rqStatus.equalsIgnoreCase("Report")) {
                        requestList = iRequestDAO.getRequestForTeacher(account.getUsername(), rqStatus, pageindex, pagesize);
                    } else {
                        requestList = iRequestDAO.getRequestForTeacher(subjectId, rqStatus, pageindex, pagesize);
                    }

                    request.setAttribute("totalpage", totalpage);
                    request.setAttribute("pageindex", pageindex);

                    /* Sort the list */
                    requestList = sortRequest.requestListSorted(requestList, account.getUsername());
                    request.setAttribute("requests", requestList);
                    /*Attach Attribute teachers for request and redirect it to ListAllRequestTea.jsp*/

                    request.getRequestDispatcher("./view/ListAllRequestTea.jsp").forward(request, response);
                }

            } /*Redirect it to Login*/ else {
                response.sendRedirect("Login");
            }
        } catch (Exception ex) {
            Logger.getLogger(ListAllRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
