/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * AdminKnowledgeController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-24   1.0         Doan Tu    First Implement
 */
package controller;

import bean.AccountBean;
import bean.ChapterBean;
import bean.KnowledgeBean;
import bean.NotificationBean;
import dao.ChapterDAO;
import dao.IChapterDAO;
import dao.IKnowledgeDAO;
import dao.INotificationDAO;
import dao.ISubjectDAO;
import dao.KnowledgeDAO;
import dao.NotificationDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list of knowledges for Admin manage. /AdminKnowledgeController is the
 * URL of the web site Extend HttpServlet class
 *
 * @author Doan Tu
 */
@WebServlet(name = "AdminKnowledgeController", urlPatterns = {"/AdminKnowledgeController"})
public class AdminKnowledgeController extends HttpServlet {

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

            /*get data from Parameter of request*/
            String chapId = request.getParameter("chapId");

            /*Declare Variables*/
            ISubjectDAO subjectDAO = new SubjectDAO();
            IChapterDAO chapterDAO = new ChapterDAO();
            IKnowledgeDAO knowledgeDAO = new KnowledgeDAO();

            /*Queries to get number of Subject, Knowledge, Chapter*/
            int numberOfSubject = subjectDAO.getNumberOfSubject();
            int numberOfChapter = chapterDAO.getNumberOfChapter();
            int numberOfKnowledge = knowledgeDAO.getNumbberOfKnowledge();

            int[] numbers = new int[3];
            numbers[0] = numberOfSubject;
            numbers[1] = numberOfChapter;
            numbers[2] = numberOfKnowledge;

            /*Get Chapter and all Knowledge of the Chapter Queries*/
            List<KnowledgeBean> knowledges = new ArrayList<>();
            knowledges = knowledgeDAO.getByChapterId(Integer.parseInt(chapId));
            ChapterBean chapter = new ChapterBean();
            chapter = chapterDAO.getChapterById(Integer.parseInt(chapId));

            /*Attach knowledges, chapter, numbers attribute to request and ridirect*/
            request.setAttribute("knowledges", knowledges);
            request.setAttribute("chapter", chapter);
            request.setAttribute("numbers", numbers);

            request.getRequestDispatcher("./view/AdminKnowledge.jsp").forward(request, response);
        }
    }

}
