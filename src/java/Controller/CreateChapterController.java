/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * CreateChapterController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-25   1.0         Doan Tu    First Implement
 */
package Controller;

import Bean.ChapterBean;
import Dao.ChapterDAO;
import Dao.IChapterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * Create new chapter and insert it into database. /CreateChapterController is the URL of the web site Extend
 * HttpServlet class
 *
 * @author Doan Tu
 */
@WebServlet(name = "CreateChapterController", urlPatterns = {"/CreateChapterController"})
public class CreateChapterController extends HttpServlet {

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
            /*Get data from Parameter of request*/
            String subId = request.getParameter("subId");
            
            /*get total Number Of Chapter*/
            IChapterDAO chapterDAO = new ChapterDAO();
            int numberOfChapter = chapterDAO.getNumberOfChapter() + 1;

            /*Attach nextID and subID Atrribute to request and redirect*/
            request.setAttribute("nextId", numberOfChapter);
            request.setAttribute("subId", subId);
            request.getRequestDispatcher("./view/CreateChapter.jsp").forward(request, response);
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
            /*Get data from Parameter of request*/
            String chapId = request.getParameter("chapId");
            String chapName = request.getParameter("chapName").replaceAll("\\s\\s+", " ").trim();;
            String chapContent = request.getParameter("chapContent").replaceAll("\\s\\s+", " ").trim();;
            String subId = request.getParameter("subId");
            
            /*Query for check whether Subject Name has existed*/
            IChapterDAO chapterDAO = new ChapterDAO();
            boolean check = chapterDAO.searchByChapNameOfSubject(chapName, Integer.parseInt(subId));
            
            /*If existed, reiderect*/
            if(check==false){
                request.setAttribute("nextId", chapId);
                request.setAttribute("subId", subId);
                request.setAttribute("check", check);
                request.getRequestDispatcher("./view/CreateChapter.jsp").forward(request, response);
            }else{//If not, insert new Chapter into database
                ChapterBean chapter = new ChapterBean(Integer.parseInt(chapId), chapName,0, chapContent, Integer.parseInt(subId));
                int numberOfRow = chapterDAO.CreateChapter(chapter);
                response.sendRedirect("AdminChapterController?subId="+subId);
            }
        }
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
