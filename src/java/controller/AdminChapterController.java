/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * AdminChapterController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-23   1.0         Doan Tu    First Implement
 */
package controller;

import bean.ChapterBean;
import bean.SubjectBean;
import dao.ChapterDAO;
import dao.IChapterDAO;
import dao.IKnowledgeDAO;
import dao.ISubjectDAO;
import dao.KnowledgeDAO;
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

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list of chapters for Admin manage. /AdminChapterController is the URL
 * of the web site Extend HttpServlet class
 *
 * @author Doan Tu
 */
@WebServlet(name = "AdminChapterController", urlPatterns = {"/AdminChapterController"})
public class AdminChapterController extends HttpServlet {
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
            String subId = request.getParameter("subId");

            /*Declare Varibales */
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

            /*Get Subject and all Chapter of the Subject Queries*/
            List<ChapterBean> chapters = new ArrayList<>();
            chapters = chapterDAO.getBySubId(Integer.parseInt(subId));
            SubjectBean subject = new SubjectBean();
            subject = subjectDAO.getSubjectById(Integer.parseInt(subId));

            /*Attach subjec, numbers and chapters to request and redirect*/
            request.setAttribute("subject", subject);
            request.setAttribute("numbers", numbers);
            request.setAttribute("chapters", chapters);
            request.getRequestDispatcher("./view/AdminChapter.jsp").forward(request, response);
        }
    }
}
