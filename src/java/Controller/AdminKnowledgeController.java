/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * AdminKnowledgeController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-24   1.0         Doan Tu    First Implement
 */
package Controller;

import Bean.ChapterBean;
import Bean.KnowledgeBean;
import Dao.ChapterDAO;
import Dao.IChapterDAO;
import Dao.IKnowledgeDAO;
import Dao.ISubjectDAO;
import Dao.KnowledgeDAO;
import Dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list of knowledges for Admin manage. /AdminKnowledgeController is the URL of the web site Extend
 * HttpServlet class
 *
 * @author Doan Tu
 */
@WebServlet(name = "AdminKnowledgeController", urlPatterns = {"/AdminKnowledgeController"})
public class AdminKnowledgeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

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
            ArrayList<KnowledgeBean> knowledges = new ArrayList<>();
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
