/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Online Learning System

 * ListAllRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-06   1.0         Danh Tinh   First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import bean.ReportBean;
import bean.RequestBean;
import bean.RequestReplyBean;
import bean.SubjectBean;
import dao.INotificationDAO;
import dao.ISubjectDAO;
import dao.NotificationDAO;
import dao.ReportDAO;
import dao.RequestDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tinht
 */
public class ReportListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if ((AccountBean) session.getAttribute("user") == null) {
            response.sendRedirect("LoginController");
        }

        /*Notification*/
        AccountBean account = (AccountBean) session.getAttribute("user");
        if (account != null) {
            INotificationDAO iNotificationDAO = new NotificationDAO();

            int notiUnread = iNotificationDAO.getTotalNotiUnread(account.getUsername());
            request.setAttribute("notiUnread", notiUnread);
            List<NotificationBean> notiList = iNotificationDAO.getTopNotification(account.getUsername());
            request.setAttribute("notificationList", notiList);
        }

        String status = (request.getParameter("status") == null) ? "report" : request.getParameter("status");

        String[] parts = status.split("-");
        String part1 = parts[0];
        String part2 = "";
        if (parts.length > 1) {
            part2 = parts[1];
        }

        if (status.equalsIgnoreCase("report")) {
            ArrayList<ReportBean> list;
            ReportDAO reportDB = new ReportDAO();
            list = reportDB.GetAllReport();
            request.setAttribute("reportList", list);
            request.getRequestDispatcher("./view/ReportList.jsp").forward(request, response);
        } else if (status.equalsIgnoreCase("feedback")) {
        } else if (part1.equalsIgnoreCase("detail")) {
            RequestBean rq = new RequestBean();
            RequestReplyBean rqReply = new RequestReplyBean();
            RequestDAO rqDB = new RequestDAO();

            rq = rqDB.getRequestById(Integer.parseInt(part2));
            rqReply = rqDB.getRequestReplyById(Integer.parseInt(part2));

            ISubjectDAO iSubjectDAO = new SubjectDAO();
            SubjectBean subject = iSubjectDAO.getSubjectById(rq.getSubjectID());

            request.setAttribute("title", rq.getTitle());
            request.setAttribute("subject", subject.getSubjectName());
            request.setAttribute("class", rq.getLevel());
            request.setAttribute("price", rq.getCost());
            request.setAttribute("content", rq.getContent());
            request.setAttribute("answer", rqReply.getContentReply());
            request.getRequestDispatcher("./view/ReportDetail.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
