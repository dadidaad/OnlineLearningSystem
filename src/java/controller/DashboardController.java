/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * CreateRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import dao.AccountDAO;
import dao.CounterViewDAO;
import dao.IAccountDAO;
import dao.ICounterViewDAO;
import dao.INotificationDAO;
import dao.IRequestDAO;
import dao.NotificationDAO;
import dao.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when Admin want to view
 * the dashboard of website /Dashboard is the URL of the Servlet Extend
 * HttpServlet class
 *
 * @author Duc Minh
 */
public class DashboardController extends HttpServlet {

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

            IAccountDAO iAccountDAO = new AccountDAO();
            IRequestDAO iRequestDAO = new RequestDAO();

            int totalAccount = iAccountDAO.totalAccount();
            int totalRequest = iRequestDAO.getTotalPendingRequest();
            int totalOnline = AccountBean.getSize();
            ServletContext ctx = getServletContext();
            Integer countPerDay = (Integer) ctx.getAttribute("pcount");
            ICounterViewDAO iCounterViewDAO = new CounterViewDAO();
            int totalView = iCounterViewDAO.getTotalView();
            request.setAttribute("totalAccount", totalAccount);
            request.setAttribute("totalRequest", totalRequest);
            request.setAttribute("totalOnline", totalOnline);
            request.setAttribute("totalView", totalView);
            request.setAttribute("countViewPage", countPerDay);
            request.getRequestDispatcher("./view/AdminDashboard.jsp").forward(request, response);
        } catch (Exception ex) {

        }
    }

}
