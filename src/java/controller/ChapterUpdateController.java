/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ChapterBean;
import bean.SubjectBean;
import dao.ChapterDAO;
import dao.IChapterDAO;
import dao.ISubjectDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phong Vu
 */
@WebServlet(name = "ChapterUpdateController", urlPatterns = {"/ChapterUpdateController"})
public class ChapterUpdateController extends HttpServlet {

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
                String chapId = request.getParameter("chapId");
                
                ISubjectDAO subjectDAO = new SubjectDAO();
                IChapterDAO chapterDAO = new ChapterDAO();
                ChapterBean chapter = new ChapterBean();
                ArrayList<SubjectBean> subjects = new ArrayList<>();
                chapter = chapterDAO.getChapterById(Integer.parseInt(chapId));
                subjects = subjectDAO.getAllSubject();
                request.setAttribute("subjects", subjects);
                request.setAttribute("chapter", chapter);
                request.getRequestDispatcher("./view/UpdateChapter.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ChapterUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
            String chapName = request.getParameter("chapName").replaceAll("\\s\\s+", " ").trim();
            String currentName = request.getParameter("currentName").replaceAll("\\s\\s+", " ").trim();
            String chapContent = request.getParameter("chapContent").replaceAll("\\s\\s+", " ").trim();
            String subId = request.getParameter("subject");
            
            /*Query for check whether Subject Name has existed*/
            ISubjectDAO subjectDAO = new SubjectDAO();
            IChapterDAO chapterDAO = new ChapterDAO();
            
            boolean check = chapterDAO.searchByChapNameOfSubject(chapName, Integer.parseInt(subId));
            
            
            /*If existed, reiderect*/
            if(check==false && !chapName.equals(currentName)){
                ChapterBean chapter = chapterDAO.getChapterById(Integer.parseInt(chapId));
                
                ArrayList<SubjectBean> subjects = new ArrayList<>();
                subjects = subjectDAO.getAllSubject();
                
                request.setAttribute("chapter", chapter);
                request.setAttribute("subjects", subjects);
                request.setAttribute("check", check);
                request.getRequestDispatcher("./view/UpdateChapter.jsp").forward(request, response);
            }else{//If not, insert new Chapter into database
                ChapterBean chapter = new ChapterBean(Integer.parseInt(chapId), chapName,0, chapContent, Integer.parseInt(subId));
                int numberOfRow = chapterDAO.updateChapter(chapter);
                response.sendRedirect("AdminChapterController?subId="+subId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateChapterController.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
