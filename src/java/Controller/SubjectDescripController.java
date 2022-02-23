/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * SubjectDescripController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         Doan Tu    First Implement
 */
package Controller;

import Bean.ChapterBean;
import Bean.SubjectBean;
import Dao.ChapterDAO;
import Dao.IChapterDAO;
import Dao.ISubjectDAO;
import Dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the user wants to see the Detail of subject
 * /SubjectDescrip is the URL of the web site
 * Extend HttpServlet class
 * 
 * @author Doan Tu
 */
public class SubjectDescripController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
                /*Get Subject ID from request*/
                String subjectId = request.getParameter("subId");
                
                /*Use DAO class to get data from database for Chapter with corresponding SubjectID*/
                ArrayList<ChapterBean> chapters = new ArrayList<>();
                IChapterDAO chapterDAO = new ChapterDAO();
                chapters = chapterDAO.getBySubId(Integer.parseInt(subjectId));
                
                /*Use DAO class to get data from database for all Subject*/
                ArrayList <SubjectBean> subjects = new ArrayList<>();
                ISubjectDAO subjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                subjects = subjectDAO.getAllSubject();
                
                /*Get Subject with corresponding SubjectID from request*/
                SubjectBean currentSubject = new SubjectBean();
                for (int i = 0; i < subjects.size(); i++) {
                    if(subjects.get(i).getSubjectID()==Integer.parseInt(subjectId)){
                        currentSubject = subjects.get(i);
                    }
                }
                
                /*Attach Attribute for request and redirect it to SubjectDetail.jsp*/
                request.setAttribute("subjects", subjects);
                request.setAttribute("chapters", chapters);
                request.setAttribute("currentSubject", currentSubject);
                request.getRequestDispatcher("./view/SubjectDetail.jsp").forward(request, response);
            } catch (SQLException ex) {
            Logger.getLogger(SubjectDescripController.class.getName()).log(Level.SEVERE, null, ex);
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
