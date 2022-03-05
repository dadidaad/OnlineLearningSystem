/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * KnowledgeController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         Doan Tu    First Implement
 */
package controller;

import bean.ChapterBean;
import bean.KnowledgeBean;
import bean.SubjectBean;
import dao.ChapterDAO;
import dao.IChapterDAO;
import dao.IKnowledgeDAO;
import dao.ISubjectDAO;
import dao.KnowledgeDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the Knowledge of chapter /Knowledge is the URL of the web site Extend
 * HttpServlet class
 *
 * @author Doan Tu
 */
public class KnowledgeController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /*Get ChapterID from request*/
            String chapterID = request.getParameter("chapId");

            /*Use DAO class to get data from database for Knowledge with corresponding ChapterID*/
            List<KnowledgeBean> knowledges = new ArrayList<>();
            IKnowledgeDAO knowledgeDAO = new KnowledgeDAO(); //Use IKnowledgeDAO interface to call
            knowledges = knowledgeDAO.getByChapterId(Integer.parseInt(chapterID));

            /*Use DAO class to get data from database for all Subject*/
            List<SubjectBean> subjects = new ArrayList<>();
            ISubjectDAO subjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            subjects = subjectDAO.getAllSubject();

            /*Use DAO class to get data for Current Chapter with correspoding ChapterID from request*/
            ChapterBean currentChapter = new ChapterBean();
            IChapterDAO chapterDAO = new ChapterDAO();
            currentChapter = chapterDAO.getChapterById(Integer.parseInt(chapterID));

            /*Attach Attribute for request and redirect it to SubjectDetail.jsp*/
            request.setAttribute("subjects", subjects);
            request.setAttribute("knowledges", knowledges);
            request.setAttribute("currentChapter", currentChapter);
            request.getRequestDispatcher("./view/KnowledgeDetail.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
