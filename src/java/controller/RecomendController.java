/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.RecommendBean;
import bean.SubjectBean;
import dao.IRecommendDAO;
import dao.ISubjectDAO;
import dao.RecommendDAO;
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
@WebServlet(name = "RecomendController", urlPatterns = {"/RecomendController"})
public class RecomendController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ISubjectDAO subjectDAO = new SubjectDAO();
            ArrayList<SubjectBean> subjects = new ArrayList<>();
            
            subjects= subjectDAO.getAllSubject();
            
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("./view/Recommend.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RecomendController.class.getName()).log(Level.SEVERE, null, ex);
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
            String username = request.getParameter("username");
            String subjectId = request.getParameter("subject-select");
            String action = request.getParameter("action-select");
            String description = request.getParameter("description");
            boolean check;
            
            check = action.equals("1");
            
            RecommendBean recommed = new RecommendBean();
            recommed.setUsername(username);
            recommed.setSubjectID(Integer.parseInt(subjectId));
            recommed.setAction(check);
            recommed.setDescription(description);
            recommed.setStatus("waiting");
            
            IRecommendDAO recommendDAO = new RecommendDAO();
            recommendDAO.createRecommend(recommed);
            
            request.getRequestDispatcher("RecommendHistoryController").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RecomendController.class.getName()).log(Level.SEVERE, null, ex);
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
